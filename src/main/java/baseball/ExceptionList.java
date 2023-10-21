package baseball;

import java.util.List;

public class ExceptionList {
    public static void validNumbers(List<Integer> numbers) {
        if(numbers.size() != 3) {
            throw new IllegalArgumentException("numbers사이즈 예외 발생");
        }
        if(checkDuplicateNumber(numbers, 0, 0)) {
            throw new IllegalArgumentException("중복수 예외 발생");
        }
    }

    public static void validReStartInputNumber(Integer InputNumber) {
        if(InputNumber != 1 && InputNumber != 2) {
            throw new IllegalArgumentException("종료시 입력한 수 예외 발생");
        }
    }

    public static boolean checkDuplicateNumber(
            List<Integer> numbers,
            int numbersIdx,
            int checkNumberIdx
    ) {
        while(numbersIdx != numbers.size()) {
            int searchNumber = numbers.get(numbersIdx);
            int checkNumber = numbers.get(checkNumberIdx);

            if(numbersIdx == checkNumberIdx) {
                numbersIdx++;
            }
            if(checkNumberIdx == numbers.size()-1) {
                checkNumberIdx = 0;
                numbersIdx++;
            }
            if(searchNumber == checkNumber) return true;
            else checkNumberIdx++;
        }
        return false;
    }

}
