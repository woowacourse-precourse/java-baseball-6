package baseball;

public class Application {
    public static void main(String[] args) {
        Guess guess = new Guess();
        GameManager gameManager = new GameManager();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!gameManager.isGameEnd()) {
            guess.setComputerGuessByRandom();
            while (!gameManager.isAnswerMatch()) {  //loop until user gets the right answer
                System.out.print("숫자를 입력해주세요 : ");
                guess.setUserGuessByInput();
                int ball = guess.calculateBall();
                int strike = guess.calculateStrike();
                gameManager.printGuessResult(ball, strike);
            }
            gameManager.gameEnd();  //Check if user wants to play again or end game
        }
    }
}
