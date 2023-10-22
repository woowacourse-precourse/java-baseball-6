package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    private final List<String> RANDOMNUMBERLIST = new ArrayList<>();
    private final List<String> ANSWERLIST = Arrays.asList("0", "0");
    private final String WILLRESTARTRESPONSE = "-1";
    private final boolean ISNOERROR = true;
    private final boolean ISCOMPLETEANSWER = false;
    private String userAnswerNumber;
    private List<String> userAnswerNumberList;
    private int randomNumber;
    private List<String> randomNumberList;
    private List<String> answerList;
    private String willRestartResponse;
    private boolean isNoError;
    private boolean isCompleteAnswer;

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

    public void setUserAnswerNumber(String userAnswerNumber) {
        this.userAnswerNumber = userAnswerNumber;
    }

    public List<String> getUserAnswerNumberList() {
        return userAnswerNumberList;
    }

    public void setUserAnswerNumberList(List<String> userAnswerNumberList) {
        this.userAnswerNumberList = userAnswerNumberList;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<String> getRandomNumberList() {
        return randomNumberList;
    }

    public void setRandomNumberList(List<String> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public String getWillRestartResponse() {
        return willRestartResponse;
    }

    public void setWillRestartResponse(String willRestartResponse) {
        this.willRestartResponse = willRestartResponse;
    }

    public boolean getIsCompleteAnswer() {
        return isCompleteAnswer;
    }

    public void setIsCompleteAnswer(boolean completeAnswer) {
        isCompleteAnswer = completeAnswer;
    }

    public boolean getIsNoError() {
        return isNoError;
    }

    public void setIsNoError(boolean noError) {
        this.isNoError = noError;
    }
}
