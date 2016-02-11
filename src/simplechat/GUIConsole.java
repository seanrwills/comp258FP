package simplechat;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import static simplechat.ClientConsole.DEFAULT_PORT;

/**
 *
 * @author wills5140
 */
public class GUIConsole extends JFrame implements ChatIF{
    
    final public static int DEFAULT_PORT = 5555;
    private JButton closeB = new JButton("Close");
    private JButton openB = new JButton("Open");
    private JButton sendB = new JButton("Send");
    private JButton quitB = new JButton("Quit");
	
    private JTextField portTxF = new JTextField("5555");
    private JTextField hostTxF = new JTextField("127.0.0.1");
    private JTextField messageTxF = new JTextField("");
	
    private JLabel portLB = new JLabel("Port: ", JLabel.RIGHT);
    private JLabel hostLB = new JLabel("Host: ", JLabel.RIGHT);
    private JLabel messageLB = new JLabel("Message: ", JLabel.RIGHT);
	
    private JTextArea messageList = new JTextArea();
    
    private ChatClient client;

    public GUIConsole(){}
    public GUIConsole( String host, int port, String user){
		
	super("Simple Chat GUI");
	setSize(300, 400);
		
	setLayout( new BorderLayout(5,5));
	Panel bottom = new Panel();
	add( "Center", messageList );
	add( "South" , bottom);
		
	bottom.setLayout( new GridLayout(5,2,5,5));
	bottom.add(hostLB); 		
        bottom.add(hostTxF);
	bottom.add(portLB); 		
        bottom.add(portTxF);
	bottom.add(messageLB); 	
        bottom.add(messageTxF);
	bottom.add(openB); 		
        bottom.add(sendB);
	bottom.add(closeB); 		
        bottom.add(quitB);

	setVisible(true);
        //An anonymous inner class
        //How a lot of event hadlers are assigned in GUIs
        sendB.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
		send(messageTxF.getText()+"\n");
            }
        });
        
        try 
        {
            client = new ChatClient(host, port, this, user);
        } 
        catch(IOException exception) 
        {
            System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
            System.exit(1);
        }
}
    public void display( String message ){
		messageList.insert(message, 0);
	}
    
    public void send(String msg){
        client.handleMessageFromClientUI(msg);
    }

    public static void main (String args[]){
        String user = "";  
        String host = "";
        int port = 0;  //The port number

    try
    {
      host = args[0];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      host = "localhost";
    }
    
    try 
    {
       port = Integer.parseInt(args[1]);
    }  
    
    catch (ArrayIndexOutOfBoundsException e) {
          port = DEFAULT_PORT;
    }
    
    try 
    {
       user = args[2];
    } 
    catch (ArrayIndexOutOfBoundsException e) 
    {
       user = "guest";
    }
      
    GUIConsole gc = new GUIConsole(host,port,user);
    }
}
