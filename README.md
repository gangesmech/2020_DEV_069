## About Tic Tac Toe

Tic-tac-toe, noughts and crosses or Xs and Os is a paper-and-pencil game for two players, X and O, who take turns marking the spaces in a 3x3 grid. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row is the winner.

## Rules

The rules are described below :

- X always goes first.
- Players cannot play on a played position.
- Players alternate placing X's and O's on the board until either:
	- One player has three in a row, horizontally, vertically or diagonally
	- All nine squares are filled.
- If a player is able to draw three X's or three O's in a row, that player wins.
- If all nine squares are filled and neither player has three in a row, the game is a draw.

## Approach

This project is a part of Kata exercise, where implementation has been done through JAVA language using Test Driven Development(TDD) approach.

## Softwares required
The following softwares are required to run this program
 - Java 1.8 or above
 - Eclipse (Any IDE, which supports Java)
 - Or, Maven (for command line execution)

## Run test using Command prompt
```
- Download the project as zip file and unzip the same to a folder. 
- Open the command prompt from the extracted folder execute below commands:

mvn clean install

- Verify test reports at <PROJECT_ROOT_FOLDER>\target\surefire-reports\

```

## Run test using Eclipse
```
 - Download the project as zip file and unzip the same to a folder. 
 - In eclipse Go to File -> Import -> select Existing Maven Project option -> Next -> Browse extracted folder and Finish
 - Right click project in Project Explorer window and select Run As -> Maven install
 - Verify test reports at <PROJECT_ROOT_FOLDER>\target\surefire-reports\
```

## Play game using Command prompt
```
- Download the project as zip file and unzip the same to a folder. 
- Open the command prompt from the extracted folder execute below commands:

mvn clean install

- Navigate to 'target' folder and execute 'java -jar tic-tac-toe-1.0.jar'

```

## Play game using Eclipse
```
 - Download the project as zip file and unzip the same to a folder. 
 - In eclipse Go to File -> Import -> select Existing Maven Project option -> Next -> Browse extracted folder and Finish
 - Right click project in Project Explorer window and select Run As -> Maven install
 - Right click Play.java and click Run as -> Java Application.
```


## Author
<b>DEV-2020-069</b>