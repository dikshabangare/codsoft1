import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact
{
	private String name;
	private String phoneNumber;
	private String email;
	private String otherDetails;
	
	public Contact(String name, String phoneNumber, String email, String otherDetails)
	{
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.otherDetails=otherDetails;
	}
	
	public String toString()
	{
		return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email + ", Other Details: " + otherDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
	//getter and setter if needed
	
	
}

class AdressBook
{
	private List<Contact> contacts;
	
	public AdressBook()
	{
		this.contacts=new ArrayList<>();
	}
	
	public void AddContact(Contact contact)
	{
		contacts.add(contact);
	}
	
	public void removeContact(String name)
	{
		contacts.removeIf(contact->contact.getName().equals(name));
	}
	
	public Contact searchContact(String name)
	{
		for(Contact contact: contacts)
		{
			if(contact.getName().equals(name))
			{
				return contact;
			}
		}
		return null;
	}
	
	public void displayAllContacts()
	{
		for(Contact contact:contacts)
		{
			System.out.println(contact);
		}
	}
	
	public void saveToFile(String filename) throws IOException
	{
		 try (PrintWriter writer = new PrintWriter(filename)) {
	            for (Contact contact : contacts) {
	                writer.println(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail() + "," + contact.getOtherDetails());
	            }
	        }
	}
	
	public void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    AddContact(new Contact(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        }
    }
}

public class AdressBookSystem {

	public static void main(String[] args) {
		
		AdressBook adressbook=new AdressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Save Contacts to File");
            System.out.println("6. Load Contacts from File");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter other details (optional): ");
                    String otherDetails = scanner.nextLine();
                    adressbook.AddContact(new Contact(name, phoneNumber, email, otherDetails));
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    System.out.print("Enter name of contact to remove: ");
                    String nameToRemove = scanner.nextLine();
                    adressbook.removeContact(nameToRemove);
                    System.out.println("Contact removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter name of contact to search: ");
                    String nameToSearch = scanner.nextLine();
                    Contact foundContact = adressbook.searchContact(nameToSearch);
                    if (foundContact != null) {
                        System.out.println("Contact found:");
                        System.out.println(foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    adressbook.displayAllContacts();
                    break;

                case 5:
                    System.out.print("Enter filename to save contacts to: ");
                    String saveFilename = scanner.nextLine();
				try {
					adressbook.saveToFile(saveFilename);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    System.out.println("Contacts saved to file successfully!");
                    break;

                case 6:
                    System.out.print("Enter filename to load contacts from: ");
                    String loadFilename = scanner.nextLine();
				try {
					adressbook.loadFromFile(loadFilename);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    System.out.println("Contacts loaded from file successfully!");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
            }
        }
    }
		
}


