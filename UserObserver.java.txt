//package assignment2.miniTwitter;

public class UserObserver implements ObserverInterface {

    private SubjectInterface subjectUser;
    
    public UserObserver(SubjectInterface subjectUser) {
        this.subjectUser = subjectUser;
        subjectUser.register(this);
    }
    
    @Override
    public void update(Component component) {
        this.subjectUser = component;
    }
    
}
