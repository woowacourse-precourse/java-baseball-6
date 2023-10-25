package baseball;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
public class GameRulesForInput{
    private static void validateUserInput(String s) throws IllegalArgumentException{
        try{
            // 3자리의 숫자인지
            if(s.length()!=3){
                throw new IllegalArgumentException();
            }
            // 3자리 모두 다른 숫자인지
            for(int i=0;i<3;i++){
                for(int j=i+1;j<3;j++){
                    if(Objects.equals(s.charAt(i),s.charAt(j))){
                        throw new IllegalArgumentException();
                    }
                }
            }

        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> parseUserInput(String userInput){
        List<Integer> userNumbers= new ArrayList<>();

        // 입력값에 대한 예외 처리 필요
        try {
            GameRulesForInput.validateUserInput(userInput);
            for (char c : userInput.toCharArray()) {
                //만약 숫자가 아니라면 예외 처리됨.
                int number=Character.getNumericValue(c);
                if(number<1 || 9<number){
                    throw new IllegalArgumentException();
                }
                userNumbers.add(number);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        return userNumbers;
    }
}
