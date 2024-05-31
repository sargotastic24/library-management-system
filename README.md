# library-management-system

Library Management System

Overview

This project involves constructing a program for libraries that allows books to be checked in and out electronically. Each book is represented by an ISBN, author, and title. A library book includes the holder (the person who has checked out the book) and a due date. The system must handle different representations of holders (e.g., names, phone numbers) and provide features like inventory lists and overdue book lists.

The project is divided into three phases:

- Phase 1: Build the library using a specific representation of the library book holder (a String name).
- Phase 2: Modify the implementation to make it generic.
- Phase 3: Add features to the generic implementation, such as sorting books by ISBN, due date, and title.

Requirements

- Phase 1: Specific Implementation

Book and LibraryBook

Book Class:

The base class Book is provided. Implement the equals method without making any other changes.

LibraryBook Class:

Derived from Book, it includes the holder (a String) and due date (a GregorianCalendar).

Methods to implement:


public LibraryBook(long isbn, String author, String title)
public String getHolder()
public GregorianCalendar getDueDate()


- Include methods for checking a book in and out.
- Do not override the equals method from Book.

Library
- The Library class has been started. Complete the method implementations as indicated without changing the method signatures.

LibraryTester
- Add JUnit5 tests in LibraryTester for more exhaustive testing.

- Phase 2: Generic Implementation

LibraryBookGeneric

Modify LibraryBook to make the holder type generic:


public class LibraryBookGeneric<Type> extends Book


Replace String with Type where appropriate.

LibraryGeneric

Modify Library to handle generic library books:


public class LibraryGeneric<Type>


Replace String with Type and ArrayList<LibraryBook> with ArrayList<LibraryBookGeneric<Type>>.

LibraryGenericTester

Add JUnit5 tests in LibraryGenericTester for exhaustive testing.

- Phase 3: Additional Features

Add the following features to LibraryGeneric:

Retrieve Books Sorted by ISBN:

This feature is implemented as an example. Use the getInventoryList method, which sorts books by ISBN using the OrderByIsbn comparator.
Retrieve Overdue Books Sorted by Due Date:

Implement this feature by creating a list of overdue books and sorting them using the OrderByDueDate comparator, which you must implement.
Retrieve Books Sorted by Title:

Implement this feature by creating a comparator class (or using a lambda expression) to sort books lexicographically by title.

Testing

Test these features extensively by adding JUnit5 tests to LibraryGenericTester or creating a new tester class.
