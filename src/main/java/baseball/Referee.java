package baseball;

import java.util.List;

public class Referee {
    private int ball;
    public int strike;

    public void count(List<Integer> computerNumList, List<Integer> playerNumList) {
        for (int i = 0; i < computerNumList.size(); i++) {
            if (computerNumList.get(i) == playerNumList.get(i)) {
                strike++;
            }
            if ((computerNumList.get(i) != playerNumList.get(i)) && computerNumList.contains(playerNumList.get(i))) {
                ball++;
            }
        }
        System.out.println(toMessage());
    }

    private String toMessage() {
        if (ball != 0 && strike == 0) {
            return ball + "볼";
        }
        if (ball == 0 && strike != 0) {
            return strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

}
