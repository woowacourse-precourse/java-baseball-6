package baseball.domain;

public class Umpire {

    public String rule(Computer computer, Player player) {

        BaseballGameNumbers computerNumbers = computer.getNumbers();
        BaseballGameNumbers playerNumbers = player.getLastPick();

        int strike = computerNumbers.countStrike(playerNumbers);
        int ball = computerNumbers.countBall(playerNumbers);

        //결과 출력
        if (strike == 0 && ball == 0) {
           return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
