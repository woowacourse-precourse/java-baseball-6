package baseball.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidCheckService {

    public boolean isValidNumber(String input){
        if(isNumberNaturalDigit(input) && isValidLength(input) && sameNumberCheck(input)){
            return true;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }
    public boolean isNumberNaturalDigit(String input) {
        for(char c : input.toCharArray()){
            if(!Character.isDigit(c) || c == '0'){
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
        }
        return true;
    }

    public boolean isValidLength(String input){
        if (input.length() != 3) {
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
        return true;
    }

    //set으로 만들었으니 중복이 있으면 input값과 set의 크기가 다르게 된다
    public boolean sameNumberCheck(String input){
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() != input.length()) {
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
        return true;
    }
    public List<Integer> stringToIntegerList(String input) {
        isValidNumber(input);
        List<Integer> integerList = new ArrayList<>();
        for (String s : input.split("")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }


    public static void validExitNumber(String input){
        if(input.equals("1") || input.equals("2")){
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

}
