package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int computer = generateRandomNumber();
        int user = 0;

        while(true) {
            try {
                user = getUserInput();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(user);

    }

    private static int generateRandomNumber() {
        int result = 0;

        // 중복 되지 않은 3개의 무작위 수 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        result = listToInt(computer);

        return result;
    }

    /**
     * number = 123
     * return = [1, 2, 3]
     */
    private static List<Integer> parseDigits(int number) {
        List<Integer> result = new ArrayList<>();

        int tmpNumber = number;

        while (tmpNumber > 0) {
            result.add(tmpNumber % 10);
            tmpNumber = tmpNumber / 10;
        }

        Collections.reverse(result);

        return result;
    }

    /**
     * list = [1, 2, 3]
     * return = 123
     */
    private static int listToInt(List<Integer> integers) {
        int result = 0;

        for (int i=0; i<integers.size(); i++) {
            result = result * 10 + integers.get(i);
        }

        return result;
    }

    private static int getUserInput() throws IOException {
        int result = 0;

        System.out.print("숫자를 입력해주세요 : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strInput = reader.readLine();

        // 사용자 입력이 3자리 이상의 입력인 경우 예외 던지기
        if (strInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        // 사용자 입력이 정수가 아닌 경우 예외 던지기
        try {
            result = Integer.parseInt(strInput);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }

        List<Integer> integers = parseDigits(result);
        int first = integers.get(0), second = integers.get(1), third = integers.get(2);

        // 입력 받은 3개의 숫자가 중복 되는 경우 예외 던지기
        if (first == second || first == third || second == third) {
            throw new IllegalArgumentException("중복 되지 않은 3개의 숫자를 입력해주세요.");
        }

        // 1 ~ 9까지의 숫자를 입력하도록 예외 던지기
        for (Integer integer : integers) {
            if (integer == 0) {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
            }
        }

        return result;
    }

}
