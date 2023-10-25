package baseball.view;

import baseball.domain.hints.HintType;

import java.util.Map;

import static baseball.domain.hints.HintType.*;

public final class OutputView {
    static {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void displayInputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void displayHint(Map<HintType, Integer> hintMap) {
        if (hintMap.containsKey(BALL)) {
            System.out.print(hintMap.get(BALL) + BALL.getName() + " ");
        }
        if (hintMap.containsKey(STRIKE)) {
            System.out.print(hintMap.get(STRIKE) + STRIKE.getName() + " ");
        }
        if (hintMap.containsKey(NOTHING)) {
            System.out.print(NOTHING.getName());
        }
        System.out.println();
    }

    public void displayCorrectAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void displaySelect() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}