package customersortandsearch;

import objects.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CustomerSortAndSearch {

    public static void main(String[] args) {
        var customerList = new ArrayList<Customer>();
        customerList.add(new Customer(95, "May", "may@yahoo.com", "04-20182020"));
        customerList.add(new Customer(60, "James", "james@outlook.com", "04-66241369"));
        customerList.add(new Customer(88, "Robert", "robert@hotmail.com", "04-33804668"));
        customerList.add(new Customer(25, "Lily", "lily@gmail.com", "04-54198762"));
        customerList.add(new Customer(10, "Linda", "linda@live.com", "04-61584805"));
        System.out.println("Unsorted customer lists ---");
        for (var cust : customerList) {
            cust.display();
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Please enter a customer number to search, "
                    + "press S to sort, R to randomise or Q to quit: ");
            String input = sc.next();
            while (!input.equals("Q")) {
                try {
                    if (input.equals("S")) {
                        Collections.sort(customerList);
                        System.out.println("Sorted customer lists ---");
                        for (var cust : customerList) {
                            cust.display();
                        }
                    } else if (input.equals("R")) {
                        Collections.shuffle(customerList);
                        System.out.println("Randomised customer lists ---");
                        for (var cust : customerList) {
                            cust.display();
                        }
                    } else {
                        System.out.println("Search for customer ID : " + Integer.valueOf(input));
                        searchId(Integer.valueOf(input), customerList);
                    }
                    System.out.println();
                    System.out.print("Please enter a customer number to search, "
                            + "press S to sort, R to randomise or Q to quit: ");
                    input = sc.next();
                } catch (Exception ex) {
                    System.out.println("Invalid input --> " + ex);
                    System.out.println();
                    System.out.print("Please enter a customer number to search, "
                            + "press S to sort, R to randomise or Q to quit: ");
                    input = sc.next();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void searchId(int id, ArrayList<Customer> customers) {
        int result = 0;
        for (var cust : customers) {
            result = Integer.valueOf(id).compareTo(cust.getId());
            if (result == 0) {
                System.out.println("Customer ID: " + id + " found:-");
                cust.display();
                break;
            }
        }
        if (result != 0) {
            System.out.println("Customer ID: " + id + " not found!");
        }
        System.out.println();
    }
}
