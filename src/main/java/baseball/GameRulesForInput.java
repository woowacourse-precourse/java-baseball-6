package baseball;

import java.util.*;

public class GameRulesForInput{

    public static List<Integer> validateAndParseUserInput(String userInput) throws IllegalArgumentException{
        List<Integer> user= new ArrayList<>();

        // 3자리인지
        if(userInput.length()!=3){
            throw new IllegalArgumentException();
        }

        for(char c: userInput.toCharArray()){
            // 모두 0부터 9까지의 숫자로 이루어져있는지
            int number=Character.getNumericValue(c);
            if(number<1 || 9<number){
                throw new IllegalArgumentException();
            }
            // 3자리 모두 다른 숫자인지
            if(user.contains(number)){
                throw new IllegalArgumentException();
            }
            user.add(number);
        }

        return user;
    }
}
