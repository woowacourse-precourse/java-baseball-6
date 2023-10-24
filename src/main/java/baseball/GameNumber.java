package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    private static final int BOARD_LIMIT = 3;
    private final List<Integer> board = new ArrayList<Integer>();

    private void validateDuplicateNumber(int number) {
        if (board.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(String number) {
        if (number.length() > BOARD_LIMIT) {
            throw new IllegalArgumentException();
        }
        for (char c : number.toCharArray()) {
            int integerValue = Character.getNumericValue(c);
            if (integerValue == -1 || integerValue == 0) {
                throw new IllegalArgumentException();
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

    public GameNumber(String number) {
        validateNumber(number);
        for (char c : number.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            validateDuplicateNumber(numericValue);
            board.add(numericValue);
        }
    }

    public GameNumber() {
        generateRandomizeNumber();
    }

    public List<Integer> getBoard() {
        return this.board;
    }
}
