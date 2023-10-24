package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.regex.Pattern;

public class SetNumber {
    private static final int DIGIT = 3;
    public List<Integer> setRandomNumbers(){
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < DIGIT){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numberSet.add(randomNumber);
        }
        return new ArrayList<>(numberSet);
    }

    public List<Integer> setUserNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        if(!isValidNumber(inputNumber)){
            throw new IllegalArgumentException();
        }
        return stringTolist(inputNumber);
    }



    private boolean isValidNumber(String inputNumber){
        if(!isNotDuplicate(inputNumber) || !isNumber(inputNumber)){
            return false;
        }
        return true;
    }

    private boolean isThreeDigits(String inputNumber){
        if(inputNumber.length() != DIGIT){
            return false;
        }
        return true;
    }

    private boolean isNumber(String str){
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }

    private boolean isNotDuplicate(String str){
        Set<Character> set = new HashSet<>();
        for(char num : str.toCharArray()){
            set.add(num);
        }
        return set.size() == str.length();
    }

}