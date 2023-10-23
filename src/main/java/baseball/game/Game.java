package baseball.game;

import baseball.computer.Computer;
import baseball.computer.ComputerNumberHashMap;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final static String SYSTEM_START_MASSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String SYSTEM_INPUT_MASSAGE = "숫자를 입력해주세요 : ";
    private final static String SYSTEM_STRIKE_MASSAGE = "스트라이크";
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

    public void playGame() {
        while (!threeStrike()) {
            System.out.print(SYSTEM_INPUT_MASSAGE);
            this.ball = 0;
            this.strike = 0;
            readPlayerNumber();
            getHint();
        }
    }

    public boolean isGameRestart() {
        String endFlag = Console.readLine();

        if (endFlag.equals(RESTART_STRING)) {
            return true;
        }
        else if (endFlag.equals(END_STRING)) {
            return false;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void readPlayerNumber() {
        String playerNumString = Console.readLine();
        if (playerNumString.length() > 3) {
            throw new IllegalArgumentException();
        }

        player.setPlayerNumString(playerNumString);
    }

    public void run() {
        System.out.println(SYSTEM_START_MASSAGE);
        do {
            initGame();
            playGame();
            System.out.println(SYSTEM_END_MASSAGE);
        } while (isGameRestart());
    }

    private boolean threeStrike() {
        return strike == 3;
    }

}
