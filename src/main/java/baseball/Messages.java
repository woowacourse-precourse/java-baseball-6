package baseball;

public class Messages {

    private String introText = "숫자 야구 게임을 시작합니다.";
    private String inputText = "숫자를 입력해주세요 : ";
    private String ballText = "볼";
    private String strikeText = "스트라이크";
    private String nothingText = "낫싱";
    private String fullStrikeText = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private String willRestartText = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    protected String getIntroText() {
        return introText;
    }

    protected void setIntroText(String introText) {
        this.introText = introText;
    }

    protected String getInputText() {
        return inputText;
    }

    protected void setInputText(String inputText) {
        this.inputText = inputText;
    }

    protected String getBallText() {
        return ballText;
    }

    protected void setBallText(String ballText) {
        this.ballText = ballText;
    }

    protected String getStrikeText() {
        return strikeText;
    }

    protected void setStrikeText(String strikeText) {
        this.strikeText = strikeText;
    }

    protected String getNothingText() {
        return nothingText;
    }

    protected void setNothingText(String nothingText) {
        this.nothingText = nothingText;
    }

    protected String getFullStrikeText() {
        return fullStrikeText;
    }

    protected void setFullStrikeText(String fullStrikeText) {
        this.fullStrikeText = fullStrikeText;
    }

    protected String getWillRestartText() {
        return willRestartText;
    }

    protected void setWillRestartText(String willRestartText) {
        this.willRestartText = willRestartText;
    }
}
