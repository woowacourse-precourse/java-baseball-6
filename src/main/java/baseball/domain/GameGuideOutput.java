package baseball.domain;

import static java.lang.System.out;

class GameGuideOutput {
    static void startGame() {
        out.println("숫자 야구 게임을 시작합니다.");
    }

    static void inputBaseBall() {
        out.print("숫자를 입력해주세요 : ");
    }

    static void gameEnd() {
        out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
