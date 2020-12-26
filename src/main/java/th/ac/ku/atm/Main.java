package th.ac.ku.atm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ATM atm = context.getBean(ATM.class);

        String name = atm.validateCustomer(3,7899);
        Bank bank = context.getBean(Bank.class);
        System.out.println("Welcome to "+bank.getName()+"!");
        int dep = 9985;
        int wit = 2165;

        System.out.println(name+" current balance is "+atm.getBalance()+" THB");

        atm.deposit(dep);
        System.out.println(name+" has deposit " + dep +" THB");
        System.out.println(name+" has "+atm.getBalance());

        atm.withdraw(wit);
        System.out.println(name+" has withdraw " + wit +" THB");
        System.out.println(name+" has "+atm.getBalance());
    }
}
