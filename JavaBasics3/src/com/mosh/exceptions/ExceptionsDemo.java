package com.mosh.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show() throws IOException {

        var account = new Account();
        try {
            account.withdraw(10);
        } catch (AccountException e) {
            System.out.println(e.getCause().getMessage());
        }

        try {
            account.deposit(-1);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        }

        // Try with resources
        try (
                var reader = new FileReader("file.txt");
                var write = new FileWriter("...");
        ) {
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch (IOException | ParseException e) {
            System.out.println("Could not read data");
        }
    }

    public static void sayHello(String name){
        System.out.println(name.toUpperCase());
    }
}
