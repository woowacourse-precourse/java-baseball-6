package baseball.game;

import baseball.computer.Computer;
import baseball.computer.ComputerNumberHashMap;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final static String SYSTEM_START_MASSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String SYSTEM_INPUT_MASSAGE = "숫자를 입력해주세요 : ";
    private final static String SYSTEM_STRIKE_MASSAGE = "스트라이크";
    private final static String SYSTEM_NOTHING_MASSAGE = "낫싱";
    private final static String SYSTEM_BALL_MASSAGE = "볼";
    private final static String SYSTEM_END_MASSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String RESTART_STRING = "1";
    private final static String END_STRING = "2";

    private Computer computer;

    private Player player;

    private int ball;

    private int strike;

    public Game() {
        this.computer = null;
        this.player = null;
        this.ball = 0;
        this.strike = 0;
    }

    public void initGame() {
        this.computer = new Computer();
        this.player = new Player();
        this.ball = 0;
        this.strike = 0;

        computer.createNumbers();
    }

    public void run() {
        System.out.println(SYSTEM_START_MASSAGE);
        do {
            initGame();
            playGame();
            System.out.println(SYSTEM_END_MASSAGE);
        } while (isGameRestart());
    }

    public void playGame() {
        while (!threeStrike()) {
            System.out.print(SYSTEM_INPUT_MASSAGE);
            readPlayerNumber();
            compareNumber();
        }
    }

    public void readPlayerNumber() {
        String playerInputNumber = Console.readLine();

        if (playerInputNumber.length() > 3) {
            throw new IllegalArgumentException();
        }

        player.setPlayerInputNumber(playerInputNumber);
    }

    public void compareNumber() {
        String playerInputNumber = player.getPlayerInputNumber();
        char[] playerInputNumberCharArray = playerInputNumber.toCharArray();

        ComputerNumberHashMap computerNumbers = computer.getComputerNumbers();

        for (int index = 0; index < 3; index++) {
            int playerNumber = playerInputNumberCharArray[index] - '0';
            if (computerNumbers.contain(playerNumber)) {
                if (computerNumbers.equalIndex(playerNumber, index)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        printHint();
    }

    public void printHint() {
        if (ball == 0 && strike == 0) {
            System.out.println(SYSTEM_NOTHING_MASSAGE);
        }

        if (ball != 0 && strike == 0) {
            System.out.println(ball + SYSTEM_BALL_MASSAGE);
        } else if (ball != 0) {
            System.out.print(ball + SYSTEM_BALL_MASSAGE + " ");
        }

        if (strike != 0) {
            System.out.println(strike + SYSTEM_STRIKE_MASSAGE);
        }
    }

    public boolean isGameRestart() {
        String endFlag = Console.readLine();

        if (endFlag.equals(RESTART_STRING)) {
            return true;
        } else if (endFlag.equals(END_STRING)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean threeStrike() {
        if (strike < 3) {
            this.ball = 0;
            this.strike = 0;
            return false;
        }
        return true;
    }

}
