package baseball.validator;

import java.util.Arrays;

public class NumberCheck {
    public static void NonNumber(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public static void DigitNumber(String input){
        if (input.length() != 3){
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
    }

    public static void DuplicateNumber(String input){
        String[] TestNumbers = input.split("");
        if (TestNumbers.length != Arrays.stream(TestNumbers).distinct().count()){
            throw new IllegalArgumentException("중복된 숫자는 입력하면 안 됩니다.");
        }
    }

    public static void RangeOut(String input){
        String[] Testnumbers = input.split("");
        for (String Testnumber:Testnumbers){
            if (Integer.parseInt(Testnumber)==0){
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
            }
        }
    }
}
