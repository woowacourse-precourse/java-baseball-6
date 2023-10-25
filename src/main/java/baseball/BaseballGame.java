package baseball;

public class BaseballGame {
    private final int NUM_COUNT = 3;
    private final int STRIKE = 2;
    private final int BALL = 1;
    private int[] playerAnswer;
    private int[] computerAnswer;
    Game game;
    Player player;

    public BaseballGame() {
        game = new Game();
    }

    public int startBaseballGame() {
        playStart();
        while (game.getStrike() != NUM_COUNT) {
            playTurn();
        }
        return finishTurn();
    }

    private void playStart() {
        computerAnswer = game.setComputerAnswer();
    }

    private void playTurn() {
        player = new Player();
        game.reset();
        System.out.print("숫자를 입력해주세요 : ");
        playerAnswer = player.myInput();
        checkAnswer(playerAnswer, computerAnswer);
        printTurnResult(game.getStrike(), game.getBall());
    }

    private int finishTurn() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return player.restartOrExit();
    }

    private void checkAnswer(int[] playerAnswer, int[] computerAnswer) {
        for (int i = 0; i < NUM_COUNT; i++) {
            int result = strikeOrBall(playerAnswer[i], i);

            if (result == STRIKE) {
                game.increaseStrike();
                continue;
            }
            if (result == BALL) {
                game.increaseBall();
            }
        }
    }

    private int strikeOrBall(int playerNumber, int index) {
        for (int i = 0; i < NUM_COUNT; i++) {
            if (playerNumber == computerAnswer[i] && index == i) {
                return STRIKE;
            }
            if (playerNumber == computerAnswer[i] && index != i) {
                return BALL;
            }
        }
        return 0;
    }

    private void printTurnResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}