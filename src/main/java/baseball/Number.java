package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Number {
    private static final int DIGITS = 3;
    private static final String SELECT_SENTENCE = "숫자를 입력해주세요 : ";
    public List<Integer> setRandomNumbers(){
        Set<Integer> NumberSet = new HashSet<>(); //HashSet: 중복된 값을 허용 하지 않음
        while(NumberSet.size() < DIGITS){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            NumberSet.add(randomNumber);
        }
        return new ArrayList<>(NumberSet);
    }

    public List<Integer> getInputNumber(){
        System.out.print(SELECT_SENTENCE);
        String input = Console.readLine();
        if(!isValidString(input)){
            throw new IllegalArgumentException();
        }
        return stringToList(input);
    }

    private List<Integer> stringToList(String str){
        return Arrays.stream(str.split("")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        //
    }

    private boolean isValidString(String input){
        if(!isNotDuplicate(input) || !isNumber(input) || !isThreeDigits(input)){
            return false;
        }
        return true; //중복된 숫자가 있거나, 숫자만 사용 하지 않거나 3자리 수가 아니 라면 예외 처리를 한다
    }

    private boolean isThreeDigits(String input){
        if(input.length() != DIGITS){
            return false;
        }
        return true;
    }

    private boolean isNumber(String str){
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str); //숫자만 등장 하는가 https://hbase.tistory.com/160 다양한 정규식
    }

    private boolean isNotDuplicate(String str){
        Set<Character> set = new HashSet<>();
        for(char num : str.toCharArray()){
            set.add(num);
        }
        return set.size() == str.length(); //중복된 숫자가 있을 경우 HashSet에 의해 3자리 숫자가 되지 않는다.
    }
}
