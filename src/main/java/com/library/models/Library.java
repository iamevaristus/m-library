package com.library.models;

import com.library.functions.EnumsConverter;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Library {
    public static Queue<User> libraryQueue = new LinkedList<>();
    public static List<Book> bookInventory = new ArrayList<>();
    public static Map<User, List<Book>> collectedBooksRegister = new HashMap<>();
    public static String path = "src/main/resources/ListOfBooks.csv";

    static {
        /// Get books from CSV file and add to library list of books
        try(BufferedReader reader = new BufferedReader(Files.newBufferedReader(Path.of(path)))){
            boolean isHeader = true;
            String line;
            while((line = reader.readLine()) != null) {
                if(isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] bookArray = line.split(",");
                Book book = Book.builder()
                        .id(Integer.parseInt(bookArray[0].trim()))
                        .title(bookArray[1].trim())
                        .author(bookArray[2].trim())
                        .publishDate(bookArray[3].trim())
                        .quantity(Integer.parseInt(bookArray[4].trim()))
                        .genre(bookArray[5].trim())
                        .ISBN(bookArray[6].trim())
                        .status(EnumsConverter.convertStringToStatus(bookArray[7].trim()))
                        .build();
                bookInventory.add(book);
            }
        } catch (Exception e) {
            //
        }
    }
}
