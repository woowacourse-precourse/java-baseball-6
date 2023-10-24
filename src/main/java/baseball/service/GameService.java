package baseball.service;

import static baseball.util.ThreeOutCount.getTreeOutCount;

import baseball.config.withinRange;
import baseball.util.Validate;
import baseball.view.OutputVIew;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    public final static String RE_PLAY = "1";
    public final static String GAME_OVER = "2";

    private final Validate validate;
    private final OutputVIew outputVIew;

    private boolean play = true;

    public GameService(Validate validate, OutputVIew outputVIew) {
        this.validate = validate;
        this.outputVIew = outputVIew;
    }

    public void playBallGame() {
        GenerationQuestionList answerRandomListFactory = new GenerationQuestionList(new ArrayList<>());
        List<Integer> answerRandomList = answerRandomListFactory.generateRandomNumberList(new withinRange(1, 9));

        System.out.println(answerRandomList);

        while (play) {
            outputVIew.printRequestInputNumberMessage();
            String str = Console.readLine();

            try {
                validate.combinedValidation(str);
            } catch (IllegalArgumentException e) {
                gamePause();
                e.setStackTrace(e.getStackTrace());
            }

            if ((validate.combinedValidation(str))) {
                checkResult(str, answerRandomList);
            }
        }
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

        for (int i = 0; i < getTreeOutCount(); i++) {
            if (answerList.get(i) == (intArr[i])) {
                ++strikeCount;
            }

            if (answerList.get(i) != (intArr[i]) && answerList.contains(intArr[i])) {
                ++ballCount;
            }
        }
        printResultMessage(strikeCount, ballCount);

        if (strikeCount == getTreeOutCount()) {
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

        try {
            if (validate.validationReplayInput(input)) {
                if (input.equals(RE_PLAY)) {
                    playBallGame();
                }

                if (input.equals(GAME_OVER)) {
                    gamePause();
                    outputVIew.printGameOver();
                }
            }
        } catch (IllegalArgumentException e) {
            gamePause();
            outputVIew.printWrongInput();
            e.getMessage();
        }
    }
}