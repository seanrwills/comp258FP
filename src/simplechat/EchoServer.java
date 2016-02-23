package simplechat;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.

 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
    public void handleMessageFromClient(Object msg, ConnectionToClient client) {
        if (msg instanceof Envelope) {
            Envelope e = (Envelope)msg;
            if (e.getKey().equals("sendFile")) {
                File f = e.getFile();
                String fileName = f.getName();
                byte[] fileContents = (byte[])e.getData();
                //1.Save to server
                try{
                    saveFile(fileName, fileContents);
                }
                
                catch (Exception exc){
                    exc.printStackTrace();
                }
                
                
            }
        } else {
            String message = msg.toString();
            if (message.charAt(0) == '#') {
                if (message.equals("#quit")) {
                    clientException(client, new Exception("Client has left"));

                } else if (message.indexOf("#setUser") == 0) {
                    int space = message.indexOf(" ");
                    int end = message.length();
                    String user = message.substring(space, end);
                    user.trim();
                    client.setInfo("username", user);
                    sendUserListToAllClients();
                } else if (message.indexOf("#who") == 0) {
                    sendUserListToAllClients();
                    sendRoomListToAllClients();
                } else if (message.indexOf("#join") == 0) {
                    int space = message.indexOf(" ");
                    int end = message.length();
                    String room = message.substring(space, end);
                    room.trim();
                    client.setInfo("room", room);
                    sendRoomListToAllClients();
                } else if (message.indexOf("#pm") == 0) {
                    int start = message.indexOf(" ");
                    int end = message.length();
                    String msgWOCommand = message.substring(start, end);
                    int space = msgWOCommand.indexOf(" ");
                    String target = msgWOCommand.substring(0, space);
                    String whisper = msgWOCommand.substring(space, end);
                    target = target.trim();
                    whisper = whisper.trim();
                    sendToAClient(whisper, client, target);
                } else if (message.indexOf("#userList") == 0) {
                    sendClientList(client);
                } else if (message.indexOf("#ping") == 0) {
                    sendToAllClients("#ping");
                }

            } else {
                System.out.println("Message received: " + msg + " from " + client.getInfo("username"));
                /*Good place to insert if statements
          i.e. send to a client or all clients in room*/
//          this.sendToAllClients(client.getInfo("username")+ ":"+msg);
                this.sendToAllClientsInRoom(client.getInfo("username") + ":" + msg, client);
            }

        }

    }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
 public void sendToAllClientsInRoom(Object msg, ConnectionToClient client)
  {
    Thread[] clientThreadList = getClientConnections();
    String room = client.getInfo("room").toString();
    
    for (int i=0; i<clientThreadList.length; i++)
    {
        
        ConnectionToClient target = ((ConnectionToClient)clientThreadList[i]);
        String targetRoom = target.getInfo("room").toString();
        
        if (room.equals(targetRoom)) {
            try {
                target.sendToClient(msg);
            } 
            catch (Exception e) {
                
            }
        }
      }
  }
 
 public void sendToAClient(Object msg, ConnectionToClient client, String pmTarget)
  {
    Thread[] clientThreadList = getClientConnections();
    String pmSender = client.getInfo("username").toString();
    msg = "PM from "+pmSender+": "+msg;
    
    for (int i=0; i<clientThreadList.length; i++)
    {
       String pmRecipient = ((ConnectionToClient)clientThreadList[i]).getInfo("username").toString();
       
       if(pmRecipient.equals(pmTarget)){
           try {
                ((ConnectionToClient)clientThreadList[i]).sendToClient(msg);
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
       }      
      }
  }
 
 //VIJAYS CODE: INVITING A CLIENT TO A ROOM.
// public void InviteClientToARoom(ConnectionToClient client){
//     Thread[] clientThreadList = getClientConnections();
//     
//     for (int i=0; i<clientThreadList.length; i++)
//     {
//         ConnectionToClient target = ((ConnectionToClient)clientThreadList[i]);
//     }
//     
//     
//     
// }
 
 public void sendToAClientsInRoom(Object msg, ConnectionToClient client)
  {
    Thread[] clientThreadList = getClientConnections();
    String room = client.getInfo("room").toString();
    
    for (int i=0; i<clientThreadList.length; i++)
    {
        
        ConnectionToClient target = ((ConnectionToClient)clientThreadList[i]);
        String targetRoom = target.getInfo("room").toString();
        
        if (room.equals(targetRoom)) {
            try {
                target.sendToClient(msg);
            } 
            catch (Exception e) {
                
            }
        }
      }
  }
 
 public void sendClientList(ConnectionToClient client){
     Thread[] clientThreadList = getClientConnections();
     String[] userList = new String[clientThreadList.length];
     for (int i=0; i<clientThreadList.length; i++){
         String aUser = ((ConnectionToClient)clientThreadList[i]).getInfo("username").toString();
         userList[i] = aUser;
     }
     Envelope e = new Envelope("userList", userList);
     try {
         client.sendToClient(e);
     } catch (Exception ex) {
         System.out.println("Wow, do better next time!");
     }
 }

   public void sendUserListToAllClients()
  {
    Thread[] clientThreadList = getClientConnections();
    String[] userList = new String[clientThreadList.length];
   
    
    for (int i=0; i<clientThreadList.length; i++)
    {
      try
      {
        userList[i]=((ConnectionToClient)clientThreadList[i]).getInfo("username").toString();
      }
      catch (Exception ex) {}
    }
    
     Envelope e = new Envelope("userList", userList);
    
    for (int i=0; i<clientThreadList.length; i++)
    {
      try
      {
        ((ConnectionToClient)clientThreadList[i]).sendToClient(e);
      }
      catch (Exception ex) {}
    }
  }
 
 
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  
 protected void clientConnected(ConnectionToClient client) {
         System.out.println(client+" has connected.");
         //send clent list to all clients on new connection
 }

  /**
   * Hook method called each time a client disconnects.
   * The default implementation does nothing. The method
   * may be overridden by subclasses but should remains synchronized.
   *
   * @param client the connection with the client.
   */
  synchronized protected void clientDisconnected(ConnectionToClient client) {
      

      System.out.println(client+" has disconnected. clientDisconnect");
  }
  
  synchronized protected void clientException(ConnectionToClient client, Throwable exception) {
      
 
      System.out.println(client+" has disconnected. clientException");
  }
 
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
      
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
     
     
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
    
    
  }

    private void sendRoomListToAllClients() {
        
    Thread[] clientThreadList = getClientConnections();
    String[] roomList = new String[clientThreadList.length];
   
    
    for (int i=0; i<clientThreadList.length; i++)
    {
      try
      {
        roomList[i]=((ConnectionToClient)clientThreadList[i]).getInfo("room").toString();
      }
      catch (Exception ex) {}
    }
    
     Envelope e = new Envelope("room", roomList);
    
    for (int i=0; i<clientThreadList.length; i++)
    {
      try
      {
        ((ConnectionToClient)clientThreadList[i]).sendToClient(e);
      }
      catch (Exception ex) {}
    }
    }
    
    public static void saveFile(String fileName, byte[] fileContents)throws Exception{
        
        ObjectInputStream ois = new ObjectInputStream(null);
        FileOutputStream fos = new FileOutputStream("C:\\BISMFileStore\\"+fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        
        //No of bytes read in one read() call
        int bytesRead = 0; 
        
        while((bytesRead=ois.read(fileContents))!=-1)
            bos.write(fileContents, 0, bytesRead); 
        
        bos.flush(); 
        System.out.println("File saved successfully!");
    }
    
    
    public static void sendFile(String ipAddress,int portNo,String fileLocation) throws IOException{
       //Initialize Sockets
        ServerSocket ssock = new ServerSocket(portNo);
        Socket socket = ssock.accept();
        
        //The InetAddress specification
        InetAddress IA = InetAddress.getByName("localhost"); 
        
        //Specify the file
        File file = new File(fileLocation);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis); 
          
        //Get socket's output stream
        OutputStream os = socket.getOutputStream();
                
        //Read File Contents into contents array 
        byte[] contents;
        long fileLength = file.length(); 
        long current = 0;
         
        long start = System.nanoTime();
        while(current!=fileLength){ 
            int size = 10000;
            if(fileLength - current >= size)
                current += size;    
            else{ 
                size = (int)(fileLength - current); 
                current = fileLength;
            } 
            contents = new byte[size]; 
            bis.read(contents, 0, size); 
            os.write(contents);
            System.out.print("Sending file ... "+(current*100)/fileLength+"% complete!");
        }   
        
        os.flush(); 
        //File transfer done. Close the socket connection!
        socket.close();
        ssock.close();
        System.out.println("File sent succesfully!"); 
    }
    
}


//End of EchoServer class
