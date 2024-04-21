import javax.swing.JOptionPane;
import java.util.ArrayList;

class AddressBook {
    public String name;
    public String address;
    public int phoneNumber;

    public void addPerson() {
        name = JOptionPane.showInputDialog("Enter your name:");
        address = JOptionPane.showInputDialog("Enter your address:");
        try {
            phoneNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter your phone number:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter numeric values.");
            return;
        }
    }

    public static void deletePerson(ArrayList<AddressBook> list) {
        boolean found = false;
        String delName = JOptionPane.showInputDialog("Enter the name of the person you want to delete:");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.equals(delName)) {
                list.remove(i);
                found = true;
                JOptionPane.showMessageDialog(null, "Data found and successfully deleted!");
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Data not found.");
        }
    }

    public static void searchPerson(ArrayList<AddressBook> list) {
        boolean found = false;
        String searchName = JOptionPane.showInputDialog("Enter the name of the person you want to search:");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.equals(searchName)) {
                JOptionPane.showMessageDialog(null, "Data\nName: " + list.get(i).name + "\nAddress: " + list.get(i).address + "\nPhone Number: " + list.get(i).phoneNumber);
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No person found with that name.");
        }
    }
}

public class Person {
    public static void main(String[] args) {
        ArrayList<AddressBook> addressList = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Welcome to the app!");
        do {
            int choice = 0;
                choice = Integer.parseInt(JOptionPane.showInputDialog("Enter your Choice:\n1. Add Person\n2. Delete Person\n3. Search Person\n4. Exit"));
            switch (choice) {
                case 1:
                    AddressBook newPerson = new AddressBook();
                    newPerson.addPerson();
                    if (newPerson.name != null && !newPerson.name.isEmpty()) {
                        addressList.add(newPerson);
                    }
                    break;
                case 2:
                    AddressBook.deletePerson(addressList);
                    break;
                case 3:
                    AddressBook.searchPerson(addressList);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    return;
                default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                break;
            }
        } 
        while (true);
    }
}
