//package assignment2.miniTwitter;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
/**
 * 
 * This class will create the GUI Frame for user when double clicking on the user name from root tree
 * a window will open with the user name info
 *
 */
public class UserFrame extends javax.swing.JFrame {

    private UserComponent user;
    
    /* Variables declaration to be initialized when instantiating an object of UserFrame type
     * when instantiating the object, initComponent will be called to initialize the following variables
     */
    
    private javax.swing.JButton followButton;
    private javax.swing.JLabel followingLabel;
    private javax.swing.JList<String> followingList;
    private DefaultListModel model;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lMessage;
    private javax.swing.JScrollPane messageTextArea;
    private javax.swing.JButton postMsgButton;
    private javax.swing.JLabel tweetLabel;
    private javax.swing.JTextArea tweetTextArea;
    private javax.swing.JList<String> tweetsList;
    private DefaultListModel tweetModel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField usernameTextField;
    protected long lastUpdateTime;
    protected String lastUpdatedUser;
    // End of variables declaration

    public UserFrame(UserComponent user) {
        this.user = user;
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        userLabel.setText(user.getName());
    }

    /*
     * This Method will be called by the constructor
     */
    
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        model = new DefaultListModel();
        followingList = new javax.swing.JList<>();
        userLabel = new javax.swing.JLabel();
        followButton = new javax.swing.JButton();
        postMsgButton = new javax.swing.JButton();
        followingLabel = new javax.swing.JLabel();
        messageTextArea = new javax.swing.JScrollPane();
        tweetTextArea = new javax.swing.JTextArea();
        usernameTextField = new javax.swing.JTextField();
        lMessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tweetModel = new DefaultListModel();
        tweetsList = new javax.swing.JList<>();
        tweetLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        followingList.setModel(model);
        for(UserComponent u : user.getFollowing()) {
            model.addElement(u.getName());
        }
        jScrollPane2.setViewportView(followingList);

        userLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 24)); 
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        followButton.setFont(new java.awt.Font("Arial", Font.BOLD, 20)); 
        followButton.setText("Follow");
        followButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followButtonActionPerformed(evt);
            }
        });

        this.setLocation(400, 200);
        this.setPreferredSize(new Dimension(500,700));
        postMsgButton.setFont(new java.awt.Font("Arial", Font.BOLD, 20)); 
        postMsgButton.setText("Tweet");
        postMsgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postMsgButtonActionPerformed(evt);
            }
        });
        
        followingLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        followingList.setFont(new java.awt.Font("Arial", Font.BOLD, 20)); 
        followingLabel.setText("Following");
        tweetTextArea.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        usernameTextField.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        tweetTextArea.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        messageTextArea.setViewportView(tweetTextArea);
        messageTextArea.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        tweetLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        lMessage.setForeground(new java.awt.Color(255, 0, 51));
        tweetsList.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        tweetsList.setModel(tweetModel);
        for(Tweet t : user.getTweets()) {
            tweetModel.addElement(t.getTweet());
        }
        jScrollPane1.setViewportView(tweetsList);

        tweetLabel.setText("Tweets");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(usernameTextField)
                                                .addComponent(followButton, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                                        .addComponent(followingLabel)
                                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(messageTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tweetLabel)
                                            .addGap(239, 239, 239))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(postMsgButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(userLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(followingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(followButton)))
                .addGap(18, 18, 18)
                .addComponent(messageTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postMsgButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweetLabel)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }

    private void followButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followButtonActionPerformed
        DefaultListModel model = (DefaultListModel) followingList.getModel();
        String username = usernameTextField.getText().trim();  
        try {
            lMessage.setText("");
            if (!username.equals("")) {
                user.addFollowing(username);
                model.addElement(username);
            }
        }
        catch (Exception e) {
            lMessage.setText(e.getMessage());
        }
    }

    private void postMsgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postMsgButtonActionPerformed
        DefaultListModel model = (DefaultListModel) tweetsList.getModel();
        String message = tweetTextArea.getText().trim();
        if (!message.equals("")) {
            Tweet tweet = user.postTweet(message);
            //notify observers
            model.addElement(tweet.getTweet());
        }
        lastUpdateTime = System.currentTimeMillis();
        lastUpdatedUser = user.name;
        
    }
    //this method will print the last update and posts was done
    //by the user or followers to the user
    public void lastUpdate(){
    	String lastUser = user.name;
    	Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(lastUpdateTime);
        System.out.println("Last update was performed on: " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE)+
        		" by " + lastUser);
    	
    }
    
    public String lastUpdatedID(){
    	return lastUpdatedUser;
    }

}
