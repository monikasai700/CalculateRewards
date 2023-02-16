# CalculateRewards
This Application allows the users to create a customer and calculate rewards based on the transaction amount.

**The following are the REST API endpoints to perform different actions.**

Here **amount** is transaction amount of the customer.

**Create a customer**  
endpoint: POST _"/customers"_  
json body:
_{
"name": "jimmy",
"amount": 150
}_  
response:
_{
"id": 10,
"name": "jimmy",
"amount": 120,
"rewards": 90
}_

**Get customer rewards with id**  
endpoint: GET _"/customers/10"_    
response:
_{
"id": 10,
"name": "jimmy",
"rewards": 90
}_

**Get customer details with id**  
endpoint: GET _"/customers/10"_    
response: 
_{
"id": 10,
"name": "jimmy",
"amount": 120,
"rewards": 90
}_

**Get all customers'**  
endpoint: GET _"/customers"_ or "/"   
response:
_{
"id": 10,
"name": "jimmy",
"amount": 120,
"rewards": 90
},
{
"id": 11,
"name": "john",
"amount": 150,
"rewards": 150
}_

**Update a customer**  
endpoint: PUT _"/customers/10"_  
json body:
_{
"name": "jimmy falcon",
"amount": 120
}_  
response:
_{
"id": 10,
"name": "jimmy falcon",
"amount": 120,
"rewards": 90
}_


**Delete a customer**  
endpoint: DELETE _"/customers/10"_   
response:
"Customer deleted successfully!"