package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Player {
    private static final String EXCEPTION_MESSAGE = "1-9까지 자연수만 입력해 주세요.";
    private static final Pattern INPUT_REGEX = Pattern.compile("[1-9]{3,3}");
    private ArrayList<Integer> numberList = new ArrayList<Integer>();
    public void setUserNumber(){
        String input = getNumber();
        validateCheck(input);
        this.numberList = this.setNumberList(input);
    }

    private ArrayList<Integer> setNumberList(String userNumber){
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        for(int i = 0 ; i < userNumber.length(); i++){
            numberList.add(Integer.parseInt(String.valueOf(userNumber.charAt(i))));
        }
        return numberList;
    }

    public void validateCheck(String number){
        validateLength(number);
        validateRegex(number);
    }

    private static String getNumber(){
        return Console.readLine();
    }
    private void validateLength(String input){
        Exceptions.noneLengthException(input);
    }
    private void validateRegex(String input){
        if(!INPUT_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public ArrayList<Integer> getNumberList() {
        return numberList;
    }

}
