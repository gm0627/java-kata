package org.echocat.kata.java.part1;

import org.echocat.kata.java.manager.LibraryManager;

public class MainApp {

    public static void main(String[] args) {

       LibraryManager manager= LibraryManager.getInstance();

    }

    protected static String getHelloWorldText() {

        return "Hello world!";
    }

}
