package th.ac.ku.atm;

import java.util.HashMap;
import java.util.Map;

public class DataSourceWebAPI implements DataSource {
    @Override
    public Map<Integer, Customer> readCustomers() {
        Map<Integer, Customer> customers = new HashMap<>();
        customers.put(1, new Customer(1, "Zygnus",1234,120000));
        customers.put(2, new Customer(2,"Mim",2345,16000));
        customers.put(3,new Customer(3, "Mobile",3456,34000));
        return customers;
    }
}
