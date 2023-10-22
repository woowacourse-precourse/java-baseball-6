package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    private String userAnswerNumber;
    private List<String> userAnswerNumberList;
    private int randomNumber;
    private List<String> randomNumberList;
    private final List<String> RANDOMNUMBERLIST = new ArrayList<>();
    private List<String> answerList;
    private final List<String> ANSWERLIST = Arrays.asList("0", "0");
    private String willRestartResponse;
    private final String WILLRESTARTRESPONSE = "-1";
    private boolean isNoError;
    private final boolean ISNOERROR = true;
    private boolean isCompleteAnswer;
    private final boolean ISCOMPLETEANSWER = false;

    public Data() {
        this.randomNumberList = RANDOMNUMBERLIST;
        this.answerList = ANSWERLIST;
        this.isNoError = ISNOERROR;
        this.willRestartResponse = WILLRESTARTRESPONSE;
        this.isCompleteAnswer = ISCOMPLETEANSWER;
    }

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

    public boolean getIsCompleteAnswer() {
        return isCompleteAnswer;
    }

    public boolean getIsNoError() {
        return isNoError;
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

    public void setIsNoError(boolean noError) {
        this.isNoError = noError;
    }

    public void setIsCompleteAnswer(boolean completeAnswer) {
        isCompleteAnswer = completeAnswer;
    }
}
