# < Baseball Game >
***
## < Game Rules >
***
- Okay, so there are strike, ball, and nothing for the results. 
- If 3 strikes, then the game ends, or the user could restart the game.

# < Code Review >
 ***
- Okay, so most of the functions goes into another file named "BaseballDealer.java"

- The computer would need to create a new random number each time we start the game.
- createNewBaseball() - creates random number
- checkIsValidInput - checks if the user input number is within the range
- judgeInput - if struck, will append 1 to strike
- if balled, will append 1 to ball
- if nothing, will append 1 to nothing

- generateJudgeComment - This function is for generating comments to determine whether it's a ball, strike, or nothing. 
- If either one of the comments are fulfilled, it will append to its judged comments (BALL, STRIKE, NOTHING)
- Finally, based on the code below,


    
    while (continueGame) {
    dealer.runGame();
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String runAgain = Console.readLine();
    if (runAgain.equals("2")) {
    continueGame = false;
    } else if (!runAgain.equals("1")) {
    throw new IllegalArgumentException();
    }

- continueGame - when the game is running and user has won, and the user wants to end the game,
then 


     if (runAgain.equals("2")) {
    continueGame = false;
    } 

will end the game, else, it will show an IllegalArgumentException.