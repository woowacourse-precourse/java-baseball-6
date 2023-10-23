package baseball;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private final List<String> RANDOMNUMBERLIST = new ArrayList<>();
    private final String RESTARTRESPONSE = "-1";
    private final boolean ISNOERROR = true;
    private final boolean ISFULLSTRIKE = false;
    private String userNumber;
    private List<String> userNumberList;
    private int randomNumber;
    private List<String> randomNumberList;
    private int ball;
    private int strike;
    private String restartResponse;
    private boolean isNoError;
    private boolean isFullStrike;

    public Data() {
        this.randomNumberList = RANDOMNUMBERLIST;
        this.isNoError = ISNOERROR;
        this.restartResponse = RESTARTRESPONSE;
        this.isFullStrike = ISFULLSTRIKE;
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

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public String getRestartResponse() {
        return restartResponse;
    }

    public void setRestartResponse(String restartResponse) {
        this.restartResponse = restartResponse;
    }

    public boolean getIsCompleteAnswer() {
        return isFullStrike;
    }

    public void setIsCompleteAnswer(boolean completeAnswer) {
        isFullStrike = completeAnswer;
    }

    public boolean getIsNoError() {
        return isNoError;
    }

    public void setIsNoError(boolean noError) {
        this.isNoError = noError;
    }
}
