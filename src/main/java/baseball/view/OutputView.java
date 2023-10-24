package baseball.view;

import baseball.model.HintModel;


/**
 * 출력 관리
 */
public class OutputView {
    /**
     * 게임 시작 메세지 출력
     */
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 힌트 출력
     * @see HintModel
     * @param hintModel 힌트
     */
    public static void printHint(HintModel hintModel) {
        System.out.println(hintModel.toHintMessage());
    }

    /**
     * 종료 메세지 출력
     */
    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
