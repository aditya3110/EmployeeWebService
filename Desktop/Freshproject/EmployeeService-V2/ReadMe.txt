In this version we are providing an insurance table for each employee as soon as it gets created.

Not the communication between the microservices are happening using rabbitMQ so even if the insurance microservice is down
it wont hinder the creation of employee insurance table. and it would get created as soon as the microservice is up.

The default Insurance status of the employee would be "inactive"
We have also added a feature to change the status of the insurance.

PREREQUISITE:

1. Erlang and Rabbit MQ should be installed and running (post for rabbitMQ is localhost:15672)
2. naming-server should be up and running, the port used for this is "localhost:8761"
3. employee-insurance-service should be up and running. port used for this is "localhost:8081"
4. EmployeeWebService-UpdatedFeature should be up and running, port used for this is "localhost:8080"

URLs:

GET REQUEST http://localhost:8081/employees/getall - to get all the employees insurance table
POST REQUEST http://localhost:8080/employees -to post a new employee data in employee table, by calling this 
                                              new insurance row for that employee would be created

PUT REQUEST http://localhost:8081/employees/insurance/update/{id} - to update the insurance status of the employee, if it is 
                                                                    "inactive" then it would be come "active" and vice-versa.
                                                                     Note: {id} would be replaced by employee Id.



NOTE: to see all the running instances we can use "http://localhost:8761" on browser



