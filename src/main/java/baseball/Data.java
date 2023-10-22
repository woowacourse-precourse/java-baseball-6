package baseball;

import java.util.Arrays;
import java.util.List;

public class Data {
    private String userAnswerNumber;
    private List<String> userAnswerNumberList;
    private int randomNumber;
    private List<String> randomNumberList;
    private List<String> answerList = Arrays.asList("0", "0");
    private String willRestartResponse;
    private boolean digitSizeError = false;

    public String getUserAnswerNumber() {
        return userAnswerNumber;
    }

    public List<String> getUserAnswerNumberList() {
        return userAnswerNumberList;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public List<String> getRandomNumberList() {
        return randomNumberList;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public String getWillRestartResponse() {
        return willRestartResponse;
    }

    public void setUserAnswerNumber(String userAnswerNumber) {
        this.userAnswerNumber = userAnswerNumber;
    }

    public void setUserAnswerNumberList(List<String> userAnswerNumberList) {
        this.userAnswerNumberList = userAnswerNumberList;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void setRandomNumberList(List<String> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public void setWillRestartResponse(String willRestartResponse) {
        this.willRestartResponse = willRestartResponse;
    }

    public void setDigitSizeError(boolean digitSizeError) {
        this.digitSizeError = digitSizeError;
    }
}
