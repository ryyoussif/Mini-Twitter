
//package assignment2.miniTwitter;
/** 
 * TwitterDriver class contains main method to trigger the control panel when first 
 * starting the program. Control Panel class will initialize all objects using Singleton
 * Pattern
 */
public class TwitterDriver {

    public static void main(String args[]) {
        
    	//application program starts here
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ControlPanel controlPanel = ControlPanel.getInstance();                
                controlPanel.setVisible(true);
            }
        });
    }
      
}
