package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseBallGame {

    private static BaseBallGame baseBallGame;

    public int numOfBall = 0;
    public int numOfStrike = 0;
    public final String INPUT_REGEX = "([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])";
    public final String ONE_OR_TWO = "[12]";

    public static BaseBallGame getInstance() {
        if (baseBallGame == null) {
            baseBallGame = new BaseBallGame();
        }
        return baseBallGame;
    }

    public void initializeNum() {
        numOfBall = 0;
        numOfStrike = 0;
    }

    public void run() {
        do {
            System.out.print(OutputMessage.START_GAME);

            Computer computer = new Computer();
            // 정답 확인용 임시 코드
            System.out.println(Arrays.toString(computer.getRandomNumber().toArray()));

            checkAnswer(computer);

            System.out.println(OutputMessage.END_OR_NOT);

        } while (!askWhetherToEnd());
    }


    private void checkAnswer(Computer computer) {
        do {
            System.out.print(OutputMessage.ENTER_NUMBER);
            List<Integer> input = getInput();
            compareAnswerToInput(computer, input);
        } while (!getResult());
    }

    private static List<Integer> getInput() {
        String st = Console.readLine();
        throwException(st);
        String[] arr = st.split("");

        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            input.add(Integer.parseInt(arr[i]));
        }
        return input;
    }

    private static void throwException(String st) {
        if (!st.matches(baseBallGame.INPUT_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private void compareAnswerToInput(Computer computer, List<Integer> input) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.getRandomNumber().get(i).equals(input.get(j))) {
                    if (i == j) {
                        numOfStrike++;
                        break;
                    } else {
                        numOfBall++;
                        break;
                    }
                }
            }
        }
    }

    private boolean getResult() {
        if (numOfBall == 0 && numOfStrike == 0) {
            System.out.print("낫싱");
        } else {
            if (!(numOfBall == 0)) {
                System.out.printf("%d볼 ", numOfBall);
            }
            if (!(numOfStrike == 0)) {
                System.out.printf("%d스트라이크", numOfStrike);
            }
        }

        if (numOfStrike == 3) {
            initializeNum();
            return true;
        }

        initializeNum();
        return false;
    }

    private static boolean askWhetherToEnd() {
        String st = Console.readLine();
        throwException2(st);
        return Integer.parseInt(st) == 2;
    }

    private static void throwException2(String st) {
        if (!st.matches(baseBallGame.ONE_OR_TWO)) {
            throw new IllegalArgumentException();
        }
    }
}
