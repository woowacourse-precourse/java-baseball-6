package baseball;

public class Messages {

    private String introText = "숫자 야구 게임을 시작합니다.";
    private String inputText = "숫자를 입력해주세요 : ";
    private String ballText = "볼";
    private String strikeText = "스트라이크";
    private String nothingText = "낫싱";
    private String fullStrikeText = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private String willRestartText = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getIntroText() {
        return introText;
    }

    public void setIntroText(String introText) {
        this.introText = introText;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getBallText() {
        return ballText;
    }

    public void setBallText(String ballText) {
        this.ballText = ballText;
    }

    public String getStrikeText() {
        return strikeText;
    }

    public void setStrikeText(String strikeText) {
        this.strikeText = strikeText;
    }

    public String getNothingText() {
        return nothingText;
    }

    public void setNothingText(String nothingText) {
        this.nothingText = nothingText;
    }

    public String getFullStrikeText() {
        return fullStrikeText;
    }

    public void setFullStrikeText(String fullStrikeText) {
        this.fullStrikeText = fullStrikeText;
    }

    public String getWillRestartText() {
        return willRestartText;
    }

    public void setWillRestartText(String willRestartText) {
        this.willRestartText = willRestartText;
    }
}
