This is a file Hiding System in which you upload the path of the file and can hide that in you database which can only be accessed by the authoried person only.
Thisis maven project, it includes authentication,JDBC and for database i have used the MYSQL database to store the data.
FOlowing interaction:---
-----Login/signup---------
I have given both the option for both login and signup also. Both share simillar ways as well

----Login-------
The user can login the system after bypassing the verifaction part which is done with help of the otp verificatio.
The system send the opt on the registered emial and if the user try to login with the email that is not first registerd in
the database it exit the program .
To generate the otp using the random class creating the 4 digit number if the user enter the wrong otp the system give you unlimited try which i was thinking of removing making them a limited time may be about 3-4

------signup------
It also used the same mechanism that i just mention above using the verification using otp through the email,it also check for the already existing email if the person is trying to signup with the already existing id 

