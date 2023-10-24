package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    private static final int BOARD_LIMIT = 3;
    private final List<Integer> board = new ArrayList<Integer>();

    private void validateDuplicateNumber(int number){
        if(board.contains(number))
            throw new IllegalArgumentException();
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

    private void printGameScore(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public int countAndPrintGameScore(GameNumber gameNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < BOARD_LIMIT; i++) {
            if (this.board.equals(gameNumber.getBoard())) {
                return 3;
            } else if (this.board.get(i).equals(gameNumber.getBoard().get(i))) {
                strike++;
            } else if (this.board.contains(gameNumber.getBoard().get(i))) {
                ball++;
            }
        }
        printGameScore(strike, ball);
        return strike;
    }

}
