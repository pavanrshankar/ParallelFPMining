SETUP
-Install IntellJ IDEA 15 Community Edition
-Install 1.7 JAVA version
-Add a student_info table to outbound_messages database in MySQL
-Create id(int),rollno(int,primary key),section(int),grades(varchar) columns in student_info
-Run Dropwizard application

RESOURCES EXPOSED
-http://localhost:5000/group
 Groups students based on section
-http://localhost:5000/mineRules/{support}/{confidence}
 Finds frequent patterns and rules from data.txt transaction. 
 Support and Confidence is between 0 and 1(inclusive)

DETAILS
-Aim of this demo is to introduce to libraries exposed by Apache Spark(Spark SQL,Spark Mlib) 
 and not focus on solution
-Data size included in the demo is small, used for testing purposes

