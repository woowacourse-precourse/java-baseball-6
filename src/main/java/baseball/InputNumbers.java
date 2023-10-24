package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputNumbers {
    private static final int INPUT_NUMBERS_SIZE = 3;

    private List<Integer> inputNumbers;

    public InputNumbers(String inputNumbers) {
        validateSize(inputNumbers);
        validateIsDigit(inputNumbers);
        List<Integer> list = new ArrayList<>();
        for (String num : inputNumbers.split("")) {
            validateRange(num);
            int temp = Integer.parseInt(num);
            list.add(temp);
        }
        validateDuplicate(list);
        this.inputNumbers = list;
    }

    public void validateSize(String numbers) {
        // 사이즈예외처리 + null 처리
        if (numbers.length() != INPUT_NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자 3개만 입력 가능합니다.");
        }
    }

    public void validateIsDigit(String numbers) {
        //숫자외 입력 예외처리
        if (!isDigit(numbers)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

    }

    public void validateDuplicate(List<Integer> inputNumbers) {
        //중복예외처리
        Set<Integer> numSet = new HashSet<>(inputNumbers);
        if (numSet.size() != INPUT_NUMBERS_SIZE) {
            throw new IllegalArgumentException("서로다른 숫자만 입력 가능합니다.");
        }
    }

    public void validateRange(String num) {
        //0예외처리
        if (Integer.parseInt(num) < 1) {
            throw new IllegalArgumentException("1이상 9이하의 숫자만 입력 가능합니다.");
        }
    }

    public boolean isDigit(String numbers) {
        try {
            Integer.parseInt(numbers);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int compareBallCount(Integer computerNum){
        if(inputNumbers.contains(computerNum)){
            return 1;
        }
        return 0;
    }

    public int compareStrikeCount(List<Integer> computer,int i){
        Integer inputNum = inputNumbers.get(i);
        Integer computerNum = computer.get(i);
        if(inputNum.equals(computerNum)){
            return 1;
        }
        return 0;
    }
}
