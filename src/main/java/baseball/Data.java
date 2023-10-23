package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    private final List<String> RANDOMNUMBERLIST = new ArrayList<>();
    private final List<Integer> RESULTLIST = Arrays.asList(0, 0);
    private final String WILLRESTARTRESPONSE = "-1";
    private final boolean ISNOERROR = true;
    private final boolean ISCOMPLETEANSWER = false;
    private String userNumber;
    private List<String> userNumberList;
    private int randomNumber;
    private List<String> randomNumberList;
    private List<Integer> resultList;
    private String willRestartResponse;
    private boolean isNoError;
    private boolean isCompleteAnswer;

    public Data() {
        this.randomNumberList = RANDOMNUMBERLIST;
        this.resultList = RESULTLIST;
        this.isNoError = ISNOERROR;
        this.willRestartResponse = WILLRESTARTRESPONSE;
        this.isCompleteAnswer = ISCOMPLETEANSWER;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public List<String> getUserNumberList() {
        return userNumberList;
    }

    public void setUserNumberList(List<String> userNumberList) {
        this.userNumberList = userNumberList;
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

    public List<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
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
