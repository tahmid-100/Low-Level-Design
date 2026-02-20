
 public class EmailNotifier implements NotificationService{
     
      public void send(String recipient,String message){
          
          System.out.println("Email to "+recipient+"|| "+message);
      }
      
      
 }