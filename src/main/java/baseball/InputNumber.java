package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputNumber {
    public int userInput(){
        System.out.println("숫자를 입력해주세요 :");
        return Integer.valueOf(Console.readLine());
    }

    public int[] createInputArr(){
        int[] inputArr = new int[3];
        int inputNum = userInput();

        for(int i = inputArr.length;i>0;i--){
            int inputValue = inputNum % 10;
            inputArr[i-1] = inputValue;
            inputNum /= 10;
        }
        return inputArr;
    }

    public void checkNum(int[] inputArry) {
        Set<String> numSet = new HashSet<>();

        // 배열의 요소를 Set에 추가
        for (int num : inputArry) {
            numSet.add(String.valueOf(num));
        }
        boolean isRight = numSet.size() == inputArry.length;
        try {
            if(!isRight){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

}
