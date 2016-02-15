package simplechat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import static simplechat.ClientConsole.DEFAULT_PORT;


public class GUIChat extends javax.swing.JFrame implements ChatIF {

    //public GUIStart guiStart;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        scrollbar3 = new java.awt.Scrollbar();
        scrollbar4 = new java.awt.Scrollbar();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextChat = new javax.swing.JTextField();
        jPanelUsers = new javax.swing.JPanel();
        scrollbarUsers = new java.awt.Scrollbar();
        jLblUsers = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jPanelChat = new javax.swing.JPanel();
        scrollbarChat = new java.awt.Scrollbar();
        jBtnSend = new javax.swing.JButton();
        jBtnUpload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuItemChangeUserName = new javax.swing.JMenuItem();
        jMenuMessaging = new javax.swing.JMenu();
        jMenuItemPrivateMessage = new javax.swing.JMenuItem();
        jMenuItemPingChatroom = new javax.swing.JMenuItem();
        jMenuItemPingContact = new javax.swing.JMenuItem();
        jMenuRoom = new javax.swing.JMenu();
        jMenuItemLeave = new javax.swing.JMenuItem();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemJoin = new javax.swing.JMenuItem();
        jMenuItemEdit = new javax.swing.JMenuItem();
        jMenuSend = new javax.swing.JMenu();
        jMenuItemBroadcast = new javax.swing.JMenuItem();
        jMenuItemPicture = new javax.swing.JMenuItem();
        jMenuItemFile = new javax.swing.JMenuItem();
        jMenuItemContact = new javax.swing.JMenuItem();
        jMenuItemMyIP = new javax.swing.JMenuItem();
        jMenuItemDicPic = new javax.swing.JMenuItem();
        jMenuItemCoordinates = new javax.swing.JMenuItem();
        jMenuEmoji = new javax.swing.JMenu();
        jMenuItemSendEmoji = new javax.swing.JMenuItem();
        jMenuItemCreateEmoji = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        fileChooser.setDialogTitle("BIS Messenger FIle Upload");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BIS Messenger");

        jTextChat.setText("jTextInputText");
        jTextChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextChatActionPerformed(evt);
            }
        });

        jLblUsers.setText("Users");

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        javax.swing.GroupLayout jPanelUsersLayout = new javax.swing.GroupLayout(jPanelUsers);
        jPanelUsers.setLayout(jPanelUsersLayout);
        jPanelUsersLayout.setHorizontalGroup(
            jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsersLayout.createSequentialGroup()
                .addGroup(jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsersLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLblUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(jPanelUsersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(scrollbarUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelUsersLayout.setVerticalGroup(
            jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsersLayout.createSequentialGroup()
                .addGroup(jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollbarUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelUsersLayout.createSequentialGroup()
                        .addComponent(jLblUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelChatLayout = new javax.swing.GroupLayout(jPanelChat);
        jPanelChat.setLayout(jPanelChatLayout);
        jPanelChatLayout.setHorizontalGroup(
            jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChatLayout.createSequentialGroup()
                .addGap(0, 435, Short.MAX_VALUE)
                .addComponent(scrollbarChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelChatLayout.setVerticalGroup(
            jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollbarChat, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );

        jBtnSend.setText("Send");
        jBtnSend.setToolTipText("");
        jBtnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSendActionPerformed(evt);
            }
        });

        jBtnUpload.setBackground(new java.awt.Color(189, 10, 252));
        jBtnUpload.setText("Upload File");
        jBtnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUploadActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

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

        jMenuItemPingChatroom.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPingChatroom.setText("Ping Chat Room");
        jMenuMessaging.add(jMenuItemPingChatroom);

        jMenuItemPingContact.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPingContact.setText(" Ping Contact");
        jMenuMessaging.add(jMenuItemPingContact);

        jMenuBar.add(jMenuMessaging);

        jMenuRoom.setText("Room");

        jMenuItemLeave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLeave.setText("Leave Room");
        jMenuItemLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLeaveActionPerformed(evt);
            }
        });
        jMenuRoom.add(jMenuItemLeave);

        jMenuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNew.setText("New Room");
        jMenuRoom.add(jMenuItemNew);

        jMenuItemJoin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemJoin.setText("Join Room");
        jMenuRoom.add(jMenuItemJoin);

        jMenuItemEdit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEdit.setText("Edit Room Name");
        jMenuRoom.add(jMenuItemEdit);

        jMenuBar.add(jMenuRoom);

        jMenuSend.setText("Send");

        jMenuItemBroadcast.setText("Broadcast");
        jMenuSend.add(jMenuItemBroadcast);

        jMenuItemPicture.setText("Picture");
        jMenuSend.add(jMenuItemPicture);

        jMenuItemFile.setText("File");
        jMenuSend.add(jMenuItemFile);

        jMenuItemContact.setText("Contact");
        jMenuSend.add(jMenuItemContact);

        jMenuItemMyIP.setText("My IP");
        jMenuSend.add(jMenuItemMyIP);

        jMenuItemDicPic.setText("Dick Pic");
        jMenuSend.add(jMenuItemDicPic);

        jMenuItemCoordinates.setText("Coordinates");
        jMenuSend.add(jMenuItemCoordinates);

        jMenuBar.add(jMenuSend);

        jMenuEmoji.setText("Emoji");

        jMenuItemSendEmoji.setText("Send Emoji");
        jMenuEmoji.add(jMenuItemSendEmoji);

        jMenuItemCreateEmoji.setText("Create Emoji");
        jMenuEmoji.add(jMenuItemCreateEmoji);

        jMenuBar.add(jMenuEmoji);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextChat, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnUpload)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSend)
                    .addComponent(jBtnUpload))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextChatActionPerformed

    private void jMenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFileActionPerformed

    private void jMenuItemLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLeaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemLeaveActionPerformed

    private void jBtnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSendActionPerformed
        // TODO add your handling code here:
        //An anonymous inner class
        //How a lot of event hadlers are assigned in GUIs
        //jBtnSend.jBtnSendActionPerformed( new ActionListener() {
        //    public void actionPerformed(ActionEvent e)
            {
		send(jTextChat.getText()+"\n");
            }
        //});
        
    }//GEN-LAST:event_jBtnSendActionPerformed
