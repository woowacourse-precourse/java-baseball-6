package baseball.validator;

import java.util.Arrays;

public class NumberCheck {

    private final static String notNumberErrorMessage = "숫자만 입력해주세요.";
    private final static String lengthOutErrorMessage = "3자리의 숫자를 입력해주세요.";
    private final static String duplicateErrorMessage = "중복된 숫자는 입력하면 안 됩니다.";
    private final static String rangeOutErrorMessage = "1~9 사이의 숫자를 입력해주세요.";
    private final static String reStartErrorMessage = "1 혹은 2를 입력해주세요.";

    public static void nonNumber(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(notNumberErrorMessage);
        }
    }

    public static void digitNumber(String input){
        if (input.length() != 3){
            throw new IllegalArgumentException(lengthOutErrorMessage);
        }
    }

    public static void duplicateNumber(String input){
        String[] TestNumbers = input.split("");
        if (TestNumbers.length != Arrays.stream(TestNumbers).distinct().count()){
            throw new IllegalArgumentException(duplicateErrorMessage);
        }
    }

    public static void rangeOut(String input){
        String[] Testnumbers = input.split("");
        for (String Testnumber:Testnumbers){
            if (Integer.parseInt(Testnumber)==0){
                throw new IllegalArgumentException(rangeOutErrorMessage);
            }
        }
    }

    public static void reStartOrOverCheck(String input){
        if(!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException(reStartErrorMessage);
        }
    }
}