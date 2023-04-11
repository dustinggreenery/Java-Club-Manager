# Java Club Manager: An Application for Clubs in a School

![Contributors](https://img.shields.io/github/contributors/dustinggreenery/Java-Club-Manager)
![Forks](https://img.shields.io/github/forks/dustinggreenery/Java-Club-Manager)
![Stars](https://img.shields.io/github/stars/dustinggreenery/Java-Club-Manager)
![Licence](https://img.shields.io/github/license/dustinggreenery/Java-Club-Manager)
![Issues](https://img.shields.io/github/issues/dustinggreenery/Java-Club-Manager)

## Description

Here is a full-stack Java application where you can use and save clubs in a high school. You can create a profile as a club leader, create a club, customize your own club, and change meeting dates.
Currently the website doesn't have a domain, so you will have to run it locally.

### Technologies Used:

- Apache Netbeans
- Maven
- Tomcat Server
- SHA256 Hashing
- Java Persistence API
- Java Server Faces
- mySQL database,

## Usage and Overview

### To Get Started:

- Fork the repository
- Clone the forked repository
- Put the repository into the Netbeans IDE
- Request partial access to mysql database (request me)
- Run the program

### Home Page and Club Table

The first page is the club table. Here you can see clubs and their description and next meeting information. There is also a button which takes you to login to a club leader account.

### Login Page

The login page allows you to create or login to a club leader account. It also has options to create or edit a club once you are logged in. Once you have logged in, your username will be displayed on the page.

### Create Account Page

Going from the login page, you can create an account, inputing your username, password, and club name.

#### Extra Security

In case the database is compromised, the passwords of the club leaders are hashed.

### Create/Edit Clubs

Once you've logged in, you can create or edit clubs.

- Creating a Club: You must first not have a club. In this page, you enter the club information, and then add it into the database.
- Editing a Club: Here you can see the current information of your club, as well as textboxes to edit it. There is also an option to autofill data, which simply fills the textboxes with the current information.
