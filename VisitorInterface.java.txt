//package assignment2.miniTwitter;


public interface VisitorInterface {
    // Method overloading to visit the right object
    public void visit(UserComponent user);
    public void visit(GroupComponent group);
}