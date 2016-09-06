#####NhsScraperApplication
NhsScraperApplication for text search 

#####To download from Git hub:

  Goto command prompt and change directory to any of folder path and Use below command clone from Git 
 
  ** git clone git://github.com/HabiSheriff/NhsScraperApplication.git **
 
#####To execute the tests in the NHSScraper App:
  
  ** mvn clean test **

##### To start NHSScraper App server

   ** mvn spring-boot:run **
   
   Check the server running
   In browser, try http://localhost:8080

#####To test searches in browser

  In browser try, below urls
  
  ** http://localhost:8080/search/< Any text with including spaces> **
  
  http://localhost:8080/search/treatment for chickenpox
     
  http://localhost:8080/search/symptoms of thrush
    
#####List of Classes and its functionalities
#####This NHSScraper Application has below classes:

##### Sequence of execution flow:

Application - void main class to start spring boot server.

LoadData - This is a spring boot init class, this is the first class to get executed, when spring boot server is started. This init method calls the GetData Service class to load the data.

GetDataService  - This is a service which calls the LoadAndDirectory class to load the url content into RAMDirectory

LoadAndSearchDirectory - Class to load data into RAMdirectory using index writer and Search the sub page url content based on the given search text

SearchController - This is rest service class, which get called every time, when we invoke the url to search.

List of other important classes used in this NHSScraper Application:

BaseScraper - Base scraper class to parse the web page and convert into Document

ConditionPageScraper - Child class of BaseScraper with additional functionality to get the conditions urls from main page

ConditionSubPageScraper  - Child class of BaseScraper with additional functionality to get the sub page url details such as title, url, content

Page  - Class which has information of a page such as url, title and content

PageDocument - Class which has information of a web page

ConvertToJson - Class to convert the list of page object into JSON string

SearchResults - Class which stores the results of a search

ApplicationConstants -  all constants used in Application

ScraperException - Exception class 

NhsScraperAppConfig - configuration class 
  
#####Technology Stack

1.Java 8

2.Maven - Build

3.JUnit - Unit Testing

4.Jackson - JSON conversion

5.JSoup - For parsing the web page
  
       
#####Assumptions
  
  1.This NHSScraperApplication includes only 22 sub page URL contents (Common conditions and Childhood conditions)
  
  2.http get method is used to search a text, so it has a limitation of 2,048 characters. 
  
