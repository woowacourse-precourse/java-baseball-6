package baseball.view;

import baseball.domain.HintType;

import java.util.Map;

public final class OutputView {

    private static final String BALL_TEXT = "볼";
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String NOTHING_TEXT = "낫싱";

    static {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public void viewInputNumbers() {
        System.out.print("숫자를 입력해주세요 :");
    }

    public void viewHint(Map<HintType, Integer> hintMap) {
        if (hintMap.containsKey(HintType.BALL)) {
            System.out.print(hintMap.get(HintType.BALL) + BALL_TEXT + " ");
        }
        if (hintMap.containsKey(HintType.STRIKE)) {
            System.out.print(hintMap.get(HintType.STRIKE) + STRIKE_TEXT + " ");
        }
        if (hintMap.containsKey(HintType.NOTHING)) {
            System.out.print(hintMap.get(NOTHING_TEXT));
        }
        System.out.println();
    }

    public void viewCorrectAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void viewEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
