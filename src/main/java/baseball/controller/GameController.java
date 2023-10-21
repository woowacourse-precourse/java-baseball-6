package baseball.controller;

import baseball.model.Computer;
import baseball.util.BaseballNumberGenerator;
import baseball.util.BaseballRandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final static String GAME_RETRY_VALUE = "1";
    private final static String NOTHING_STRING = "낫싱";
    private final static String BALL_STRING = "볼";
    private final static String STRIKE_STRING = "스트라이크";
    private final static int COUNT_ZERO_VALUE = 0;
    private final static int LIST_BALL_INDEX = 0;
    private final static int LIST_STRIKE_INDEX = 1;
    private static Computer computer = new Computer(new BaseballRandomNumberGenerator().generate());
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public void start(){
        computer.printComputer();
        outputView.printGameStartMessage();
        boolean gameLoopCommand = true;
        while (gameLoopCommand){
            outputView.printGameNumberInputMessage();
            List<Integer> userInputNumber = transferStringToIntegerList(inputView.readBaseballNumber());
            List<Integer> ballAndStrikeCount = computer.compareNumberList(userInputNumber);
            String hintMessage = provideStrikeAndBallCount(ballAndStrikeCount.get(LIST_BALL_INDEX),ballAndStrikeCount.get(LIST_STRIKE_INDEX));
            outputView.printGameHint(hintMessage);
            if (ballAndStrikeCount.get(LIST_STRIKE_INDEX) == 3){
                gameLoopCommand = gameRetry();
            }
        }
    }
    private static List<Integer> transferStringToIntegerList(String targetString){
        String[] stringList = targetString.split("");
        List<Integer> result = new ArrayList<>();
        for(String s : stringList){
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    private static String provideStrikeAndBallCount(int ballCount, int strikeCount){
        //둘다 0 나싱
        if(ballCount == COUNT_ZERO_VALUE && strikeCount == COUNT_ZERO_VALUE){
            return NOTHING_STRING;
        }else if (ballCount != COUNT_ZERO_VALUE && strikeCount == COUNT_ZERO_VALUE) {
            return String.valueOf(ballCount) + BALL_STRING;
        }else if (ballCount == COUNT_ZERO_VALUE) {
            return String.valueOf(strikeCount) + STRIKE_STRING;
        }
        return String.valueOf(ballCount) + BALL_STRING + " " + String.valueOf(strikeCount) + STRIKE_STRING;
    }

    private static boolean gameRetry(){
        outputView.printGameEndMessage();
        outputView.printGameRetryMessage();
        String command = inputView.readRetryCommand();
        if (command.equals(GAME_RETRY_VALUE)){
            computer = new Computer(new BaseballRandomNumberGenerator().generate());
            return true;
        }
        return false;
    }
}
