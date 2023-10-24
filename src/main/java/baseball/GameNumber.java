package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameNumber {
    private static final int BOARD_LIMIT = 3;
    private final List<Integer> board = new ArrayList<Integer>();
    private static final String INPUT_DUPLICATE_ERROR_MESSAGE = "입력은 서로다른 3자리 수만 가능합니다.";
    private static final String INPUT_OUT_OF_BOUND_ERROR_MESSAGE = "입력은 서로다른 3자리 수만 가능합니다.";
    private static final String INPUT_NUMERIC_ERROR_MESSAGE = "양의 정수만 입력 가능합니다.";

    private void validateDuplicateNumber(int number) {
        if (board.contains(number)) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateNumber(String number) {
        if (number.length() > BOARD_LIMIT) {
            throw new IllegalArgumentException(INPUT_OUT_OF_BOUND_ERROR_MESSAGE);
        }
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException(INPUT_NUMERIC_ERROR_MESSAGE);
            }
        }
    }

    private void generateRandomizeNumber() {
        while (board.size() < BOARD_LIMIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!board.contains(randomNumber)) {
                board.add(randomNumber);
            }
        }
    }

    private void initBoard(){
        this.board.clear();
    }

    public GameNumber(String number) {
       initBoard();
        validateNumber(number);
        for (char c : number.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            validateDuplicateNumber(numericValue);
            board.add(numericValue);
        }
    }

    public GameNumber() {
        initBoard();
        generateRandomizeNumber();
        System.out.println(getBoard());
    }

    public List<Integer> getBoard() {
        return this.board;
    }
}
