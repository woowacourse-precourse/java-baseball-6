package baseball.model;

import baseball.constant.Rule;
import java.util.List;

public class Game {

    private int strike;
    private int ball;

    public Game() {
        this.strike = 0;
        this.ball = 0;
    }

    public void comparePlayerToComputer(List<Integer> playerNum , List<Integer> computerNum ){

        for(int i = 0; i< Rule.MAX_LENGTH; i++){
            if(computerNum.get(i).equals(playerNum.get(i))) {
                addStrike();
            }else if(computerNum.contains(playerNum.get(i))){
                addBall();
            }
        }

    }

    private void addStrike() {
        this.strike++;
    }

    private void addBall() {
        this.ball++;
    }

    public boolean isCompleted() {
        return strike == Rule.MAX_LENGTH;
    }

    public void initGame() {
        this.strike = 0;
        this.ball = 0;
    }

    public String createResultMessage() {
        StringBuilder gameResult = new StringBuilder();

        if (strike+ball == 0) {
            return "낫싱";
        }
        if (strike > 0 && ball == 0) {
            return strike + "스트라이크";
        }
        if (ball > 0) {
            gameResult.append(ball + "볼");
        }
        if (ball > 0 && strike > 0) {
            gameResult.append(" "+strike + "스트라이크");
        }

        return gameResult.toString();
    }


}
