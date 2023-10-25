package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Utils {

    public static List<Integer> getNumberFromUser() throws IllegalArgumentException{
        List<Integer> number = new ArrayList<>();
        char[] inputValue = Console.readLine().toCharArray();
        for(char value : inputValue){
            number.add(Character.getNumericValue(value));
        }
        isValidNumber(number);
        return number;
    }

    public static boolean isValidNumber(List<Integer> number){

        // check input num.size over 3
        if(number.size()>3){
            throw new IllegalArgumentException();
        }

        //in range(102, 1000)
        if(number.get(0) == 0){
            throw new IllegalArgumentException();
        }

        //duplicate num error
        Set<Integer> dupNumCheck = Set.copyOf(number);
        if (dupNumCheck.size() != number.size()){
            throw new IllegalArgumentException();
        }

        return true;
    }


}
