package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputNumber {
    public int userInput() {
//        System.out.println();
        System.out.print("숫자를 입력해주세요 :");
        String input_num = Console.readLine();
        try {
            if (!input_num.matches("-?\\d+")) {
                throw new IllegalArgumentException();
            }
            return Integer.valueOf(input_num);
        } catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }
    }

    public int[] createInputArr(){
        int[] inputArr = new int[3];

        int inputNum = userInput();
        int inputStr = Integer.toString(inputNum).length();
        boolean isRight = inputArr.length == inputStr;

        try {
            if(!isRight){
                throw new IllegalArgumentException();
            }
            for(int i = inputStr;i>0;i--){
                int inputValue = inputNum % 10;
                inputArr[i-1] = inputValue;
                inputNum /= 10;
            }
            return inputArr;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

    }

    public int[] checkNum() {
        int[] inputArry = createInputArr();
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
            return inputArry;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
//    public void checkNum(int[] inputArry) {
//        Set<String> numSet = new HashSet<>();
//
//        // 배열의 요소를 Set에 추가
//        for (int num : inputArry) {
//            numSet.add(String.valueOf(num));
//        }
//        boolean isRight = numSet.size() == inputArry.length;
//        try {
//            if(!isRight || inputArry.length != 3){
//                throw new IllegalArgumentException();
//            }
//        } catch (IllegalArgumentException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
