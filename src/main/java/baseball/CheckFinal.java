package baseball;

import java.util.List;

public class CheckFinal {

    StartCompare startCompare = new StartCompare();

    Strike strike = new Strike();

    /**
     * ball의 갯수를 반환해주는 메서드 입니다.
     * */
    public int ball(List<Integer> computer, List<Integer> player){

        int total = startCompare.countDigit(computer, player);
        int strikeCount = strike.checkStrike(computer, player);

        return total - strikeCount;
    }

    /**
     * total, strike, ball의 갯수를 다 확인한 메서드 입니다.
     * 낫싱, 볼, 스트라이크의 유무를 알려주는 확인 메서드 입니다.
     * */
    public String checkAll(List<Integer> computer, List<Integer> player){

        int total = startCompare.countDigit(computer, player);
        int stikeCount = strike.checkStrike(computer, player);
        int ball = ball(computer, player);

        if (stikeCount == 3){
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (total == 0){
            return "낫싱";
        } else if (stikeCount == 0){
            return ball + "볼";
        } else if (ball == 0){
            return stikeCount + "스트라이크";
        }

        return ball + "볼" + " " + stikeCount + "스트라이크";
    }
}
