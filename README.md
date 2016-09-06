## NHSScraperApplication

NHSScraperApplication for text search 

## To download from Git hub:

   Use below command to clone from Git 
 
  ```git clone git://github.com/HabiSheriff/NhsScraperApplication.git```
 
## To execute the tests in the NHSScraper App:
  
  ```mvn clean test```

## To start NHSScraper App server:

   ```mvn spring-boot:run```
   
   Check the server running
   In browser, try http://localhost:8080

## To test searches in browser:

  In browser try, below urls
  
  ```http://localhost:8080/search/< Any text with including spaces>```
  
  http://localhost:8080/search/```treatment for chickenpox```
     
  http://localhost:8080/search/```symptoms of thrush```
    
## This NHSScraper Application has below classes:

## Sequence of execution flow:

1. Application - void main class to start spring boot server.

2. LoadData - This is a spring boot init class, this is the first class to get executed, when spring boot server is started. This init method calls the GetData Service class to load the data.

3. GetDataService  - This is a service which calls the LoadAndDirectory class to load the url content into RAMDirectory

4. LoadAndSearchDirectory - Class to load data into RAMdirectory using index writer and Search the sub page url content based on the given search text

5. SearchController - This is rest service class, which get called every time, when we invoke the url to search.

## List of other important classes used in this NHSScraper Application:

6. BaseScraper - Base scraper class to parse the web page and convert into Document

7. ConditionPageScraper - Child class of BaseScraper with additional functionality to get the conditions urls from main page

8. ConditionSubPageScraper  - Child class of BaseScraper with additional functionality to get the sub page url details such as title, url, content

9. Page  - Class which has information of a page such as url, title and content

10. PageDocument - Class which has information of a web page

11. ConvertToJson - Class to convert the list of page object into JSON string

12. SearchResults - Class which stores the results of a search

13. ApplicationConstants -  all constants used in Application

14. ScraperException - Exception class 

15. NhsScraperAppConfig - configuration class 

## List of Test classes used: 

1. ConvertToJsonTest - Test class for convert Json class. Tested with hard coded page content

2. LoadAndSearchDirectoryTest - Test class for loading the page content and search for a test.

3. SearchControllerTest - Test class for Search Controller class. Consists of 8 test cases.

4. ConditionPageScraperTest - Test class for Condition Page Scraper - home page scraper test

5. ConditionSubpageScraperTest - Test class for Condition subpage Scraper - list of 22 subpages scraper test
  
## Technology Stack:

1. Java 8

2. Maven - Build

3. JUnit - Unit Testing

4. Jackson - JSON conversion

5. JSoup - For parsing the web page
  
       
## Assumptions:
  
  1. This NHSScraperApplication includes only 22 sub page URL contents (Common conditions and Childhood conditions)
  
  2. HTTP get method is used to search a text, so it has a limitation of 2,048 characters. 
   
## Further Improvements:

   1. Reduce time to execute  test cases.
  
