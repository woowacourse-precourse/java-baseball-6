package baseball;

import java.util.List;

public class ExceptionList {
    public static void validNumbers(List<Integer> numbers) {
        if(numbers.size() != 3) {
            throw new IllegalArgumentException("numbers사이즈 예외 발생");
        }
        if(checkDuplicateNumber(numbers)) {

        }
    }

    public static boolean checkDuplicateNumber(List<Integer> numbers) {
        int numbersIdx = 0;
        int checkNumberIdx = 0;

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
