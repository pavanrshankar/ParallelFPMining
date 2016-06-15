SETUP

    (1) Install IntellJ IDEA 15 Community Edition

    (2) Use 1.7 version for JAVA

    (3) Install MySQL 

    (4) Create student_info table in  outbound_messages database 
    Columns: id(int),rollno(int,primary key),section(int),grades(varchar)

    (5) Run Dropwizard application

RESOURCES EXPOSED

    (1) /group

    Description: Groups students based on section

    (2) /mineRules/{support}/{confidence}

    Description: Finds frequent patterns and rules from data.txt transaction. 

DETAILS

    Aim of this demo is to introduce to libraries exposed by Apache Spark(Spark SQL,Spark Mlib) and not focus on solution
    Data size included in the demo is small, used for testing purposes.

