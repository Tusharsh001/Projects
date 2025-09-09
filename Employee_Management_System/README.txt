This is Employee Management System is created  using Maven,JDBC,mySQl in this i have create an interface in which i have create a system for the Manager of the perticular deparment and the employee of that perticular depatment .In this project i have given the access  to the Manager to add or remove the employee and i have make sure that the manager who add the employee can add only the employee of its own department not of any other depart and can see all the information of the emplyee of his/her own deparment only .In this project i have taken the pre-existing email as a verification if the email already exit in the database then only you can enter the application if not you can't.
The Mangaer can't be regester through this application they have to be registerd directly into the database not though any interface by the higher authories but in case of empoyee Manager can register them.
Employee that the access to the limited info only which are required only but Manager have more info of the employe which include date of Joining,salary and other stuff.
---IN NEW UPDATE--
I am going to add the file uploading in this in which employee have to upload daily work report and can send leave requirest which can be seen by the Manager and then Manager can reply from it's side able to see the leave request and the daily work report 

---Main file ---
Main file containt the object of the welcome screen only to kick start the code 
 ---Screen Package----
this folder contains three different views 
1.Managerview -->view the Manager see after verification 
2.Employeeview -->view that employee see after verrfication
3.Welcomeview -->it contain the login view and verification of both the employee and tha Manager
-----Data package---
It contains the class for both employee and Manager through which we can create there object and can fetch the data from the database 
It contains gets and sets and all other methods
--------db--------
Thid contains a single class which is responsoble for the making of the connection of java with the Database 
it mainly contains the JDBC code 
--------DAO------
As its name suggest it contains all the menthoda for both the employww and the Manager through which we can fetch the data from the database



