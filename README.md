
# Task Manager

Keep track of all of your tasks
## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed
- [Apache Maven](https://maven.apache.org/download.cgi) installed
- [H2 Database](https://www.h2database.com/html/main.html) (or any other database) installed
- Your favorite integrated development environment (IDE) installed (e.g., [Eclipse](https://www.eclipse.org/ide/), [IntelliJ IDEA](https://www.jetbrains.com/idea/))

## Running the Application

To run the application locally, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/your-repository.git
   cd your-repository
   ```

2. **Configure the Database:**

   Open the `src/main/resources/application.properties` file and configure the database settings. For example:

   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.h2.console.enabled=true

   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
   spring.jpa.hibernate.ddl-auto=update
   ```

   Adjust the settings based on your database choice.

3. **Build the Project:**

   ```bash
   mvn clean install
   ```

4. **Run the Application:**

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the generated JAR file:

   ```bash
   java -jar target/your-application-name.jar
   ```
   You can also right click on TaskmanagerApplication.java in your IDE and click run java
   
6. **Access the Application:**

   Open a web browser and go to [http://localhost:8080](http://localhost:8080). The application should be running, and you can start interacting with it.


# My Database

![Database](https://i.ibb.co/TTnzRwn/Screen-Shot-2023-11-12-at-6-23-56-PM.png)

# My Task App

![App](https://i.ibb.co/QNv0X4V/Screen-Shot-2023-11-12-at-6-23-14-PM.png)

![App2](https://i.ibb.co/jwK9pp8/Screen-Shot-2023-11-12-at-6-23-29-PM.png)

![App3](https://i.ibb.co/JCKVb35/Screen-Shot-2023-11-12-at-6-23-42-PM.png)

## Contributing

If you'd like to contribute to the project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature-name`.
3. Make your changes and commit them: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Create a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
