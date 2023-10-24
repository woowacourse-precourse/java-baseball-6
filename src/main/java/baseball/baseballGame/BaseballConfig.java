package baseball.baseballGame;

import baseball.game.Config;

public class BaseballConfig implements Config {
    int minOfRange;
    int maxOfRange;
    int numOfNumbers;
    int playOption;
    int endOption;
    @Override
    public int getPlayOption() {
        return playOption;
    }
    @Override
    public int getEndOption() {
        return endOption;
    }
    BaseballConfig(){
        minOfRange = 1;
        maxOfRange = 9;
        numOfNumbers = 3;
        playOption = 1;
        endOption = 2;
    }
    public int getMinOfRange() {
        return minOfRange;
    }

    public int getMaxOfRange() {
        return maxOfRange;
    }

    public int getNumOfNumbers() {
        return numOfNumbers;
    }


}
