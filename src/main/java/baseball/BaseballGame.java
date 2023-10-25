package baseball;

public class BaseballGame {
    private Computer computer;
    private Player player;
    private boolean isGameOver;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
        this.isGameOver = false;
    }

    public void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int targetNumber = computer.generateRandomNumber();

        while (!isGameOver) {
            int userGuess = player.inputGuess();
            String result = calculateResult(userGuess, targetNumber);
            player.displayResult(result);
            if (result.equals("3스트라이크")) {
                isGameOver = true;
            }
        }

        if (player.playAgain()) {
            isGameOver = false;
            playGame();
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }

    private String calculateResult(int guess, int target) {
        String guessStr = String.valueOf(guess);
        String targetStr = String.valueOf(target);

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (guessStr.charAt(i) == targetStr.charAt(i)) {
                strike++;
            } else if (targetStr.contains(String.valueOf(guessStr.charAt(i)))) {
                ball++;
            }
        }

        if (strike == 3) {
            return "3스트라이크";
        } else if (strike > 0 || ball > 0) {
            return strike + "스트라이크 " + ball + "볼";
        } else {
            return "낫싱";
        }
    }
}
