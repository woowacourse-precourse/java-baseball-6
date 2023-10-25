package baseball.vailidation;

import java.util.List;

public class NumberValidator {

    //입력값 길이 검사
    public static void checkLength(List<String> input){

        if (input.size() > 3) {
            throw new IllegalArgumentException("입력된 숫자가 세자리 이상이다.");
        }
    }

    //재시작 입력값 유효성 검사.
    public static boolean checkRestartFormat(String input){

        if(input.equals("1")){
            return true;
        }
        else if(input.equals("2")){
            return false;
        }

        throw new IllegalArgumentException("재시작 입력값 오류.(입력값 포멧 : 1 또는 2)");

    }

    //입력값에 0이 포함되는지 검사.
    public static void checkZero(List<String> input){

        if (input.contains("0")) {
            throw new IllegalArgumentException("입력에 0이 포함되어있다.(입력값 포멧 : 1~9까지 서로 다른 수로 이루어진 세자리 수)");
        }
    }

    //입력값 중복성 검사
    public static void checkRedundancy(List<String> input) {
        List<String> distinctList = input.stream().distinct().toList();

        if(input.size() > distinctList.size()) {
            throw new IllegalArgumentException("중복 입력된 숫자가 있다.");
        }
    }

    //입력값 유효성 검사
    public static int parseAndVaiidateInput(String s){

        try{
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 숫자가 int형이 아니다.");

        }
    }
}
