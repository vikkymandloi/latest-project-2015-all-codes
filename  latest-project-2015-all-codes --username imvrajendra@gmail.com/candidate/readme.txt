Steps to run the program:

We need to provide valid dates arguments (Start Date, End Date) to run the program. Without the dates, the program will display details for all the Customers.
if invalid date args are provided, program will terminate logging the message.
java ControllerSales 1/1/2005 1/31/2005. 
or
java ControllerSales.


1. Only those Customers records will be displayed, whom Customer_date is prior to Sales End Date.
2. Reading properties file using File class is not available after 1.6, so running in 1.7+ directly from JAR might give error.
3. Have updated the JAR and ZIP file with the JAVA/CLASS file both attached.
4. Exception Logger is maintaining all the log info in one error file.
5. I have explicitly used JRE 1.5, to compile & run the Project.
6. All other folders are having there respective config as explained in question.