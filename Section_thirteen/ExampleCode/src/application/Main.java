package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        // UpCasting

        Account accountOne = new BusinessAccount(500, 1, "Abner", 1500);
        Account accountTwo = new SavingsAccount(2, "Yasmin", 2000, 10.0);
        Account accountThree = new Account(3, "Wesley", 3000);

        out.println("Acconut #1");
        out.println(accountOne);

        out.println("Acconut #2");
        out.println(accountTwo);

        out.println("Acconut #3");
        out.println(accountThree);

        out.println("-------------------------------");

        if (accountTwo instanceof BusinessAccount) {
            BusinessAccount bAccount = (BusinessAccount)accountTwo;
            bAccount.loan(400);
            out.println("Business Account");
            out.println(bAccount);
         }

        if (accountTwo instanceof SavingsAccount) {
            SavingsAccount sAccount = (SavingsAccount)accountTwo;
            sAccount.updateBalance();
            out.println("Savings Account");
            out.println(sAccount);
        }
    }
}