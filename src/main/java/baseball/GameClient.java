package baseball;

import baseball.participant.Computer;
import baseball.participant.Player;
import baseball.slot.BaseballNumbersSlot;

/**
 * 숫자야구 게임의 전반적인 진행을 담당하는 클래스.
 * <p>게임 진행을 담당한다. 전체적인 게임의 흐름을 구현하는 클래스이다.
 */
public class GameClient {
    public static final int BALL_LENGTH = 3;
    public static final int RANGE_MINIMUM_VALUE = 1;
    public static final int RANGE_MAXIMUM_VALUE = 9;

    private final String MESSAGE_INIT = "숫자 야구 게임을 시작합니다.";
    private final String MESSAGE_PLAYER_INPUT = "숫자를 입력해주세요 : ";
    private final String MESSAGE_GAME_FINISHED_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private final String MESSAGE_REPLAY_FORMAT = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";

    private final Computer computer;
    private final Player player;
    private final Referee referee;

    public GameClient() {
        this.player = new Player();
        this.computer = new Computer();
        this.referee = new Referee();
        System.out.println(MESSAGE_INIT);
    }

    public void playBaseball() {
        BallCount ballCount;
        computer.refreshAnswer();

        do {
            System.out.print(MESSAGE_PLAYER_INPUT);
            player.guessNumbers();
            BaseballNumbersSlot playerNumbers = player.getSlot();
            BaseballNumbersSlot answerNumbers = computer.getSlot();
            ballCount = referee.calculateBallCount(playerNumbers, answerNumbers);
            System.out.println(ballCount);
        } while (!ballCount.isOut());

        System.out.printf(MESSAGE_GAME_FINISHED_FORMAT, BALL_LENGTH);
    }

    public boolean askForReplay() {
        System.out.printf(MESSAGE_REPLAY_FORMAT, GameMenu.REPLAY, GameMenu.EXIT);
        return player.getMenu() == GameMenu.REPLAY;
    }
}
