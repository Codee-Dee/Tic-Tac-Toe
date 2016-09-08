cd acceptance
javac -cp .;..\build\classes\main TicTacToe.java
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeTests.txt
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeGUITest.txt
cd ..