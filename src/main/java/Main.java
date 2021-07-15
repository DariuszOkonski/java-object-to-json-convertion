import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setName("YRR");
        c1.setCustID("123XYZ");
        c1.setOverdue(45.6f);


        String response = convertCustomerToJSON(c1);
        System.out.println(response);
        System.out.println(response instanceof String);


        addToFile(response);
    }

    public static Customer convertJsonToCustomer(String jsonFormat) {
        Gson json = new Gson();
        Customer customer = json.fromJson(jsonFormat, Customer.class);
        return customer;
    }

    public static String convertCustomerToJSON(Customer customer) {
        Gson json = new Gson();
        String response = json.toJson(customer);
        return response;
    }

    public static void addToFile(String jsonToFile) {
        try {
            FileWriter myWriter = new FileWriter("src/filename.csv", true);
            myWriter.write(jsonToFile+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}