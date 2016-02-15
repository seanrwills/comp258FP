package simplechat;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import static simplechat.ClientConsole.DEFAULT_PORT;


public class GUIStart extends javax.swing.JFrame implements ChatIF {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        scrollbar3 = new java.awt.Scrollbar();
        scrollbar4 = new java.awt.Scrollbar();
        jPanelUsers = new javax.swing.JPanel();
        jLblUsers = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListUsers = new javax.swing.JList();
        jPanelChat = new javax.swing.JPanel();
        scrollbarChat = new java.awt.Scrollbar();
        jPanelRooms = new javax.swing.JPanel();
        jLblRoom = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListRooms = new javax.swing.JList();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuItemChangeUserName = new javax.swing.JMenuItem();
        jMenuMessaging = new javax.swing.JMenu();
        jMenuItemPrivateMessage = new javax.swing.JMenuItem();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemJoin = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblUsers.setText("Users");

        jListUsers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListUsers);

        javax.swing.GroupLayout jPanelUsersLayout = new javax.swing.GroupLayout(jPanelUsers);
        jPanelUsers.setLayout(jPanelUsersLayout);
        jPanelUsersLayout.setHorizontalGroup(
            jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelUsersLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLblUsers))
        );
        jPanelUsersLayout.setVerticalGroup(
            jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsersLayout.createSequentialGroup()
                .addComponent(jLblUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanelChatLayout = new javax.swing.GroupLayout(jPanelChat);
        jPanelChat.setLayout(jPanelChatLayout);
        jPanelChatLayout.setHorizontalGroup(
            jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollbarChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelChatLayout.setVerticalGroup(
            jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollbarChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLblRoom.setText("Rooms");

        jListRooms.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListRooms);

        javax.swing.GroupLayout jPanelRoomsLayout = new javax.swing.GroupLayout(jPanelRooms);
        jPanelRooms.setLayout(jPanelRoomsLayout);
        jPanelRoomsLayout.setHorizontalGroup(
            jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoomsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanelRoomsLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLblRoom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRoomsLayout.setVerticalGroup(
            jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoomsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar.setBackground(new java.awt.Color(151, 0, 204));
        jMenuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar.setForeground(new java.awt.Color(102, 51, 255));

        jMenuFile.setText("File");
        jMenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileActionPerformed(evt);
            }
        });

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemExit.setText("Exit");
        jMenuFile.add(jMenuItemExit);

        jMenuItemChangeUserName.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemChangeUserName.setText("Change User Name");
        jMenuFile.add(jMenuItemChangeUserName);

        jMenuBar.add(jMenuFile);

        jMenuMessaging.setText("Messaging");

        jMenuItemPrivateMessage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPrivateMessage.setText("Private Message");
        jMenuMessaging.add(jMenuItemPrivateMessage);

        jMenuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNew.setText("New Room");
        jMenuMessaging.add(jMenuItemNew);

        jMenuItemJoin.setText("Join Room");
        jMenuMessaging.add(jMenuItemJoin);

        jMenuBar.add(jMenuMessaging);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelChat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFileActionPerformed

    final public static int DEFAULT_PORT = 5555;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLblRoom;
    public javax.swing.JLabel jLblUsers;
    private javax.swing.JList jListRooms;
    private javax.swing.JList jListUsers;
    public javax.swing.JMenuBar jMenuBar;
    public javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItemChangeUserName;
    public javax.swing.JMenuItem jMenuItemExit;
    public javax.swing.JMenuItem jMenuItemJoin;
    public javax.swing.JMenuItem jMenuItemNew;
    public javax.swing.JMenuItem jMenuItemPrivateMessage;
    public javax.swing.JMenu jMenuMessaging;
    public javax.swing.JPanel jPanelChat;
    public javax.swing.JPanel jPanelRooms;
    public javax.swing.JPanel jPanelUsers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Scrollbar scrollbar3;
    private java.awt.Scrollbar scrollbar4;
    private java.awt.Scrollbar scrollbarChat;
    // End of variables declaration//GEN-END:variables
  
    private ChatClient client;
    
    /**
     * Creates new form GUI
     */
    public GUIStart() {
        initComponents();
        //set client and initialize connection
    }
    
    public GUIStart(String host, int port, String user){
        initComponents();
        setVisible(true);
        
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIStart().setVisible(true);
//            }
//        }); 
        String user = "";  
        String host = "";
        int port = 0;  //The port number
        
        try {
            host = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            host ="localhost";
        }
        
        try {
            port = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            port=DEFAULT_PORT;
        }
        
        try {
            user = args[2];
        } catch (Exception e) {
            user = "guest";
        }
        
        GUIStart gs = new GUIStart(host, port, user);
        }
            
    public void handleUserList(String[] list){
        
        //loop through list to poulate userlist on gui  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    @Override
    public void display(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

