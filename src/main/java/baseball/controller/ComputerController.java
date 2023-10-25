package baseball.controller;

import baseball.common.InputNumberValidator;
import baseball.common.NumberConstants;
import baseball.common.RandomUtility;
import baseball.model.BallAndStrikeCount;
import baseball.model.ComputerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class ComputerController {
    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String SPACE_MESSAGE = " ";
    public static final String BLANK_MESSAGE = "";

    ComputerNumber computerNumber;
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startGame() {
        initComputerNumber();
        proceedGame();
    }

    public void initComputerNumber() {
        computerNumber = new ComputerNumber(RandomUtility.createComputerNumber());
    }

    public void proceedGame() {
        while(true) {
            outputView.printEnterNumber();
            String inputNumber = inputView.enterNumber();
            InputNumberValidator.validate(inputNumber);
            BallAndStrikeCount count = getBallAndStrikeCount(computerNumber, inputNumber);
            outputView.printHint(getHint(count));
            if(count.getStrikeCount() == NumberConstants.SUCCESS_GAME_STRIKE_NUMBER.getValue()) {
                break;
            }
        }
    }

    public String getHint(BallAndStrikeCount count) {
        String Hint="";
        Hint += getBallHint(count.getBallCount());
        Hint += getStrikeHint(count.getStrikeCount());
        Hint += getNothingHint(count.getStrikeCount(), count.getBallCount());
        return Hint;
    }

    private String getStrikeHint(int strikeCount) {
        if(strikeCount > 0) {
            return strikeCount + STRIKE_MESSAGE + SPACE_MESSAGE;
        }

        return BLANK_MESSAGE;
    }

    private String getBallHint(int ballCount) {
        if(ballCount > 0) {
            return ballCount + BALL_MESSAGE + SPACE_MESSAGE;
        }
        return BLANK_MESSAGE;
    }

    private String getNothingHint(int strikeCount, int ballCount) {
        if(strikeCount == 0 && ballCount == 0) {
            return NOTHING_MESSAGE;
        }

        return BLANK_MESSAGE;
    }

    public BallAndStrikeCount getBallAndStrikeCount(ComputerNumber computerNumber, String inputNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        int[] computerNumberIndex = computerNumber.getNumberIndex();

        for(int i=0; i<inputNumber.length(); i++) {
            int num = Character.getNumericValue(inputNumber.charAt(i));

            if(computerNumberIndex[num] == 0) continue;
            else if(computerNumberIndex[num] == i+1) {
                strikeCount++;
            } else {
                ballCount++;
            }
        }

        return new BallAndStrikeCount(ballCount, strikeCount);
    }
}
