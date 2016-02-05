package simplechat;


import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *

 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
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
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
  }
  
  public ChatClient(String host, int port, ChatIF clientUI, String user) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
    //Must have space. Sets the command name seperate from user
      handleClientCommand("#setUser "+user);
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
  public void handleMessageFromServer(Object msg) 
  {
    if(msg instanceof Envelope){
        Envelope e = (Envelope)msg;
        handleEnvelopeFromServer(e);
    }
    else{
        clientUI.display(msg.toString());
    }
  }
  
  public void handleEnvelopeFromServer(Envelope e){
      if (e.getKey().equals("userList")) {
          String[] userList = (String[])e.getData();
          ((ClientConsole)clientUI).displayUsers(userList);
      }
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(String message)
  {
    if(message.charAt(0)=='#'){
        handleClientCommand(message);
    }
    
    else{
       try
    {
      sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    } 
    }
  }
  
  public void sendCommandToServer(String message)
  {
    try
    {
      sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    } 
  }
  
  public void handleClientCommand(String command){
      if(command.equals("#setHost")){
       int space = command.indexOf(" ");
       String host = command.substring(space, command.length());
       host.trim();
       
       if(!isConnected()){
           setHost(host);
       }
       else{
           clientUI.display(">>You are currently connected to a host");
           clientUI.display(">>Try again later.");
       }
      }

      else if(command.equals("#getPort")){
          clientUI.display("Current Port: "+ getPort());
      }
      else if(command.equals("#setPort")){
       int space = command.indexOf(" ");
       String port = command.substring(space, command.length());
       port.trim();
       
       if(!isConnected()){
           setPort(Integer.parseInt(port));
       }
       else{
           clientUI.display(">>You are currently connected to a host");
           clientUI.display(">>Try again later.");
       }
      }
      else if(command.equals("#quit")){
          //before quitting, tell the server you are leaving
          
          sendCommandToServer(command);
          quit();
      }
      
      
      else if(command.equals("#getHost")){
          clientUI.display("Current Host: "+ getHost());  
      }
       
      else if (command.equals("#logOff")) {
          try {
              closeConnection();
          } catch (IOException ioe) {
              System.out.println("Client unable to log off");
          }
      }
      else if (command.equals("#logIn")) {
          try {
              openConnection();
          } catch (IOException ioe) {
              System.out.println("Login attempt failed");
          }
      }
      
      else if (command.indexOf("#setUser")==0) {
          sendCommandToServer(command);
      }
      
      else if (command.indexOf("#join")==0) {
          sendCommandToServer(command);
      }
      
      else if (command.indexOf("#pm")==0) {
          sendCommandToServer(command);
      }
      
      else if (command.indexOf("#who")==0) {
          sendCommandToServer(command);
      }
      
  
  }
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class
