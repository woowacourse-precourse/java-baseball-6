package baseball;

import java.util.List;

public class Compare {
    public String compareNumber(List<Integer> computer, List<Integer> userNumber) {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<computer.size(); i++) {
            for (int j=0; j<userNumber.size(); j++) {
                if (computer.get(i) == userNumber.get(j)) {
                    if(i==j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        if (strike == 0 && ball ==0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball+"볼";
        } else if (ball == 0) {
            return strike+"스트라이크";
        }
        return ball+"볼 "+strike+"스트라이크";
    }

