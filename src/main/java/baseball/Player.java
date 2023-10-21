package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public static final String INPUT_MUST_3_NUMBER_EXCEPTION = "입력은 3개의 정수로 이루어져 있어야 합니다.";
    public static final String INPUT_MUST_NOT_DUPLICATED_EXCEPTION = "정수는 모두 서로 달라야 합니다.";
    public static final String NUMBER_FORMAT_EXCEPTION = "숫자가 아닌 입력이 있습니다";
    public static final String WRONG_INPUT_IN_RESTART_EXCEPTION = "잘못된 입력입니다. (재시작 : 1, 종료 : 2)";
    private static int RESTART = 1;
    private static int END = 2;

    /**
     * 사용자에게 서로 다른 3가지 정수를 입력받는다.
     *
     * @return 사용자가 입력한 정수를 List<Integer>에 담아 반환
     * @throws IllegalArgumentException
     */
    public List<Integer> getInput() throws IllegalArgumentException {
        String input = Console.readLine();
        return getInput(input);
    }

    public List<Integer> getInput(String input) throws IllegalArgumentException {
        String[] tokens = input.split("");
        if (tokens.length != 3) {
            throw new IllegalArgumentException(INPUT_MUST_3_NUMBER_EXCEPTION);
        }

        ArrayList<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            try {
                int n = Integer.parseInt(tokens[i]);
                if (inputNumbers.contains(n)) {
                    throw new IllegalArgumentException(INPUT_MUST_NOT_DUPLICATED_EXCEPTION);
                }
                inputNumbers.add(n);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
            }
        }
        return inputNumbers;
    }

    /**
     * 재시작 여부를 반환한다.
     *
     * @return true - 재시작의 경우, false - 종료의 경우
     * @throws IllegalArgumentException
     */
    public boolean restart() throws IllegalArgumentException {
        String input = Console.readLine();
        return restart(input);
    }

    //테스트를 위한 오버로딩
    public boolean restart(String s) throws IllegalArgumentException {
        try {
            int input = Integer.parseInt(s);
            if (input == RESTART) {
                return true;
            }
            if (input == END) {
                return false;
            }
            throw new IllegalArgumentException(WRONG_INPUT_IN_RESTART_EXCEPTION);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
