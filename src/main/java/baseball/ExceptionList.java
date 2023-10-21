package baseball;

import java.util.List;

public class ExceptionList {
    public static void validNumbers(List<Integer> numbers) {
        if(numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
        if(checkDuplicateNumber(numbers, 0, 0)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validReStartInputNumber(String InputNumber) {
        if(!InputNumber.equals("1") && !InputNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
//        if(InputNumber == null) {
//            throw new IllegalArgumentException("어떤 수도 입력하지 않음");
//        }
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
                continue;
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
