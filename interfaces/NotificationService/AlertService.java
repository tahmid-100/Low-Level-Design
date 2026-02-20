
 public class AlertService {
     
     private NotificationService notifier;
     
     AlertService(NotificationService notifier){
         
         this.notifier=notifier;
     }
     
     public void triggerAlert(String recipient , String issue){
         
         notifier.send(recipient,issue);
     }
     
 }