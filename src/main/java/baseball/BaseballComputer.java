package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballComputer {
    private int[] numArray;

    public BaseballComputer() {
        this.numArray = new int[10];
    }

    public void selectNumber() {
        Arrays.fill(numArray, 0);
        for (int i = 1; i <= 3; ++i) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (numArray[randomNumber] != 0);
            numArray[randomNumber] = i;
        }
    }

    public boolean chkInputError(String input) {
        int[] duplicatedCheck = new int[10];

        if (input.length() != 3) {
            return true;
        }
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return true;
            }
            int intDigit = Character.getNumericValue(c);
            if (duplicatedCheck[intDigit] != 0) {
                return true;
            }
            duplicatedCheck[intDigit] = 1;
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
        for (int i = 0; i < 3; ++i) {
            int tmpInt = Character.getNumericValue(input.charAt(i));
            if (numArray[tmpInt] == 0) {
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
        if (strikesBallsNum[0] == 0 && strikesBallsNum[1] == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (strikesBallsNum[1] != 0) {
            System.out.print(strikesBallsNum[1] + "볼 ");
        }
        if (strikesBallsNum[0] != 0) {
            System.out.print(strikesBallsNum[0] + "스트라이크");
        }
        System.out.println();
        // 정답이면 true를 반환
        if (strikesBallsNum[0] == 3) {
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
