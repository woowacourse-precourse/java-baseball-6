package baseball;

import java.util.List;

public class Game {

    public static final int INPUT_NUMBER_LENGTH = 3;
    public static final int START_NUMBER = 1;
    public static final int LAST_NUMBER = 9;
    public static final int RESTART = 1;
    public static final int END = 2;
    private static Computer computer = new Computer();

    private static List<Integer> computerSelectNumbers;

    public static void startMessage() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public static void play() {
        computerSelectNumbers = computer.selectNumbers();
        startGame();
    }

    public static void startGame() {
        startMessage();
        String playerInput = Player.inputThreeNumbers();
        computer.compare(playerInput);
        getCountResult();

    }

    public static void getCountResult() {
         int strike = computer.cntStrike;
         int ball = computer.cntBall;
        computer.countResult();
        computer.gameResult();
    }

    public static void restartMessage() {
        System.out.println("게임을 새로 시작하려면"+RESTART+", 종료하려면 "+END+"를 입력하세요.");
    }

    public static void restartOrNot() {
        restartMessage();
        int num = Player.inputRestartStatus();
        if (num == RESTART) {
            gameRestart();
        } else if (num == END) {
            return;
        } else {
            Exception.inputRestartStatusValidation();
        }
    }
    public static void gameRestart() {
        play();
    }
}
