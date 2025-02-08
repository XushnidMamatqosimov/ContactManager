package uz.pdp.library.service;

import uz.pdp.library.dto.Contact;
import uz.pdp.library.repository.ContactRepository;

import java.util.List;

public class ContactService {
    private ContactRepository contactRepository = new ContactRepository();

    public void addContact(Contact contact) {

        //check
        Contact exists = contactRepository.getByPhone(contact.getPhone());
        if (exists != null) {
            System.out.println("This contact already exits");
            return;
        }
        //create;
        boolean b = contactRepository.saveContact(contact);
        if (b) {
            System.out.println("Contact successfully added;");
        } else {
            System.out.println("Something went wrong;");
        }
    }

    public void getContactList() {
        List<Contact> allContacts = contactRepository.getAllContacts();
        if (allContacts.isEmpty()) {
            System.out.println("Mazgi contactlaring yuqku hali;");
        }
        for (Contact allContact : allContacts) {
            System.out.println(allContact.getName() + " " + allContact.getSurname() + " " + allContact.getPhone());
        }
    }

    public void getDeleteContact(String phone) {

        //check
        /*Contact byPhone = contactRepository.getByPhone(phone);
        if (byPhone == null) {
            System.out.println("Contact not exists");
            return;
        }*/

        //ifPhoneExist
        int effectedRows = contactRepository.deleteContact(phone);
        if (effectedRows == 1) {
            System.out.println("Contact successfully deleted:");
        } else {
            System.out.println("Contact not found Mazgi");
        }
    }

    public void searchBy(String query) {
        List<Contact> contactList = contactRepository.search(query);
        if (contactList.isEmpty()) {
            System.out.println("There is not found such contact");
        }
        for (Contact allContact : contactList) {
            System.out.println(allContact.getName() + " " + allContact.getSurname() + " " + allContact.getPhone());
        }
    }
}
