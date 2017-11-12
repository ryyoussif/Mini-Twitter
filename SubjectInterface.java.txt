//package assignment2.miniTwitter;

public interface SubjectInterface {
    
    public void register(ObserverInterface newObserver);
    public void unregister(ObserverInterface existingObserver);
    public void notifyObserver();
    
}
