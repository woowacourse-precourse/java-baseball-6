package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class PlayerInputException {
    private static final String NUMBER_REGEX = "[1-9]+";
    private static final int NUMBER_SIZE = 3;

    /*
    원래는 중복 여부를 먼저 검증하려 헀으나,
    우선순위로 인해 1234를 중복으로 감지하는 문제로 인해 순서를 변경
    */
    public void checkValidOfPlayerInput(String numberCasesOfString) {
        notThreeDigitNumberCase(numberCasesOfString); //숫자의 입력 길이 체크
        notConsistSolelyOfNumberCase(numberCasesOfString); //숫자의 범위(1~9) 초과 여부 체크
        duplicationNumberCase(numberCasesOfString); //숫자의 중복 여부 체크

    }


    public void notThreeDigitNumberCase(String numberCasesOfString) { // 숫자의 입력 길이
        if (numberCasesOfString.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("수는 3개까지만 입력이 가능합니다.");
        }
    }


    public void notConsistSolelyOfNumberCase(String numberCasesOfString) { //숫자의 범위(1~9) 초과 여부 체크
        for (int i = 0; i < numberCasesOfString.length(); i++) {
            if (!numberCasesOfString.matches(NUMBER_REGEX)) {
                throw new IllegalArgumentException("1~9 범위 내의 '숫자'만 입력해야 합니다.");
            }
        }
    }

    public void duplicationNumberCase(String numberCasesOfString) { //숫자의 중복 여부 체크
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < numberCasesOfString.length(); i++) {
            numSet.add(numberCasesOfString.charAt(i) - '0');
        }
        if (numSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("중복되지 않는 수를 입력해야 합니다.");
        }
    }
}
