package baseball;

public class Application {
    public static void main(String[] args) {
        OutputView.gameStartMessage();

        boolean playAgain = true;

        while (playAgain) {
            playGame();

            int choice = InputView.getPlayAgainChoice();
            if (choice == 2) {
                playAgain = false;
            }
        }
    }

    public static void playGame() {
        OpponentComputer opponentComputer = new OpponentComputer();
        boolean isGameFinished = false;

        while (!isGameFinished) {
            User user = new User();

            int userNumber = InputView.getUserNumber();
            InputView.validateNumber(userNumber);
            user.setUserNumber(userNumber);

            int[] score = opponentComputer.calculateScore(user);
            OutputView.displayScore(score[0], score[1]);

            if (score[0] == 3) {
                OutputView.displayGameEndMessage();
                isGameFinished = true;
            }
        }
    }
}