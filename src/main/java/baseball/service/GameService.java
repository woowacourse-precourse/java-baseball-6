package baseball.service;

import baseball.config.withinRange;
import baseball.util.Validate;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final Validate validate;
    private final static String REQUEST_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String BALL = "볼 ";
    private final static String STRIKE = "스트라이크";
    private final static String NOTHING = "낫싱";
    private final static String RE_PLAY = "1";
    private final static String GAME_OVER = "2";
    private final static String GAME_OVER_MESSAGE = "게임을 종료합니다.";
    private final static String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String WRONG_INPUT_MESSAGE = "잘못된 입력입니다.";

    private boolean play = true;

    public GameService(Validate validate) {
        this.validate = validate;
    }

    public void solvingProblem() {
        GenerationQuestionList answerRandomListFactory = new GenerationQuestionList(new ArrayList<>());
        List<Integer> answerRandomList = answerRandomListFactory.generateRandomNumberList(new withinRange(1, 9));

        while (play) {
            System.out.print(REQUEST_INPUT_NUMBER_MESSAGE);
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

        for (int i = 0; i < 3; i++) {
            if (answerList.get(i) == (intArr[i])) {
                ++strikeCount;
            }

            if (answerList.get(i) != (intArr[i]) && answerList.contains(intArr[i])) {
                ++ballCount;
            }
        }
        printResultMessage(strikeCount, ballCount);

        if (strikeCount == 3) {
            printGameEndMessage();
        }
    }

    public void printResultMessage(int StrikeCount, int BallCount) {
        if (BallCount > 0) {
            System.out.print(BallCount + BALL);
        }

        if (StrikeCount > 0) {
            System.out.print(StrikeCount + STRIKE);
        }

        if (StrikeCount == 0 && BallCount == 0) {
            System.out.print(NOTHING);
        }

        System.out.println();
    }

    public void printGameEndMessage() {
        System.out.println(GAME_CLEAR_MESSAGE);
        String input = Console.readLine();

        try {
            if (validate.validationReplayInput(input)) {
                if (input.equals(RE_PLAY)) {
                    solvingProblem();
                }

                if (input.equals(GAME_OVER)) {
                    gamePause();
                    System.out.println(GAME_OVER_MESSAGE);
                }
            }
        } catch (IllegalArgumentException e) {
            gamePause();
            System.out.println(WRONG_INPUT_MESSAGE);
            e.getMessage();
        }
    }
}