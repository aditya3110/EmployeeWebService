In this version we are providing an insurance table for each employee as soon as it gets created.

The default Insurance status of the employee would be "inactive"
We have also added a feature to change the status of the insurance.

PREREQUISITE:

1. naming-server should be up and running, the port used for this is "localhost:8761"
2. employee-insurance-service should be up and running. port used for this is "localhost:8081"
3. EmployeeWebService-UpdatedFeature should be up and running, port used for this is "localhost:8080"

URLs:

GET REQUEST http://localhost:8081/employees/getall - to get all the employees insurance table
POST REQUEST http://localhost:8080/employees -to post a new employee data in employee table, by calling this 
                                              new insurance row for that employee would be created

PUT REQUEST http://localhost:8081/employees/insurance/update/{id} - to update the insurance status of the employee, if it is 
                                                                    "inactive" then it would be come "active" and vice-versa.
                                                                     Note: {id} would be replaced by employee Id.



NOTE: to see all the running instances we can use "http://localhost:8761" on browser



