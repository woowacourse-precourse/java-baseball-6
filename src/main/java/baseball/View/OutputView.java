package baseball.View;

import baseball.Domain.BaseballScore;

public class OutputView {

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGetNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printScore(BaseballScore score) {
        System.out.println(score);
    }

    public void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");
    }


}
