package baseball;

public class OutputManager {

    void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void printRequestInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    void printStrikeOrBallMessage(int ballNum, int strikeNum) {
        if (ballNum == 0 && strikeNum == 0) {
            System.out.println("낫싱");
            return ;
        } else if (ballNum == 0 && strikeNum == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
            System.out.println("게임 종료");
            return ;
        } else if (strikeNum == 0) {
            System.out.println(ballNum+"볼");
        } else if (ballNum == 0) {
            System.out.println(strikeNum+"스트라이크");
        }
        System.out.println(ballNum+"볼 "+strikeNum+" 스트라이크");
    }

    void printRetryOrEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}