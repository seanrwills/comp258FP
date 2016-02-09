package simplechat;

import java.io.*;


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
  public void handleMessageFromClient(Object msg, ConnectionToClient client)
  {
      String message = msg.toString();
      if(message.charAt(0)=='#'){
          if (message.equals("#quit")) {
              clientException(client, new Exception("Client has left"));
              //clientDisconnected(client);
          } 
          else if(message.indexOf("#setUser")==0){
          int space = message.indexOf(" ");
          int end = message.length();
          String user = message.substring(space, end);
          user.trim();
          client.setInfo("username", user);
         }
          else if(message.indexOf("#who")==0){
          sendClientList(client);
          }
          else if(message.indexOf("#join")==0){
            int space = message.indexOf(" ");
            int end = message.length();
            String room = message.substring(space, end);
            room.trim();
            client.setInfo("room", room);
          }
          else if(message.indexOf("#pm")==0){
            int start = message.indexOf(" ");
            int end = message.length();
            String msgWOCommand = message.substring(start, end);
            int space = msgWOCommand.indexOf(" ");
            String target = msgWOCommand.substring(0,space);
            String whisper = msgWOCommand.substring(space, end);
            target = target.trim();
            whisper = whisper.trim();
            sendToAClient(whisper,client,target); 
          } 
          else if(message.indexOf("#userList") == 0){
            sendClientList(client);
          }
          
          
      }
      else{
          System.out.println("Message received: " + msg + " from " + client.getInfo("username"));
          /*Good place to insert if statements
          i.e. send to a client or all clients in room*/
//          this.sendToAllClients(client.getInfo("username")+ ":"+msg);
          this.sendToAllClientsInRoom(client.getInfo("username")+ ":"+msg, client);
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
      
      System.out.println(client+" has disconnected.");
  }
  
  synchronized protected void clientException(
    ConnectionToClient client, Throwable exception) {
      
      System.out.println(client+" has disconnected");
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
}
//End of EchoServer class
