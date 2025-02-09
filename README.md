# Apps-Rating-Review-System
Microservices Project : Apps rating/review system using Spring boot

## Idea
Inspired by Google Play’s comprehensive rating and feedback mechanism.

Collect and manage user-generated ratings and reviews for applications.

Develop system that is
  1. Scalable
  2. Maintainable
  3. Handles large volume of data and user interactions.

## Learning Outcomes
- Create microservice 
- Microservice Communication
- Service Discovery/Registry 
- API Gateway

## Microservices
1. User Service : stores details of users who will give rating/review
2. App Service : stores details of all available apps in web store
3. Rating Service : stores information of rating/review given by user
4. Service Registry : keeps track of all available service instances
5. API Gateway : acts as centralised entrypoint to client requests for different services.


## Architecture
![Screenshot 2025-02-09 at 9 34 21 AM](https://github.com/user-attachments/assets/f4140bb6-133f-4a55-a80e-0e54499e3396)


## Service Registry
![Screenshot 2025-02-09 at 9 35 25 AM](https://github.com/user-attachments/assets/451e190c-b1f7-4587-b3e7-01a5dd7116cf)


## Structure of Queried Data
![Screenshot 2025-02-09 at 9 35 56 AM](https://github.com/user-attachments/assets/4a47aa14-0b6b-426f-ae35-c0bdf4a27fe6)



