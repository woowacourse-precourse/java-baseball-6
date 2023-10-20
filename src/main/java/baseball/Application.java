package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> userGuess;
    public static void main(String[] args) {
        userGuess = getNumbers();
    }

    /**
     * 사용자의 입력을 받고 이를 숫자로 변환해 리스트에 저장하는 메소드
     * @return 3개의 중복되지 않는 정수를 갖는 리스트
     * @throws IllegalArgumentException
     */
    protected static List<Integer> getNumbers() throws IllegalArgumentException {
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("input length should be exactly three.");
        }

        List<Integer> userGuess = new ArrayList<>();
        final byte[] inputToBytes = input.getBytes();
        for (byte b : inputToBytes) {
            if (b > '9' || b < '1') {
                throw new IllegalArgumentException("numbers should be in range 1 to 9.");
            }
            int number = b - '0';
            if (userGuess.contains(number)) {
                throw new IllegalArgumentException("numbers cannot be duplicated.");
            } else {
                userGuess.add(number);
            }
        }
        return userGuess;
    }

}
