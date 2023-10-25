package baseball;

import java.util.Objects;

public class GameRulesForInput{
    public static void validateUserInput(String s) throws IllegalArgumentException{
        try{
            // 모두 0부터 9까지의 숫자로 이루어져있는지
            int number=Integer.parseInt(s);
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
}
