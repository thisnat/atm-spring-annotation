package th.ac.ku.atm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class DataSourceFile implements DataSource {

    private String filename;

    public DataSourceFile(@Value("${filepath}") String filename){
        this.filename=filename;
    }
    public Map<Integer, Customer> readCustomers(){
        Map<Integer, Customer> customers = new HashMap<>();

        Scanner in;

        try {
            in = new Scanner(new FileReader(this.filename));
        } catch (FileNotFoundException e) {
            System.err.println("Problem reading a customer file: "+filename);
            return customers;
        }

        while (in.hasNext()) {
            int number = in.nextInt();
            String name = in.next();
            int pin = in.nextInt();
            double currentBalance = in.nextDouble();
            Customer c = new Customer(number, name, pin, currentBalance);
            customers.put(c.getId(), c);
        }
        in.close();
        return customers;
    }
}
