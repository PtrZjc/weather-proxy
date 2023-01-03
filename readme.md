This is demo application which was prepared to meet the following requirements:

# Requirements
Prepare a microservice that performs the following functions:
- integrates with the external Accuweather service to download the current weather (integration instructions: https://developer.accuweather.com/getting-started)
- provides an endpoint for the other microservices. Endpoint takes the postal code of the selected city as a parameter. Using the given code, we need to return a five-day weather forecast for the province in which the selected city is located. The returned model is to contain a list of days and the minimum and maximum temperature for a given day.
- allows you to check the number of requests to the weather service
- supports a minimum of 25 RPS
- includes integration tests
- is ready for production deployment
- uses a minimum of Java 1.8 and Spring Boot 2x
