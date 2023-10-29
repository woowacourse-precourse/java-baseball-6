package baseball.domain;

import java.util.List;

public class Referee {

    public String compare(List<Integer> computer, List<Integer> player) {
        // countMatchingDigits()로 몇 개의 같은 숫자가 있는지 알아낸다
        final Judgement judgement = new Judgement();
        int matchCount = judgement.countMatchingDigits(computer, player);

        // 스트라이크 개수 구한다
        int strike=0;
        for (int i=0; i<player.size(); i++) {
            if (judgement.isNumberAtIndex(computer, i, player.get(i))) {
                strike++;
            }
        }
        int ball = matchCount-strike;

        if (matchCount==0) {
            return("낫싱");
        } else if (ball==0) {
            return(strike+"스트라이크");
        } else if (strike==0) {
            return(ball+"볼");
        } else {
            return(ball+"볼 "+strike+"스트라이크");
        }
    }
}
