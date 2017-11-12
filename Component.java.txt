//package assignment2.miniTwitter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

 
/**
 * Component class will demonstrate Composite and Observer Pattern
 */
public abstract class Component implements MutableTreeNode, SubjectInterface, VisitableInterface {

    protected String name;
    protected GroupComponent parentComponent;
    protected List<Component> children;
    private ArrayList<ObserverInterface> observers;
    
    public Component() {
        observers = new ArrayList<ObserverInterface>();
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public abstract void displayInfo();

    public void insert(MutableTreeNode child) {
        if (this.getAllowsChildren()) {
            this.children.add((Component) child);
        }
    }
    
    public GroupComponent getRoot() {
        GroupComponent parent = (GroupComponent) this.getParent();
        if (parent == null) {
            return (GroupComponent) this;
        }        
        return parent.getRoot();
    }    
    
    // method created to traverse the tree and count total number of components
    public static void traverseTree(Component component, VisitorInterface v){
        component.accept(v);        
        if (!component.isLeaf()) {            
            for (Component c : component.children) {
                traverseTree(c, v);
            }
        }     
    }
    
    /**
     * Observer Pattern 
     */
    @Override
    public void register(ObserverInterface newObserver) {
        observers.add(newObserver);
        System.out.println("New observer added to component " + this.name);
    }

    @Override
    public void unregister(ObserverInterface existingObserver) {
        observers.remove(existingObserver);
        System.out.println("Observer removed from component " + this.name);
    }

    @Override
    public void notifyObserver() {
        for (ObserverInterface o : observers) {
            o.update(this);
        }
        System.out.println("Observers from component " + this.name + " have been notified");
    }
    
    // Override MutableTreeNode methods. Component implements MutableTreeNode so it can be used and displayed in the TreeView     
    @Override
    public void insert(MutableTreeNode child, int index) {
        if (this.getAllowsChildren()) {
            this.children.add(index, (Component) child);
        }
    }

    @Override
    public void remove(int index) {
        if (!this.isLeaf()) {
            this.children.remove(index);
        }
    }

    @Override
    public void remove(MutableTreeNode node) {
        if (!this.isLeaf()) {
            this.children.remove((Component) node);
        }
    }

    @Override
    public void setUserObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeFromParent() {
        this.parentComponent.children.remove(this);
    }

    @Override
    public void setParent(MutableTreeNode newParent) {
        this.parentComponent = (GroupComponent) newParent;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return this.isLeaf() ? null : this.children.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return this.isLeaf() ? 0 : this.children.size();
    }

    @Override
    public TreeNode getParent() {
        return this.parentComponent;
    }

    @Override
    public int getIndex(TreeNode node) {
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return (!(this instanceof UserComponent)); 
    }

    @Override
    public boolean isLeaf() {
        return this.children == null;
    }

    @Override
    public Enumeration children() {
        return this.isLeaf() ? null : (Enumeration) this.children;
    }
    
}
