package baseball;

import java.util.HashSet;
import java.util.Set;

public class NumberBaseball {

    public static String baseballGame(String input, String answer){
        int strike = 0;
        int ball = 0;

        Set<Character> answerSet = createanswerSet(answer);

        for (int i = 0; i < 3; i++){
            if (input.charAt(i) == answer.charAt(i)){
                strike++;
            }
            else if (answerSet.contains(input.charAt(i))){
                ball++;
            }
        }

        if (ball == 0 && strike != 0){
            return (strike + "스트라이크");
        }
        else if (strike == 0 && ball != 0){
            return (ball + "볼");
        }
        else if (ball == 0 && strike == 0){
            return "낫싱";
        }
        else if (ball > 0 && strike > 0){
            return (ball + "볼 " + strike + "스트라이크");
        }
        return "";
    }

    private static Set<Character> createanswerSet(String answer){
        Set<Character> answerSet = new HashSet<>();
        for (char x : answer.toCharArray()){
            answerSet.add(x);
        }
        return answerSet;
    }



}
