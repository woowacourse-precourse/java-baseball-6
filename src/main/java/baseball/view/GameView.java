package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.model.BaseballGameCountsMessage;
import baseball.model.UserNumber;
import java.util.Objects;

public class GameView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameWinMessage() {
        System.out.println(GAME_WIN_MESSAGE);
    }

    public static UserNumber getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return new UserNumber(readLine());
    }

    public static void printBaseballGameCountsMessage(BaseballGameCountsMessage message) {
        System.out.println(message.getMessage());
    }
}
