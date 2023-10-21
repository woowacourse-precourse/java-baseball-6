package baseball;

public class Messages {
    private String introMessage = "숫자 야구 게임을 시작합니다.";
    private String inputMessage = "숫자를 입력해주세요 : ";;
    private String outroMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private String sameDigitMessage = "스트라이크";
    private String sameNumberMessage = "볼";

    public Messages() {
        this.introMessage = introMessage;
        this.inputMessage = inputMessage;
        this.outroMessage = outroMessage;
        this.sameDigitMessage = sameDigitMessage;
        this.sameNumberMessage = sameNumberMessage;
    }

    public void setIntroMessage(String introMessage) {
        this.introMessage = introMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public void setSameDigitMessage(String sameDigitMessage) {
        this.sameDigitMessage = sameDigitMessage;
    }

    public void setSameNumberMessage(String sameNumberMessage) {
        this.sameNumberMessage = sameNumberMessage;
    }

    public void setOutroMessage(String outroMessage) {
        this.outroMessage = outroMessage;
    }

    public String getIntroMessage() {
        return introMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public String getSameDigitMessage() {
        return sameDigitMessage;
    }

    public String getSameNumberMessage() {
        return sameNumberMessage;
    }

    public String getOutroMessage() {
        return outroMessage;
    }
}
