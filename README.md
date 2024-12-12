Real-Time Ticketing System - README
Overview of the application: The Real-Time Ticketing System enables users to oversee event ticketing processes. It offers real-time updates, ticket count viewing, vendor and customer management, and more. This system features a backend created with Spring Boot and a frontend built with Angular.
The project's objective is to give event planners a straightforward yet efficient platform for managing clients and vendors and monitoring ticketing data.
•	Spring Version - 3.3.5
•	JDK Version - 23
•	(Database)PostgreSQL Version - 42.7.4
•	TypeScript Version - 5.6.2
•	Angular
Setup Instructions
Prerequisites
Before running the application, make sure you have the following software installed:
Java 11 or later: Required for building and running the backend application (Spring Boot).
You can download it from Oracle's official website or use any OpenJDK distribution.
Node.js (version 14 or later): Required for building and running the frontend (Angular).
You can download it from Node.js official website.
Maven: Required to build and run the Spring Boot backend.
You can download Maven from Apache Maven official website.
How to Build and Run the Application Step 1: Set Up the Backend (Spring Boot)
Make sure you have a database setup (PostgreSQL).
Run the Backend:
After the setup is complete, start the Spring Boot backend. The backend should now be running at http://localhost:8081.
Step 2: Set Up the Frontend (Angular) Run the Frontend: After installing the dependencies and making any necessary configurations, run the following command in git bash - ng serve The Angular app will now be accessible at http://localhost:4200.
Usage Instructions How to Configure and Start the System Start the Backend:
Make sure the backend Spring Boot application is running on http://localhost:8081 by using the mvn spring-boot:run command. Start the Frontend:
After starting the backend, run ng serve from the Angular project directory to start the frontend on http://localhost:4200.
Connecting the Frontend to Backend: Ensure that the proxy configuration in Angular (proxy.conf.json) or any other API endpoint URL configurations are pointing to http://localhost:8081.
Use the Application: Once both frontend and backend are running, open your browser and visit http://localhost:4200 to access the user interface.
Explanation of UI Controls
•	User can view Total ticket amount and max ticket amount. 
•	User can add a vendor by filling out vendor details form and submitting. 
•	User can add a customer by filling out customer details form and submitting. 
•	User can start the simulation by adding configuration details into congiguration form and pressing start. 
•	User can stop the simulation by pressing stop button.
