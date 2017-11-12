//package assignment2.miniTwitter;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.tree.DefaultTreeModel;

/**
 * Control Panel will use Singleton pattern to initialize all attributes of an object
 * it will contain the following features:
 * 1) output the total
 * number of users; 2) output the total number of groups; 3) output the total number of
 * Tweet messages in all the users’ news feed; 4) output the percentage of the positive
 * Tweet messages in all the users’ news feed (the message containing positive words,
 * such as good, great, excellent, etc.)
 *
 */
public class ControlPanel extends javax.swing.JFrame {

    private static ControlPanel instance;
    
    //Variables to be initialized when instantiating an object
    private javax.swing.JFrame jFrame1;
    private javax.swing.JButton createUserButton;
    private javax.swing.JButton createGroupButton;
    private javax.swing.JLabel adminLabel;
    private javax.swing.JLabel hintMessage;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JTextField userTextField;
    private javax.swing.JTextField groupTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private RootTree seeder;
    private javax.swing.JTree componentTree;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton totalUsersButton;
    private javax.swing.JButton totalTweetsButton;
    private javax.swing.JButton positiveTweetsButton;
    private javax.swing.JTextField totalUsersField;
    private javax.swing.JTextField totalGroupsField;
    private javax.swing.JButton totalGroupsButton;
    private javax.swing.JTextField totalTweetsField;
    private javax.swing.JTextField positiveTweetsField;
    // End of variables declaration

    private ControlPanel() {
        initComponents();
    }

    public static ControlPanel getInstance() {
        if (instance == null) {
            synchronized (ControlPanel.class) {
                if (instance == null) {
                    instance = new ControlPanel();
                }
            }
        }
        return instance;           
    }
    
