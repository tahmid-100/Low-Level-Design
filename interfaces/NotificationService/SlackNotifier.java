
 public class SlackNotifier implements NotificationService{
     
      public void send(String recipient,String message){
          
          System.out.println("Slack Channel "+recipient+"|| "+message);
      }
      
      
 }