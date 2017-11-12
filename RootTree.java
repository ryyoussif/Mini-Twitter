//package assignment2.miniTwitter;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;


// This class is used by the ControlPanel to seed initial data to the root tree
public class RootTree {
    
    private JTree tree;
    private TreeNode root;
    
    public RootTree() {
        // Create the root node
        Component root = new GroupComponent("Root", null);
        this.root = root;
        
        // Create the child nodes
        Component user1 = new UserComponent("Chris", (GroupComponent) root);
        Component user2 = new UserComponent("Ana", (GroupComponent) root);
 
        // Add the child nodes to the root node
        root.insert(user1);
        root.insert(user2);
         
        GroupComponent group = new GroupComponent("Go Broncos", (GroupComponent) root);
        root.insert(group);
        group.insert(new UserComponent("Ally", (GroupComponent) group));
        group.insert(new UserComponent("Frank", (GroupComponent) group));
        group.insert(new UserComponent("Debbie", (GroupComponent) group));
        
        // Create the tree by passing in the root node
        tree = new JTree(root);
    }

    public TreeNode getRoot() {
        return root;
    }
    
    
    public JTree getTree() {        
        return tree;
    }
    
    
}
