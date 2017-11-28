//package assignment2.miniTwitter;

import java.util.ArrayList;
import java.util.Calendar;

 
public class GroupComponent extends Component {
	private long creationTime;
	
    
    public GroupComponent(String name, GroupComponent parent) {
        this.name = name;
        this.parentComponent = parent;
        this.children = new ArrayList<Component>();
    }
    
    @Override
    public void displayInfo() {
        System.out.println("GroupComponent: " + this.name);        
        if (!this.isLeaf()) {
            for (Component c : this.children) {
                c.displayInfo();
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(creationTime);
        System.out.println(this.name + " was created on " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
    }
    
    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }

}
