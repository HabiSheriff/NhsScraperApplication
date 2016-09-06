# NhsScraperApplication
NhsScraperApplication for text search 

# How to download from Git hub

1) Create new folder in Java work space

2) Goto command prompt and change directory to the newly created folder path
  
  Use below commands to init and clone from Git
  
  git init
  
  git clone git://github.com/HabiSheriff/NhsScraperApplication.git
 
# To run a mvn build commands
  mvn eclipse:clean
  
  mvn eclipse:eclipse 

# List of Classes and its functionalities
This NHSScraper Application has below classes
   # Scraper

 
# Sample Json input file path  
 src/main/resources/inputfiles/pages_in_json.txt

 Please note: this application does n't required any JSON input files, it is loading from below NHS pages

# Sample Json file format
[       
  {
    "url": "http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx",
    "pageContent": "Chickenpox is a mild and common childhood illness that most children catch at some point.",
     "title": "Chickenpox"
  }
 ]
  
# To run NHSScraperApplication
   mvn spring-boot:run
   
   Check the server running
   In browser, try http://localhost:8080
   
 
# To test searches in browser

  In browser try below urls
  
  http://localhost:8080/search/treatment for chickenpox
  
  http://localhost:8080/search/chickenpox
  
  http://localhost:8080/search/symptoms of thrush
  
  http://localhost:8080/search/depression
  
  http://localhost:8080/search/symptoms of mumps
  
  http://localhost:8080/search/< Any text with including spaces>
        
# Assumptions

  1) This application takes data from  NHS site (http://www.nhs.uk/Conditions/Pages/hub.aspx) and its sub pages.
  
  2) This NHSScraperApplication includes only 22 sub page URL contents (Common conditions and Childhood conditions)
  
