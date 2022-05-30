import java.util.Scanner;

public class ATM{
     public static void main(String[] args) {
         int temp_pin = 1521;
         String temp_card = "1234567891";
         double bal = 0.0;
         boolean flag = true;
        System.out.println("Please Enter your card details:");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int pin = sc.nextInt();
        int errcode = 0;
        if(str.length() != 10 || pin != temp_pin || Integer.parseInt(str) != Integer.parseInt(temp_card)){
            errcode = 1;
            System.out.println("Please enter a valid card details");
            System.exit(errcode);
        }
        else{
            while(flag == true)
        {//    Long card = Long.parseLong(str);
           System.out.println("1.Check balance");
           System.out.println("2.Withdraw money");
           System.out.println("3.Deposit money");
           System.out.println("4.Pin Generation");
           System.out.println("5.Exit");
           System.out.println("Enter Choice:");
           int n = sc.nextInt();
        switch(n){
            case 1:
                double temp_bal = checkbalance(bal);
                bal = temp_bal;
                    System.out.println(bal);
                break;
            case 2:
                double wbal = checkbalance(bal);
                if(wbal == 0){
                    System.out.println("Balance cannot be negative!Minimum balance must be maintained.");
                }
                else{
                    System.out.println("Enter amount to be withdrawn:");
                    int wmon = sc.nextInt();
                    wbal = withdraw(wbal,wmon);
                    System.out.println("Please wait until the money gets despenced.Collect your Money");
                    bal = wbal;
                }
                break;
            case 3:
            System.out.println("Enter the amount to be deposited:");
            int dep_amt = sc.nextInt();
                double dbal = deposit(dep_amt,bal);
                System.out.println("Amount got deposited successfully.");
                bal = dbal;
                break;
            case 4:
                System.out.println("Enter your current pin:");
                int cur_pin = sc.nextInt();
                if(cur_pin == pin){
                    int new_pin = sc.nextInt();
                     cur_pin = pingeneration(cur_pin,new_pin);
                     pin = cur_pin;
                }
                else{
                    System.out.println("Entered Pin is Incorrect!!");
                }
                break;
            case 5:
                flag = false;
                errcode = 1;
                System.exit(errcode);
                break;                
           }
        }
            }
        sc.close();
        
    }

    public static double checkbalance(double temp_bal){
            return temp_bal;
    } 
    
    public static double withdraw(double wbal,int wmon){
        wbal = wbal-wmon;
        return wbal;
} 
public static int pingeneration(int cur_pin,int new_pin){
              cur_pin = new_pin;
              return cur_pin;
}

public static double deposit(double dep_amt,double bal){
          bal = bal +dep_amt;
          return bal;
}
}