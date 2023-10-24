
package baseball.Controller;


import baseball.Util.NumberUtil;
import baseball.View.OutputView;
import baseball.Model.PlayNumber;

import java.util.List;

public class ComputerController{
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final int GAME_SUCCESS_STRIKE_COUNT = 3;
    private static final String NOTHING_MESSAGE = "낫싱";
    NumberUtil numberUtil = new NumberUtil();
    OutputView outputView = new OutputView();
    int strikeCount;
    int ballCount;


    public void StartGame(PlayNumber playNumber){
        List<Integer> numbers = numberUtil.generateRandomNumbers();
        playNumber.setComputerNumbers(numbers);
    }

    public boolean checkStrikeAndBall(PlayNumber playNumber){
        List<Integer> computerNumbers = playNumber.getComputerNumbers();
        List<Integer> inputNumbers = playNumber.getInputNumbers();
        initCount();
        compareNumbers(computerNumbers,inputNumbers);
        printResult(ballCount,strikeCount);
        return isSuccessResult(strikeCount);
    }

    private void compareNumbers(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        for(int number : inputNumbers){
            if(computerNumbers.contains(number)){
                countStrike(computerNumbers.indexOf(number),inputNumbers.indexOf(number));
                countBall(computerNumbers.indexOf(number),inputNumbers.indexOf(number));
            }
        }
    }

    private void countBall(int computerNum, int inputNum) {
        if(computerNum != inputNum) {
            ballCount++;
        }
    }

    private void countStrike(int computerNum, int inputNum) {
        if(computerNum == inputNum){
            strikeCount++;
        }
    }

    private void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    private boolean isSuccessResult(int strikeCount) {
        if(strikeCount == GAME_SUCCESS_STRIKE_COUNT){
            outputView.endGame();
            return true;
        }else {
            return false;
        }
    }

    private void printResult(int ballCount, int strikeCount) {
        StringBuilder sb = new StringBuilder();
        if(ballCount > 0){
            sb.append(ballCount).append(BALL_MESSAGE).append(" ");
        }
        if(strikeCount > 0){
            sb.append(strikeCount).append(STRIKE_MESSAGE);
        }
        if(ballCount == 0 && strikeCount == 0){
            sb.append(NOTHING_MESSAGE);
        }
        outputView.baseballResult(sb.toString());
    }
}