package baseball.view;

import baseball.model.BaseballResult;

/**
 * 야구 게임의 화면과 관련된 출력 및 사용자로부터의 입력을 관리하는 뷰 클래스입니다.
 *
 * <p>이 클래스는 야구 게임과 관련된 다양한 메시지를 출력하고, 사용자의 응답에 따라 메시지를 변경하거나 다음 동작을 지시합니다.</p>
 *
 * <p>주요 기능:
 * <ul>
 *   <li>게임 시작 메시지 출력</li>
 *   <li>숫자 입력 메시지 출력</li>
 *   <li>게임 결과 메시지 출력</li>
 *   <li>게임 종료 및 재시작 여부 메시지 출력</li>
 * </ul>
 * </p>
 */
public class GameView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 :";
    private static final String PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    /**
     * 게임 시작 메시지를 출력합니다.
     */
    public void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    /**
     * 사용자에게 숫자 입력을 요청하는 메시지를 출력합니다.
     */
    public void printInputNumbersMessage() {
        System.out.println(INPUT_NUMBERS_MESSAGE);
    }

    /**
     * 스트라이크와 볼의 결과 메시지를 출력합니다.
     *
     * @param strikes 스트라이크의 개수
     * @param balls 볼의 개수
     */
    public void displayResult(int strikes, int balls) {
        System.out.println(BaseballResult.getResultMessage(strikes, balls));
    }

    /**
     * 게임 종료 메시지를 출력합니다.
     */
    public void displayGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    /**
     * 게임을 다시 시작할 것인지를 묻는 메시지를 출력합니다.
     */
    public void printPlayAgainMessage() {
        System.out.println(PLAY_AGAIN_MESSAGE);
    }
}
