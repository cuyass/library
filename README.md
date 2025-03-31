
 ---------------project folder structure-------------

|   .env
|   .gitignore
|   pom.xml
|   README.md
|
+---.qodo
+---src
|   +---main
|   |   \---java
|   |       \---com
|   |           \---library
|   |               |   App.java
|   |               |
|   |               +---config
|   |               |       ConnectionDB.java
|   |               |
|   |               +---controller
|   |               |       BookController.java
|   |               |
|   |               +---model
|   |               |   |   Book.java
|   |               |   |
|   |               |   \---dao
|   |               |           BookDAO.java
|   |               |
|   |               \---view
|   |                       BookView.java
|   |
|   \---test
|       \---java
|           \---com
|               \---library
|                       AppTest.java
|
\---target
    |   library-1.0-SNAPSHOT.jar
    |
    +---classes
    +---generated-sources
    |   \---annotations
    +---generated-test-sources
    |   \---test-annotations
    +---maven-archiver
    |       pom.properties
    |
    +---maven-status
    |   \---maven-compiler-plugin
    |       +---compile
    |       |   \---default-compile
    |       |           createdFiles.lst
    |       |           inputFiles.lst
    |       |
    |       \---testCompile
    |           \---default-testCompile
    |                   createdFiles.lst
    |                   inputFiles.lst
    |
    +---surefire-reports
    |       com.library.AppTest.txt
    |       TEST-com.library.AppTest.xml
    |
    \---test-classes