    /**
     * initComponent method will initialize all attributes for an object one the. Once an object is instantiated
     * in main, the constructor is called which will call initComponents to initialize all variables
     */
    
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        createUserButton = new javax.swing.JButton();
        createGroupButton = new javax.swing.JButton();
        adminLabel = new javax.swing.JLabel();
        hintMessage = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        groupTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        seeder = new RootTree();
        componentTree = new javax.swing.JTree();
        infoLabel = new javax.swing.JLabel();
        totalUsersButton = new javax.swing.JButton();
        totalTweetsButton = new javax.swing.JButton();
        positiveTweetsButton = new javax.swing.JButton();
        totalUsersField = new javax.swing.JTextField();
        totalGroupsField = new javax.swing.JTextField();
        totalGroupsButton = new javax.swing.JButton();
        totalTweetsField = new javax.swing.JTextField();
        positiveTweetsField = new javax.swing.JTextField();
        this.setLocation(400, 200);
        this.setPreferredSize(new Dimension(1000,700));
        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        componentTree.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        createUserButton.setText("create");
        createUserButton.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        createUserButton.setToolTipText("");
        createUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserButtonActionPerformed(evt);
            }
        });

        createGroupButton.setText("create");
        createGroupButton.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        createGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGroupButtonActionPerformed(evt);
            }
        });

        adminLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20)); 
        adminLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adminLabel.setText("Control Panel");
        hintMessage.setForeground(new java.awt.Color(255, 0, 0));
        hintMessage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userLabel.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        userLabel.setText("Create user name:");
        groupLabel.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        groupLabel.setText("Create group name:");

        // Call RootTree to seed initial data
        javax.swing.tree.TreeNode rootNode = seeder.getRoot();
        componentTree.setModel(new javax.swing.tree.DefaultTreeModel(rootNode));
        jScrollPane1.setViewportView(componentTree);

        componentTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedActionPerformed(evt);
            }
        });

        infoLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 15)); 
        infoLabel.setText("**Double click on any user for more info");
        totalUsersButton.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        totalUsersButton.setText("Total Users");
        totalUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalUsersButtonActionPerformed(evt);
            }
        });
        
        totalTweetsButton.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        totalTweetsButton.setText("Total Tweets");
        totalTweetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTweetsButtonActionPerformed(evt);
            }
        });
        
        positiveTweetsButton.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        positiveTweetsButton.setText("Positive Tweets %");
        positiveTweetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positiveTweetsButtonActionPerformed(evt);
            }
        });

        totalGroupsButton.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        totalGroupsButton.setText("Total Groups");
        totalGroupsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalGroupsButtonActionPerformed(evt);
            }
        });
        userTextField.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        groupTextField.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        totalUsersField.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        totalGroupsField.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        totalTweetsField.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        positiveTweetsField.setFont(new java.awt.Font("Arial",Font.PLAIN, 20));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adminLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                .addGap(71, 71, 71))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hintMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userLabel)
                                    .addComponent(groupLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userTextField)
                                    .addComponent(groupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(createUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(createGroupButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalGroupsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(totalUsersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalGroupsField)
                                    .addComponent(totalUsersField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(positiveTweetsButton)
                                    .addComponent(totalTweetsButton))))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalTweetsField)
                            .addComponent(positiveTweetsField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adminLabel)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createUserButton)
                            .addComponent(userLabel)
                            .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createGroupButton)
                            .addComponent(groupLabel)
                            .addComponent(groupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalUsersButton)
                            .addComponent(totalUsersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalTweetsButton)
                            .addComponent(totalTweetsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalGroupsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalGroupsButton)
                            .addComponent(positiveTweetsButton)
                            .addComponent(positiveTweetsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hintMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        pack();
    }
   
    //User frame will open when user clicks on user component from root tree
    private void mouseClickedActionPerformed(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            Component node = (Component) componentTree.getLastSelectedPathComponent();
            if (node != null && node instanceof UserComponent) {
                // Open user frame
                Frame userFrame = new UserFrame((UserComponent) node);   
            }
        }
    }
    
    private VisitorInterface letVisitorTraverseTree(VisitorInterface visitor) {
        DefaultTreeModel model = (DefaultTreeModel) componentTree.getModel();
        Component root = (GroupComponent) model.getRoot();
        Component.traverseTree(root, visitor);
        return visitor;
    }
    
    /* 
     * this method will create a new user and add it to the root tree.
     * If no user name entered, hintMessage will display an error message
     */
    private void createUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        hintMessage.setText("");        
        DefaultTreeModel model = (DefaultTreeModel) componentTree.getModel();
        Component root = (GroupComponent) model.getRoot();
        Component selectedNode = (Component) componentTree.getLastSelectedPathComponent();
        String username = userTextField.getText().trim();
        
        if (username.equals("")) {
            hintMessage.setText("Please enter a user name to be created");
        }
        else {
            if (selectedNode != null) {
                if (selectedNode instanceof GroupComponent) {
                    Component newUser = new UserComponent(username, (GroupComponent) selectedNode);      
                    System.out.println("New user created: " + username);
            
                    hintMessage.setText(""); 
                    model.insertNodeInto(newUser, selectedNode, selectedNode.getChildCount());
                    model.reload(newUser);
                }
                else {
                    hintMessage.setText("User can only be added to a group");
                }
            }
            else {
                Component newUser = new UserComponent(username, (GroupComponent) root);  
                System.out.println("New user created: " + username);
                root.insert(newUser);     
                model.reload();
            }            
        }
    }

    /* 
     * This method will create new group and add it to root tree. 
     * If no group name entered, hintMessage will display an error message 
     */
    private void createGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        hintMessage.setText("");
        DefaultTreeModel model = (DefaultTreeModel) componentTree.getModel();
        Component root = (GroupComponent) model.getRoot();
        Component selectedNode = (Component) componentTree.getLastSelectedPathComponent();
        String groupName = groupTextField.getText();
        
        if (groupName.trim().equals("")) {
            hintMessage.setText("Please enter a group name to be created");
        }
        else {
            if (selectedNode != null) {
                if (selectedNode instanceof GroupComponent) {
                    Component newGroup = new GroupComponent(groupName, (GroupComponent) selectedNode);      
                    System.out.println("New group created: " + groupName);
                        
                    hintMessage.setText(""); 
                    model.insertNodeInto(newGroup, selectedNode, selectedNode.getChildCount());
                    model.reload(newGroup);
                }
                else {
                    hintMessage.setText("Group can only be added inside a group");
                }
            }
            else {                     
                Component newGroup = new GroupComponent(groupName, (GroupComponent) root);
                System.out.println("New group created: " + groupName);
                root.insert(newGroup);
                model.reload();
            }
        }        
    }

    /* this method will call visitor to obtain total number of positive tweets */
    private void positiveTweetsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            hintMessage.setText("");
            TweetVisitor tweetVisitor = (TweetVisitor) letVisitorTraverseTree(new TweetVisitor());
            positiveTweetsField.setText(String.valueOf(tweetVisitor.getPercentageOfPositiveTweets()));
        }
        catch (Exception e) {
            hintMessage.setText(e.getMessage());
        }
    }

    /* Thsi method will call visitor to obtain total number of users */
    private void totalUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Visitor visitor = (Visitor) letVisitorTraverseTree(new Visitor());
        totalUsersField.setText(String.valueOf(visitor.getTotalUsers()));
    }

    /* This method will call visitor to obtain total number of groups */
    private void totalGroupsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Visitor visitor = (Visitor) letVisitorTraverseTree(new Visitor());
        totalGroupsField.setText(String.valueOf(visitor.getTotalGroups()));
    }

    /* this method will call visitor to obtain total number of tweet messages */
    private void totalTweetsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TweetVisitor tweetVisitor = (TweetVisitor) letVisitorTraverseTree(new TweetVisitor());
        totalTweetsField.setText(String.valueOf(tweetVisitor.getTotalTweets()));
    }

    
}
