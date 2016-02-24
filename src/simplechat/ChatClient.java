package simplechat;

import java.awt.Toolkit;
import java.io.*;
import java.io.File;
import javax.swing.JOptionPane;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 *
 */
public class ChatClient extends AbstractClient {
    //Instance variables **********************************************

    /**
     * The interface type variable. It allows the implementation of the display
     * method in the client.
     */
    ChatIF clientUI;

    //Constructors ****************************************************
    /**
     * Constructs an instance of the chat client.
     *
     * @param host The server to connect to.
     * @param port The port number to connect on.
     * @param clientUI The interface type variable.
     */
    public ChatClient(String host, int port, ChatIF clientUI)
            throws IOException {
        super(host, port); //Call the superclass constructor
        this.clientUI = clientUI;
        openConnection();
    }

    public ChatClient(String host, int port, ChatIF clientUI, String user)
            throws IOException {
        super(host, port); //Call the superclass constructor
        this.clientUI = clientUI;
        openConnection();
        //Must have space. Sets the command name seperate from user
        handleClientCommand("#setUser " + user);
        handleClientCommand("#join default");
    }

    //Instance methods ************************************************
    /**
     * This method handles all data that comes in from the server.
     *
     * @param msg The message from the server.
     */
    /*Any message from the server will be handled here or 
  will pass through this method. May implementa "whisper"*/
    public void handleMessageFromServer(Object msg) {

        if (msg instanceof Envelope) {
            Envelope e = (Envelope) msg;
            handleEnvelopeFromServer(e);
        } 
        
        else {
            String message = msg.toString();
            //if (message.charAt(0) ==  '#') {
            if (message.equals("#ping")) {

                clientUI.display("PING!!!!! \n");
                Toolkit.getDefaultToolkit().beep();
            } 
            else {
                ((GUIChat)clientUI).display(message);
            }
        }
    }
    //}

    public void handleEnvelopeFromServer(Envelope e) {
        if (e.getKey().equals("userList")) {
            String[] userList = (String[]) e.getData();
            ((GUIChat) clientUI).displayUserList(userList);
        } 
        else if (e.getKey().equals("room")) {
            String[] userRoom = (String[]) e.getData();
            ((GUIChat) clientUI).displayRoomList(userRoom);
        }
        else if (e.getKey().equals("sendFile")){
            File f = e.getFile();
            String fileName = f.getName();
            byte[] fileContents = (byte[]) e.getData();
            try{
            saveFile(fileName, fileContents);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    /**
     * This method handles all data coming from the UI
     *
     * @param message The message from the UI.
     */
     public static void saveFile(String fileName, byte[] fileContents) throws Exception {

        FileOutputStream fos = new FileOutputStream("C:\\BISMFileStore\\" + fileName);
        fos.write(fileContents);
        fos.close();
        JOptionPane.showConfirmDialog(null, "New File Saved");
        System.out.println("File saved successfully!");
    }
    public void handleMessageFromClientUI(String message) {
        if (message.charAt(0) == '#') {
            handleClientCommand(message);
        } else {
            try {
                sendToServer(message);
            } catch (IOException e) {
                clientUI.display("Could not send message to server.  Terminating client.");
                quit();
            }
        }
    }

    public void handleEnvelopeFromClientUI(Envelope e) {
        if (e.getKey().equals("sendFile")) {
            File f = e.getFile();
            String fileLocation = f.getAbsolutePath();
            try {
                Envelope fts = new Envelope(e.getKey(), getFileBytes(fileLocation), f, e.getDestinationUserName());
                sendToServer(fts);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public void sendCommandToServer(String message) {
        try {
            sendToServer(message);
        } catch (IOException e) {
            clientUI.display("Could not send message to server.  Terminating client.");
            quit();
        }
    }

    public static byte[] getFileBytes(String fileLocation) throws IOException {

        //Specify the file
        File file = new File(fileLocation);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        //Read File Contents into contents array 
        byte[] contents = new byte[(int) file.length()];
        long fileLength = file.length();
        long current = 0;

        long start = System.nanoTime();
        while (current != fileLength) {
            int size = (int) file.length();
            if (fileLength - current >= size) {
                current += size;
            } else {
                size = (int) (fileLength - current);
                current = fileLength;
            }
            contents = new byte[size];
            bis.read(contents, 0, size);

        }
        return contents;
    }

    public void handleClientCommand(String command) {
        if (command.equals("#setHost")) {
            int space = command.indexOf(" ");
            String host = command.substring(space, command.length());
            host.trim();

            if (!isConnected()) {
                setHost(host);
            } else {
                clientUI.display(">>You are currently connected to a host");
                clientUI.display(">>Try again later.");
            }
        } else if (command.equals("#getPort")) {
            clientUI.display("Current Port: " + getPort());
        } else if (command.equals("#setPort")) {
            int space = command.indexOf(" ");
            String port = command.substring(space, command.length());
            port.trim();

            if (!isConnected()) {
                setPort(Integer.parseInt(port));
            } else {
                clientUI.display(">>You are currently connected to a host");
                clientUI.display(">>Try again later.");
            }
        } else if (command.equals("#quit")) {
            //before quitting, tell the server you are leaving

            sendCommandToServer(command);
            quit();
        } else if (command.equals("#getHost")) {
            clientUI.display("Current Host: " + getHost());
        } else if (command.equals("#logOff")) {
            try {
                closeConnection();
            } catch (IOException ioe) {
                System.out.println("Client unable to log off");
            }
        } else if (command.equals("#logIn")) {
            try {
                openConnection();
            } catch (IOException ioe) {
                System.out.println("Login attempt failed");
            }
        } else if (command.indexOf("#setUser") == 0) {
            sendCommandToServer(command);
        } else if (command.indexOf("#join") == 0) {
            sendCommandToServer(command);
        } else if (command.indexOf("#pm") == 0) {
            sendCommandToServer(command);
        } else if (command.indexOf("#who") == 0) {
            sendCommandToServer(command);
        }
    }

    /**
     * This method terminates the client.
     */
    public void quit() {
        try {
            closeConnection();
        } catch (IOException e) {
        }
        System.exit(0);
    }
}
//End of ChatClient class
