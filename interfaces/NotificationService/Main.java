/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/


public class Main {
    public static void main(String[] args) {
        
        NotificationService emailNotify=new EmailNotifier();
        
        AlertService  emailAlert=new AlertService(emailNotify);
        
        emailAlert.triggerAlert("ops@company.com", "CPU usage at 95%");
        
        
        
        NotificationService slackNotify = new SlackNotifier();
        
        AlertService slackAlert =new AlertService(slackNotify);
        
        slackAlert.triggerAlert("#incidents", "Database connection pool exhausted");

        
               
    }
}
