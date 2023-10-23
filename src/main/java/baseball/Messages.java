package baseball;

public class Messages {

    private String introMessage = "숫자 야구 게임을 시작합니다.";
    private String inputMessage = "숫자를 입력해주세요 : ";
    private String sameNumberMessage = "볼";
    private String sameDigitMessage = "스트라이크";
    private String wrongMessage = "낫싱";
    private String outroMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private String willRestartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getIntroMessage() {
        return introMessage;
    }

    public void setIntroMessage(String introMessage) {
        this.introMessage = introMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getSameNumberMessage() {
        return sameNumberMessage;
    }

    public void setSameNumberMessage(String sameNumberMessage) {
        this.sameNumberMessage = sameNumberMessage;
    }

    public String getSameDigitMessage() {
        return sameDigitMessage;
    }

    public void setSameDigitMessage(String sameDigitMessage) {
        this.sameDigitMessage = sameDigitMessage;
    }

    public String getWrongMessage() {
        return wrongMessage;
    }

    public void setWrongMessage(String wrongMessage) {
        this.wrongMessage = wrongMessage;
    }

    public String getOutroMessage() {
        return outroMessage;
    }

    public void setOutroMessage(String outroMessage) {
        this.outroMessage = outroMessage;
    }

    public String getWillRestartMessage() {
        return willRestartMessage;
    }

    public void setWillRestartMessage(String willRestartMessage) {
        this.willRestartMessage = willRestartMessage;
    }
}
