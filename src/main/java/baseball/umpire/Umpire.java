package baseball.umpire;

import java.util.List;

public class Umpire {
    public static List<Integer> judge(List<Integer> computerNumbers, List<Integer> userNumbers){
        int strike = 0;
        int ball = 0;
        for(int i=0; i < 3; i++){
            Integer userNumber = userNumbers.get(i);
            if(isStrike(computerNumbers, userNumber, i)){
                strike += 1;
            }
            if(isBall(computerNumbers, userNumber, i)){
                ball += 1;
            }
        }
        return List.of(strike, ball);
    }
    private static boolean isStrike(List<Integer> computerNumbers, Integer userNumber, int index){
        return computerNumbers.contains(userNumber) && (index == computerNumbers.indexOf(userNumber));
    }
    private static boolean isBall(List<Integer> computerNumbers, Integer userNumber, int index){
        return computerNumbers.contains(userNumber) && (index != computerNumbers.indexOf(userNumber));
    }
}
