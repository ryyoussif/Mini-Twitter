//package assignment2.miniTwitter;

// This class will track the total number of users and groups created

public class Visitor implements VisitorInterface {

    private int totalUsers = 0;
    private int totalGroups = 0;
    
    /* getTotalUsers will return total number of users created*/
    public int getTotalUsers() {
        return totalUsers;
    }
    
    /* getTotalGroups will return total number of groups created*/
    public int getTotalGroups() {
        return totalGroups;
    }

    @Override
    public void visit(UserComponent user) {
        totalUsers += 1;
    }

    @Override
    public void visit(GroupComponent group) {
        totalGroups += 1;
    }
    
}
