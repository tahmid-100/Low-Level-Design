
 public class WebhookNotifier implements NotificationService{
     
      public void send(String recipient,String message){
          
          System.out.println("Webhook URL "+recipient+"|| "+message);
      }
      
      
 }