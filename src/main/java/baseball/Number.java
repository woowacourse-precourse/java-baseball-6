package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Number {
    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int DIGITS = 3;

    public List<Integer> setAnswerNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getInputNumbers(){
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if(!checkInput(input)){
            throw new IllegalArgumentException();
        }
        return stringToList(input);
    }

    private List<Integer> stringToList(String str){
        int[] intArr = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(intArr).boxed().collect(Collectors.toList());
    }

    private boolean checkInput(String str){
        return isThreeDigits(str) && isNotDuplicate(str) && isNumeric(str);
    }

    private boolean isThreeDigits(String str){
        return str.length() == DIGITS;
    }

    private boolean isNotDuplicate(String str){
        Set<Character> set = new HashSet<>();
        for(char c : str.toCharArray()) {
            set.add(c);
        }
        return str.length() == set.size();
    }

    private boolean isNumeric(String str){
        String pattern = "^[0-9]*$";

        return Pattern.matches(pattern, str);
    }

}
