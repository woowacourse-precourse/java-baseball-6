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

}
