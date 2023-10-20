package baseball;

import static baseball.Constants.validLength;

import java.util.HashSet;
import java.util.Set;

public class GameRule {
    public static int countBallAndStrike(String computeNumber, String userNumber){

        char[] computeNumberArray = computeNumber.toCharArray();
        char[] userNumberArray = userNumber.toCharArray();

        Set<Character> computeNumberHS = new HashSet<>();
        Set<Character> userNumberHS = new HashSet<>();

        for (char c : computeNumberArray) {
            computeNumberHS.add(c);
        }
        for (char u : userNumberArray) {
            userNumberHS.add(u);
        }

        // 교집합 생성
        computeNumberHS.retainAll(userNumberHS);
        return computeNumberHS.size();
    }

    public  static  int countStrike(String computeNumber, String userNumber){
        int cntS = 0;
        for(int i=0; i < validLength; i++){
            if(computeNumber.charAt(i) == userNumber.charAt(i)){
                cntS++;
            }
        }
        return cntS;
    }

    public static String hintProvider(int cntB, int cntS){
        if(cntB == 0 && cntS == 0){
            return "낫싱";
        }
        if(cntB == 0){
            return "%d스트라이크".formatted(cntS);
        }
        if(cntS == 0){
            return  "%d볼".formatted(cntB);
        }
        return "%d볼 %d스트라이크".formatted(cntB, cntS);
    }
}
