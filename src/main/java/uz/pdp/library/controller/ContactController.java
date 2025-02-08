package uz.pdp.library.controller;

import uz.pdp.library.dto.Contact;
import uz.pdp.library.util.DatabaseUtil;
import uz.pdp.library.service.ContactService;

import java.util.Scanner;

public class ContactController {
    private ContactService contactService = new ContactService();
    private Scanner strScanner = new Scanner(System.in);
    private Scanner numScanner = new Scanner(System.in);

    public void start() {
        DatabaseUtil.createTable();
        boolean b = true;
        while (b) {
            showMenu();
            int action = getAction();

            switch (action) {
                case 1:
                    System.out.println("Add Contact:");
                    addContact();
                    break;
                case 2:
                    System.out.println("Contact list");
                    getContactList();
                    break;
                case 3:
                    System.out.println("Delete Contact");
                    getDeleteContact();
                    break;
                case 4:
                    System.out.println("Search Contact");
                    searchBy();
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    System.err.println("Mazgi unaqa raqam yuqku, boshqa raqam kirgaz__ : ");
            }
        }
        System.out.println("The End!!!");
    }

    public void showMenu() {
        System.out.println("*** Menu ***");
        System.out.println("1. Add Contact");
        System.out.println("2. Contact List");
        System.out.println("3. Delete Contact");
        System.out.println("4. Search Contact");
        System.out.println("0. Exit");
    }

    public int getAction() {
        System.out.print("Enter your action: ");
        return numScanner.nextInt();
    }

    public void addContact() {
        System.out.print("Enter your name: ");
        String name = strScanner.next();

        System.out.print("Enter your surname: ");
        String surname = strScanner.next();

        System.out.print("Enter your phone: ");
        String phone = strScanner.next();

        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);

        contactService.addContact(contact);
    }

    public void getContactList() {
        contactService.getContactList();
    }

    public void getDeleteContact() {
        System.out.println("Enter phone: ");
        String phone = strScanner.next();

        contactService.getDeleteContact(phone);
    }

    public void searchBy() {
        System.out.print("Enter your query: ");
        String query = strScanner .next();

        contactService.searchBy(query);
    }

}
