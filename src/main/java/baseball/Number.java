package baseball;

import java.util.ArrayList;
import java.util.List;

public class Number {

    protected static final int COUNT = 3;
    protected static final int START = 1;
    protected static final int END = 9;
    protected List<Integer> nums;

    public Number() {}

    public Number(String str) {
        validateInput(str);
        this.nums = inputNums(str);
    }

    private List<Integer> inputNums(String input) {
        List<Integer> nums = new ArrayList<>();

        String[] strArr = input.split("");
        for(String str: strArr) {
            nums.add(Integer.parseInt(str));
        }

        return nums;
    }

    private void validateInput(String input) {
        validateLength(input);

        String[] inputArr = input.split("");

        for(String numStr:inputArr) {
            validateType(numStr);
            validateRange(numStr);
            validateUnique(numStr, inputArr);
        }
    }

    private void validateLength(String input) {
        if(input.length() != COUNT) {
            throw new IllegalArgumentException(COUNT+"개의 수만 입력하세요.");
        }
    }

    private void validateType(String numStr) {
        try {
            Integer.parseInt(numStr);

        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
    }

    private void validateRange(String numStr) {
        int parsedValue = Integer.parseInt(numStr);

        if (parsedValue < START || parsedValue > END) {
            throw new IllegalArgumentException(START+"-"+END+" 사이 정수만 입력하세요.");
        }
    }

    private void validateUnique(String numStr, String[] inputArr) {
        int duplicateCount = 0;

        for(String test: inputArr) {
            if(test.equals(numStr)) {
                duplicateCount++;
            }

            if(duplicateCount > 1) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력하세요");
            }
        }
    }

    public boolean hasValueAtSameIndex(int index, int value) {
        int savedIndex = this.nums.indexOf(value);
        return savedIndex == index;
    }

    public boolean hasValue(int value) {
        return this.nums.contains(value);
    }

    protected int getNum(int index) {
        return this.nums.get(index);
    }

    protected int getSize() {
        return this.nums.size();
    }

}
