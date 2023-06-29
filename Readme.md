##  Websocket Casino Server
This is a Java / Maven / Spring Boot (version 2.7.12) application

## To Run
1. Run the server using "mvn spring-boot:run"
2. Server runs on localhost:8080/casino-server
3. To Run Tests use "mvn clean test"
## Main Functionality
1. Takes Player input for bet and number
2. Sends the PlayerMessage Object to ServerController on "/process-message" end point
3. ServerController takes the PlayerMessage and creates Result Object through PlayGameLogic() of GameService
4. PlayGameLogic() creates a random number and if Player number is bigger than generated 
random number then it calculates win amount and if the player looses the win amount is zero
5. ServerController sends the Result Object back to player on "/queue/reply" endpoint
6. Each Result Object is sent to a specific Player  
7. Minimum bet amount is 1
8. Number should be between 1 and 99 because if the player enters 100 the win amount would
      be infinite as 99/(100-100) would be infinite. 
9. If player sends numbers for bet or number field which are not allowed the player gets back the error message
