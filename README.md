# 📚 Digital Library - Backend

## 🌟 Introduction

Welcome to the Digital Library, a project created to modernize and organize our neighborhood library! In a world where technology is transforming all aspects of our lives, our mission is to provide the library with an efficient and modern system to manage its collection. This platform will allow the library to be organized, efficient, and accessible to its users, all while preserving the magic of books and knowledge.

Our goal is to empower the library administrator by providing a system that enables them to add, update, delete, and search for books in a simple and convenient way through a web interface.

With a constantly growing collection and the need to serve a diverse community, this system will ensure the library continues to grow and thrive. From cataloging new books to managing popular searches by title, author, or genre, this backend system will be the central infrastructure to meet the library’s future needs.

## 🏆 Objective

The library in our neighborhood wants to modernize and needs a web platform to organize its books. With an updated inventory, the administrator will be able to manage loans and services more efficiently. The system will allow:

- Add books
- Update books
- Delete books
- View books
- Search books by specific attributes

---

## Project Structure

---------------project folder structure-------------


│   .env
│   .gitignore
│   pom.xml
│   README.md
│
├───.vscode
│       settings.json
│
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───library
│   │               │   App.java
│   │               │
│   │               ├───config
│   │               │       ConnectionDB.java
│   │               │       DAOException.java
│   │               │
│   │               ├───controller
│   │               │       BookController.java
│   │               │
│   │               ├───model
│   │               │       Book.java
│   │               │       BookDAO.java
│   │               │
│   │               └───view
│   │                       BookDisplayView.java
│   │                       BookView.java
│   │
│   └───test
│       └───java
│           └───com
│               └───library
│                       AppTest.java
│
└───target
    ├───classes
    │   └───com
    │       └───library
    │           │   App.class
    │           │
    │           ├───config
    │           │       ConnectionDB.class
    │           │       DAOException.class
    │           │
    │           ├───controller
    │           │       BookController.class
    │           │
    │           ├───model
    │           │       Book.class
    │           │       BookDAO.class
    │           │
    │           └───view
    │                   BookDisplayView.class
    │                   BookView.class
    │
    ├───generated-sources
    │   └───annotations
    ├───maven-status
    │   └───maven-compiler-plugin
    │       └───compile
    │           └───default-compile
    │                   createdFiles.lst
    │                   inputFiles.lst
    │
    └───test-classes
        └───com
            └───library
                    AppTest.class

## 💻 Technologies

- Java 21: Programming Language.
- PostgreSQL: Database.
- Maven: Build Tool.

---

## 🚀 Methodology and Project Phases

This is a team-based project using agile methodologies, where a CRUD application will be developed using vanilla Java and PostgreSQL. The project will be structured in a sprint, focused on:

- Object-Oriented Programming
- Database Connection
- CRUD Operations

The program will run from the terminal, and the project structure will be organized using Maven.

---

## 📜 Functional Requirements

The system must allow users to:

- 📌 View a list of all books in the database.
- ➕ Add a new book.
- ✏️ Edit the information of a book.
- ❌ Delete a book.
- 🔍 Search for a book by title.
- 🔍 Search for books by author.
- 🔍 Search for books by literary genre.

---

## 🎯 Non-Functional Requirements

- Each book must include:
  - Title
  - One or more authors
  - Description (maximum 200 characters)
  - ISBN code
  - One or more literary genres

- 📄 When listing the books, all fields will be displayed except the description.
- 🔎 When searching by title or author, all fields of the book will be displayed.
- 📚 When searching by literary genre, all fields except the description will be displayed.
- 📌 The database must include the three favorite books of each coder.
- 📊 The database must be normalized.
- 🔐 Identify, document, and mitigate possible vulnerabilities.

---

## 🔄 Installation and Configuration

1. Clone the repository:
   bash
   git clone https://github.com/cuyass/library.git
   cd library

2. Create a database named library
   Set up the username and password in application.properties

3. Build and run the project:
    bash:
    mvn clean install
    mvn clean compile
    mvn exec:java


## 👨‍💻 This project was developed by:

Eva Sisalli:   https://github.com/miskybox
Mariana Marin: https://github.com/marianamarinflor622
Marion Cuyàs:  https://github.com/cuyass
Israel Espín:  https://github.com/iespin

 