package baseball.game;

public class NumberBaseBallGameMessage implements IMessage {

    @Override
    public String greetingMessage() {
        return "숫자 야구 게임을 시작합니다.";
    }

    @Override
    public String requestNumberMessage() {
        return "숫자를 입력해주세요 : ";
    }

    @Override
    public String ballCountMessage() {
        return "볼 ";
    }

    @Override
    public String strikeCountMessage() {
        return "스트라이크";
    }

    @Override
    public String nothingMessage() {
        return "낫싱";
    }

    @Override
    public String gameOverMessage() {
        return "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    @Override
    public String retryMessage() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }

    public String retryErrorMessage() {
        return "1 또는 2의 숫자만 입력해주세요.";
    }

    public String inputNumberErrorMessage() {
        return "중복 되지 않는 1~9까지의 3자리 숫자를 입력해 주세요";
    }
}
