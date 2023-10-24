package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private List<Integer> nums;

    public List<Integer> parseNumbers(String inputNums){
        validateInputNums(inputNums);
        nums = new ArrayList<>();
        for(char c : inputNums.toCharArray()){
            nums.add(c - '0');
        }
        return nums;
    }

    public void validateInputNums(String inputNums){
        if(!checkNumsLength(inputNums)){
            throw new IllegalArgumentException();
        }

        if(!checkDuplicateNumbers(inputNums)){
            throw new IllegalArgumentException();
        }
    }

    public boolean checkNumsLength(String inputNums){
        if(inputNums.length() != 3){
            throw new IllegalArgumentException("3개의 숫자만 입력 가능합니다.");
        }
        return true;
    }


    public boolean checkDuplicateNumbers(String inputNums) {
        Set<Integer> set = new HashSet<>();
        for(char c : inputNums.toCharArray()){
            int digit = c - '0';
            set.add(mapToValidSingleDigit(digit));
        }

        if(set.size() != 3){
            throw new IllegalArgumentException("중복된 숫자는 입력이 불가능합니다.");
        }

        return true;
    }

    public boolean isValidSingleDigit(int digit){
        return (1 <= digit && digit <= 9);
    }

    public int mapToValidSingleDigit(int digit){
        if(!isValidSingleDigit(digit)){
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return digit;
    }
}
