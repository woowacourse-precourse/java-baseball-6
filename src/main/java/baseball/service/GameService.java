package baseball.service;

import baseball.config.withinRange;
import baseball.util.Validate;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final Validate validate;
    boolean play = true;

    public GameService(Validate validate) {
        this.validate = validate;
    }

    public void solvingProblem() {
        GenerationQuestionList answerRandomListFactory = new GenerationQuestionList(new ArrayList<>());

        List<Integer> answerRandomList = answerRandomListFactory.generateRandomNumberList(
                new withinRange(1, 9));

        while (play) {
            System.out.print("숫자를 입력해주세요 : ");
            String str = Console.readLine();

            try {
                validate.combinedValidation(str);
            } catch (IllegalArgumentException e) {
                play = false;
                e.setStackTrace(e.getStackTrace());
            }

            if ((validate.combinedValidation(str))) {
                checkResult(str, answerRandomList);
            }
        }
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
            System.out.print(BallCount + "볼 ");
        }

        if (StrikeCount > 0) {
            System.out.print(StrikeCount + "스트라이크");
        }

        if (StrikeCount == 0 && BallCount == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        try {
            if (validate.validationReplayInput(input)) {
                if (input.equals("1")) {
                    solvingProblem();
                }

                if (input.equals("2")) {
                    play = false;
                    System.out.println("게임을 종료합니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            play = false;
            System.out.println("잘못된 입력입니다.");
            e.getMessage();
        }
    }
}