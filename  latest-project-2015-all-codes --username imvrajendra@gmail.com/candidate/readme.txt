Steps to be followed to execute the JAR:

1. Keep the jar with SRC folder in the hierarchy provided in the problem. CANDIDATE-> SRC + (vrajendra_mandloi.jar)
2. Right click anywhere in the folder + SHIFT. 
3. Open Command prompt in the folder.
4. Now type "java -jar vrajendra_mandloi.jar"     ==> this will execute considering all the dates in sales and customer file. 
5. Now type "java -jar vrajendra_mandloi.jar 2005-01-01 07/07/2005"     ==> this will execute considering only the dates.


Assumptions 
** records will be printed alphabetically, and only the records processed inclusive dates.
** dates are only in two formats "2005-01-01" & "07/07/2005".
** I am passing the dates via arguments, there is no modification in properties file.
** if no date is provided then all the records will be displayed for all the customers.
** if dates are provided then they should be correct. otherwise program will terminate with log message.
