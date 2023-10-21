package baseball;

import java.util.List;

public class CheckFinal {

    StartCompare startCompare = new StartCompare();

    Strike strike = new Strike();

    /**
     * ball의 갯수를 반환해주는 메서드입니다.
     * */
    public int ball(List<Integer> computer, List<Integer> player){
        int total = startCompare.countDigit(computer, player);
        int strikeCount = strike.checkStrike(computer, player);

        return total - strikeCount;
    }

}
