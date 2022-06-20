package objects;

public class Customer implements Comparable<Customer> {

    private int id;
    private String name;
    private String email;
    private String mobile;

    public Customer(int id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public void display() {
        System.out.println("Customer ID: " + id + ", name: " + name
                + ", \tmobile: " + mobile + ", \temail: " + email);
    }

    public int getId() {
        return id;
    }

    public int compareTo(Customer compareCust) {
        Integer compareId = compareCust.getId();
        return Integer.valueOf(this.id).compareTo(compareId);
    }
}
