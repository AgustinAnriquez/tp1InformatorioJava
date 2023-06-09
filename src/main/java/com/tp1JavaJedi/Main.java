package com.tp1JavaJedi;

import com.tp1JavaJedi.services.Impl.MenuImpl;
import com.tp1JavaJedi.services.Menu;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Menu menu = new MenuImpl();
    public static void main(String[] args) {
        menu.initMenu();
    }
}