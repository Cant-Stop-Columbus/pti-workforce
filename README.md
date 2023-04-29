# Workforce Development by Petals that Inspire

### REST Endpoints:
### <ins>Workshops</ins>
### GET
* /api/workshops --> Gets a list of all the workshops

 -- curl -X GET http://localhost:8080/api/workshops -H 'Content-Type: application/json'
 
### POST
* /api/workshop --> Creates a workshop

 -- curl -s -X POST http://localhost:8080/api/workshop -H 'Content-Type: application/json' -d '{"title": "{}", "details": "{}"}'

##### Example:

curl -s -X POST http://localhost:8080/api/workshop -H 'Content-Type: application/json' -d '{"title": "5.10.23 Petals Flourish Program Cohort 3", "details": "Join the Petals That Inspire Flourish program for mental & physical wellness programming, job skill training and paid employment all while experiencing the joy of florals! Each workshop will start with a lunch provided by local volunteers and payment will be provided by e-gift card by the end of the day of the workshop"}'