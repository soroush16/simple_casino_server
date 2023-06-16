##  Websocket Casino Server
This is a Java / Maven / Spring Boot (version 2.7.12) application

## To Run
1. Run the server using "mvn spring-boot:run"
2. Run the Client from Command line, navigate to the clients package and compile using "javac Client.java" and then run using "java Client"
3. Server runs on localhost:8080/casino-server
4. To Run Tests use "mvn clean test"
## Main Functionality
1. Takes Player input for bet and number through Scanner class
2. Sends the PlayerMessage Object to ServerController on "/process-message" end point
3. ServerController takes the PlayerMessage and creates Result Object through PlayGameLogic() of GameService
4. PlayGameLogic() creates a random number and if Player number is bigger than generated 
random number then it calculates win amount and if the player looses the win amount is zero
5. ServerController sends the Result Object back to player on "/queue/reply" endpoint which ClientSessionHandler is listening to
6. Each Result Object is sent to a specific Player based on their sessionId 
7. Minimum bet amount is 1
8. Number should be between 1 and 99 because if the player enters 100 the win amount would
      be infinite as 99/(100-100) would be infinite.
9. At the end of each round player is asked if he/she wants to play another round or not
 which he/she can enter YES for another round or any other letter to quit
10. I have made PlayerRespond Enum with YES field to check the Player's respond to avoid having Magic String in the If check
11. If player sends numbers for bet or number field which are not allowed the player gets back the error message
