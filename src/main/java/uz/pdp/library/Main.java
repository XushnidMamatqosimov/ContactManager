package uz.pdp.library;

import uz.pdp.library.controller.ContactController;

public class Main {
    public static void main(String[] args) {
        ContactController contactController = new ContactController();
        contactController.start();
    }


}