//Upload button click event
    private void jBtnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUploadActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
          //What to do with the file, e.g. display it in a TextArea
          textArea.read( new FileReader( file.getAbsolutePath() ), null );
        } catch (IOException ex) {
          System.out.println("problem accessing file"+file.getAbsolutePath());
        }
    } else {
        System.out.println("File access cancelled by user.");
    }
    }//GEN-LAST:event_jBtnUploadActionPerformed

     
    
    
    final public static int DEFAULT_PORT = 5555;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jBtnSend;
    private javax.swing.JButton jBtnUpload;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLblUsers;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEmoji;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemBroadcast;
    private javax.swing.JMenuItem jMenuItemChangeUserName;
    private javax.swing.JMenuItem jMenuItemContact;
    private javax.swing.JMenuItem jMenuItemCoordinates;
    private javax.swing.JMenuItem jMenuItemCreateEmoji;
    private javax.swing.JMenuItem jMenuItemDicPic;
    private javax.swing.JMenuItem jMenuItemEdit;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemFile;
    private javax.swing.JMenuItem jMenuItemJoin;
    private javax.swing.JMenuItem jMenuItemLeave;
    private javax.swing.JMenuItem jMenuItemMyIP;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemPicture;
    private javax.swing.JMenuItem jMenuItemPingChatroom;
    private javax.swing.JMenuItem jMenuItemPingContact;
    private javax.swing.JMenuItem jMenuItemPrivateMessage;
    private javax.swing.JMenuItem jMenuItemSendEmoji;
    private javax.swing.JMenu jMenuMessaging;
    private javax.swing.JMenu jMenuRoom;
    private javax.swing.JMenu jMenuSend;
    private javax.swing.JPanel jPanelChat;
    private javax.swing.JPanel jPanelUsers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextChat;
    private java.awt.Scrollbar scrollbar3;
    private java.awt.Scrollbar scrollbar4;
    private java.awt.Scrollbar scrollbarChat;
    private java.awt.Scrollbar scrollbarUsers;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
    private ChatClient client;
 
    
    public GUIChat() {
        initComponents();
    }

    public GUIChat(String host, int port, String user){
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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIChat().setVisible(true);
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

        GUIChat gc = new GUIChat(host, port, user);
        
    }
   
    @Override
    public void display(String message) {
        textArea.insert(message, 0);
    }
    
    public void send(String msg){
        client.handleMessageFromClientUI(msg);
    }
}
