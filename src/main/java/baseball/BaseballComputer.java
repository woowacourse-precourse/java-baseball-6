package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballComputer {
    private int[] numArray;

    private final int COUNT_MAX = 3;
    private final int COUNT_MIN = 1;
    private final int COUNT_ZERO = 0;
    private final int DIGIT_NUM = 10;

    public BaseballComputer() {
        this.numArray = new int[DIGIT_NUM];
    }

    public void selectNumber() {
        Arrays.fill(numArray, 0);
        for (int i = COUNT_MIN; i <= COUNT_MAX; ++i) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (numArray[randomNumber] != COUNT_ZERO); // 나오지 않은 숫자가 나올 때까지 반복
            numArray[randomNumber] = i; // 현재 순서를 저장(입력값과 비교 위해서)
        }
    }

    public boolean chkInputError(String input) {
        // 현재 숫자를 인덱스 넘버로 true로 저장하는 배열
        boolean[] duplicatedCheck = new boolean[DIGIT_NUM];

        if (input.length() != COUNT_MAX) {
            return true;
        }
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return true;
            }
            int intDigit = Character.getNumericValue(c);
            if (duplicatedCheck[intDigit]) {
                return true;
            }
            duplicatedCheck[intDigit] = true;
        }
        return false;
    }

    public void takeInputAndPrint() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (chkInputError(input)) {
                throw new IllegalArgumentException();
            }
            // 3스트라이크면 종료
            if (printResult(input)) {
                break;
            }
        }
    }

    private void cntStrikesBalls(String input, int[] result) {
        for (int i = 0; i < COUNT_MAX; ++i) {
            int tmpInt = Character.getNumericValue(input.charAt(i));
            // numArray[tmpInt]: 컴퓨터 숫자에서 tmpInt의 순서
            if (numArray[tmpInt] == COUNT_ZERO) {
                continue;
            }
            if (numArray[tmpInt] == i + 1) {
                result[0]++;
            } else {
                result[1]++;
            }
        }
    }

    private boolean printResult(String input) {
        // int[0] : 스트라이크 갯수, int[1]: 볼 갯수
        int[] strikesBallsNum = new int[2];
        cntStrikesBalls(input, strikesBallsNum);
        if (strikesBallsNum[0] == COUNT_ZERO && strikesBallsNum[1] == COUNT_ZERO) {
            System.out.println("낫싱");
            return false;
        }
        if (strikesBallsNum[1] != COUNT_ZERO) {
            System.out.print(strikesBallsNum[1] + "볼 ");
        }
        if (strikesBallsNum[0] != COUNT_ZERO) {
            System.out.print(strikesBallsNum[0] + "스트라이크");
        }
        System.out.println();
        // 정답이면 true를 반환
        if (strikesBallsNum[0] == COUNT_MAX) {
            return true;
        }
        return false;
    }

    public boolean enterFinished() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return false;
        } else if (input.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
