//package assignment2.miniTwitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class UserComponent extends Component {
    
    private Set<UserComponent> following;
    private ArrayList<Tweet> tweets;
    
    public UserComponent(String name, GroupComponent parent) {
        this.name = name;
        this.parentComponent = parent;
        following = new HashSet<UserComponent>();
        tweets = new ArrayList<Tweet>();
    }
    
    // Used to display it in the JList in user frame
    public List<UserComponent> getFollowing() {
        return new ArrayList<UserComponent>(this.following);
    }
    
    public void addFollowing(String username) throws Exception {
        if (username.equals(this.name)) {
            throw new UnsupportedOperationException("Cannot follow yourself");
        }
        GroupComponent root = this.getRoot();
        UserComponent newFollowing = searchForUser(username, root);  
        if (newFollowing != null) {
            boolean added = this.following.add(newFollowing);
            if (added) {
                System.out.println(this.name + " just followed " + newFollowing.getName());              
            }
            else {
                throw new UnsupportedOperationException(this.name + " is already following " + newFollowing.getName());
            }
        }
        else {
            throw new UnsupportedOperationException("Username cannot be found");
        }
    }
    
    public Tweet postTweet(String message) {
        Tweet tweet = new Tweet(message);
        tweets.add(tweet);
        System.out.println(this.name + " posted a tweet");
        return tweet;
    }
    
    public ArrayList<Tweet> getTweets() {
        return tweets;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("User: " + this.name);
    }
    
    /* UserComponent will use depth first search to traverse the tree 
     * and will find the correct user */
    public static UserComponent searchForUser(String username, Component node) {        
        if (node instanceof UserComponent && node.getName().equals(username)) {
            return (UserComponent) node;
        }
        UserComponent correctNode = null;
        if (!node.isLeaf()) {            
            for (Component c : node.children) {
                if (correctNode != null) 
                    break;
                correctNode = searchForUser(username, c);
            }
        }
        return correctNode;
    }
    
    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserComponent)) {
            return false;
        }
        UserComponent user = (UserComponent) obj;
        return Objects.equals(this.name, user.getName());
    }
    

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.parentComponent.hashCode();
        return result;
    }

}

