package com.library.implementations;

import com.library.models.Library;
import com.library.models.User;
import com.library.services.LibrarianService;

import java.util.*;

public class LibrarianImplementation implements LibrarianService{
    @Override
    public User checkoutBook() {
        // Access the library queue and check if there are two or more persons requesting for the same book.
        // Add every request to Map to help us check if there are multiple requests on a particular book.
        Map<String, List<User>> bookRequestMap = new HashMap<>();
        Library.libraryQueue.forEach(user -> {
            String key = user.getBookCart().getTitle() + " by " + user.getBookCart().getAuthor();
            bookRequestMap.computeIfAbsent(key, k -> new ArrayList<>()).add(user);
        });
        PriorityQueue<User> priorityQueue = new PriorityQueue<>(Comparator.comparing(User::getRole));
        // Check the map for duplicate requests and add them to the priorityQueue.
        bookRequestMap.forEach((String book, List<User> users) -> {
            if(users.size() >= 2) {
                priorityQueue.addAll(users);
            }
        });
        // Checkout book with either priority or normal queue, and update the collected book register.
        User user;
        if(priorityQueue.isEmpty()) {
            user = Library.libraryQueue.poll();
        } else {
            user = priorityQueue.poll();
        }
        updateCollectedBookRegister(user);
        return user;
    }
}