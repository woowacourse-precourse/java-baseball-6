package baseball;

public class Message {
    public String start() {
        return "숫자 야구 게임을 시작합니다.";
    }

    public String requestInput() {
        return "숫자를 입력해주세요 : ";
    }

    public String success() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public String requestRetryOrEnd() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
