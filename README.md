When developing a program in Java, the MySQL Connector/J driver must be installed to connect to the mysql database.
Step 1: In the first step, the MySQL Connector/J driver must be downloaded from the given link. For devices with Windows operating system, the "Platform Independent" option must be clicked. Finally, the "Platform Independent (Architecture Independent), ZIP Archive" file must be downloaded.
Related link: https://dev.mysql.com/downloads/connector/j/
Step 2: In the second step, the zip file should be extracted and the ysql-connector-java-X.X.X.jar file should be extracted from it. For example, mysql-connector-java-8.0.33.jar
Step 3: Since we developed the project via Visual Studio Code, all Java installations have been completed beforehand, we open a folder named lib in our project file and add the mysql-connector-java-X.X.X.jar file into it.
Step 4: We add the following code to our DatabaseFacade code.
Related Code: public static Connection getConnection() {
        try {
            // JDBC sürücüsünü yükle
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Veritabanına bağlan
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return null;
    }
Step 5: We use the "Run Java" option to run the Main.java file of our project. If we use the "Run Code" option, we will encounter a driver error.
