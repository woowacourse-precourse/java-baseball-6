package baseball.service;

import static baseball.util.ThreeOutCount.getThreeOutCount;

import baseball.config.WithinRange;
import baseball.util.Validate;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    public final static String RE_PLAY = "1";
    public final static String GAME_OVER = "2";

    private final Validate validate;
    private final OutputView outputVIew;

    private boolean play = true;

    public GameService(Validate validate, OutputView outputVIew) {
        this.validate = validate;
        this.outputVIew = outputVIew;
    }

    public void playBallGame() {
        gameStart();
        GenerationQuestionList answerRandomListFactory = new GenerationQuestionList(new ArrayList<>());
        List<Integer> answerRandomList = answerRandomListFactory.generateRandomNumberList(new WithinRange(1, 9));

        while (play) {
            outputVIew.printRequestInputNumberMessage();
            String str = Console.readLine();

            if ((validate.combinedValidation(str))) {
                checkResult(str, answerRandomList);
            }
        }
    }

    private void gameStart() {
        play = true;
    }

    private void gamePause() {
        play = false;
    }

    public void checkResult(String input, List<Integer> answerList) {
        int strikeCount = 0;
        int ballCount = 0;

        int[] intArr = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            intArr[i] = Integer.parseInt(input.substring(i, i + 1));
        }

        for (int i = 0; i < getThreeOutCount(); i++) {
            if (answerList.get(i) == (intArr[i])) {
                ++strikeCount;
            }

            if (answerList.get(i) != (intArr[i]) && answerList.contains(intArr[i])) {
                ++ballCount;
            }
        }
        printResultMessage(strikeCount, ballCount);

        if (strikeCount == getThreeOutCount()) {
            printGameEndMessage();
        }
    }

    public void printResultMessage(int strikeCount, int ballCount) {
        if (ballCount > 0) {
            outputVIew.printBall(ballCount);
        }

        if (strikeCount > 0) {
            outputVIew.printStrike(strikeCount);
        }

        if (strikeCount == 0 && ballCount == 0) {
            outputVIew.printNothing();
        }

        System.out.println();
    }

    public void printGameEndMessage() {
        outputVIew.printGameClear();
        String input = Console.readLine();

        if (validate.validationReplayInput(input)) {
            if (input.equals(RE_PLAY)) {
                playBallGame();
            }

            if (input.equals(GAME_OVER)) {
                gamePause();
                outputVIew.printGameOver();
            }
        }
    }
}