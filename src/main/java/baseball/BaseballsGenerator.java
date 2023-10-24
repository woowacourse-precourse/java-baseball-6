package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Baseball.MAX_NUMBER;
import static baseball.Baseball.MIN_NUMBER;
import static baseball.Baseballs.BASEBALLS_SIZE;

public class BaseballsGenerator {

    private static final char ASCII_ZERO_CHAR = '0';

    public static Baseballs createBaseballsByUserInput(String ballNumbers) {
        List<Baseball> baseballs = new ArrayList<>();
        for (int index = 0; index < ballNumbers.length(); index++) {
            try {
                baseballs.add(new Baseball(ballNumbers.charAt(index) - ASCII_ZERO_CHAR));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
        return new Baseballs(baseballs);
    }

    public static Baseballs createBaseballsByRandomNumber() {
        try {
            List<Baseball> baseballs = new ArrayList<>();
            for (int i = 0; i < BASEBALLS_SIZE; i++) baseballs.add(new Baseball(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
            return new Baseballs(baseballs);
        } catch (IllegalArgumentException e) {
            return createBaseballsByRandomNumber();
        }
    }

}
