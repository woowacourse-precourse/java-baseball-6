package baseball;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static final int DIGIT_LENGTH_LIMIT = 3;
    public static final int INITIAL_RANDOM_NUMBER = 1;
    public static final int LAST_RANDOM_NUMBER = 9;
    public static final String CLOSE_GAME_INPUT = "2";

    private static final boolean DEFAULT_IS_NO_ERROR = true;
    private static final boolean DEFAULT_IS_FULL_STRIKE = false;
    private static final String DEFAULT_RESTART_RESPONSE = "-1";

    private String userNumber;
    private List<String> userNumberList;
    private List<String> randomNumberList;
    private int ball;
    private int strike;
    private boolean isNoError;
    private boolean isFullStrike;
    private String restartResponse;

    public Data() {
        this.randomNumberList = new ArrayList<>();
        this.isNoError = DEFAULT_IS_NO_ERROR;
        this.restartResponse = DEFAULT_RESTART_RESPONSE;
        this.isFullStrike = DEFAULT_IS_FULL_STRIKE;
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

    public boolean getIsNoError() {
        return isNoError;
    }

    public void setIsNoError(boolean noError) {
        this.isNoError = noError;
    }

    public boolean getIsFullStrike() {
        return isFullStrike;
    }

    public void setIsFullStrike(boolean isFullStrike) {
        this.isFullStrike = isFullStrike;
    }

    public String getRestartResponse() {
        return restartResponse;
    }

    public void setRestartResponse(String restartResponse) {
        this.restartResponse = restartResponse;
    }
}
