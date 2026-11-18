

import java.util.ArrayList;
import java.util.Scanner;

public class communityResources {

    ArrayList<Integer> storedZips = new ArrayList<>();
    ArrayList<String> resources = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public communityResources(ArrayList<String> resources) {
        this.resources = resources;
    }

    public int askZipcode() {
        System.out.print("Enter your zipcode: ");
        String zipcode = scanner.nextLine();

        while (!zipcode.matches("\\d{5}")) {
            System.out.print("Invalid zipcode. Please enter 5 digits: ");
            zipcode = scanner.nextLine();
        }

        System.out.println("Valid zipcode: " + zipcode);
        return Integer.parseInt(zipcode);
    }

    public void compareZip() {
        int zipcode = askZipcode();

        if (storedZips.contains(zipcode)) {
            // null - call method that returns stored resources
        }
    }

    public void addZip(int zip) {
        storedZips.add(zip);
    }
}