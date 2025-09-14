package library;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    int quantity;

    public Book(int id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }


    public String toString() {
        return id + " | " + title + " | " + author + " | Qty: " + quantity;
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

        public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        books.add(new Book(id, title, author, quantity));
        System.out.println("Book added successfully!");
    }

   
    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }
        System.out.println("\n===== Available Books =====");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.quantity > 0) {
                    b.quantity--;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book out of stock!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                b.quantity++;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public static void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String input = sc.nextLine();

        for (Book b : books) {
            if (String.valueOf(b.id).equals(input) || b.title.equalsIgnoreCase(input)) {
                System.out.println("Book found: " + b);
                return;
            }
        }
        System.out.println("Book not found!");
    }
}


	
