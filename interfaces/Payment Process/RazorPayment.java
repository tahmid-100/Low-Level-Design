public class RazorPayment implements PaymentGateway{
    
     public void initiatePayment(double amount){
         
         System.out.println("Processing RazorPayment of "+amount);
     }
}
