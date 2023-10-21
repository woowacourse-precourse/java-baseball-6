package baseball.view;

import baseball.domain.HintType;

import java.util.Map;

public final class OutputView {


    static {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public void displayInputNumbers() {
        System.out.print("숫자를 입력해주세요 :");
    }

    public void displayHint(Map<HintType, Integer> hintMap) {
        if (hintMap.containsKey(HintType.BALL)) {
            System.out.print(hintMap.get(HintType.BALL) + HintType.BALL.getName() + " ");
        }
        if (hintMap.containsKey(HintType.STRIKE)) {
            System.out.print(hintMap.get(HintType.STRIKE) + HintType.STRIKE.getName() + " ");
        }
        if (hintMap.containsKey(HintType.NOTHING)) {
            System.out.print(HintType.NOTHING.getName());
        }
        System.out.println();
    }

    public void displayCorrectAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void viewEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
