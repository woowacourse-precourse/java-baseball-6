package baseball.Model;

import java.util.List;

public class GameResult {

    private int ball = 0;
    private int strike = 0;

    GameResult(List<Integer> answerNumbers, List<Integer> UserNumbers ){
        for(int i=0; i<answerNumbers.size(); i++){
            int computer = answerNumbers.get(i);
            int user = UserNumbers.get(i);

            if(computer == user){
                this.strike++;
            }
            else if(answerNumbers.contains(user)){
                this.ball++;
            }
        }
    }

    public String resultToString() {
        String result = "";
        if (this.ball != 0) {
            result += this.ball + "볼";
        }
        if (this.strike != 0) {
            if (this.ball != 0) {
                result += " ";
            }
            result += this.strike + "스트라이크";
        }
        if (this.ball == 0 && this.strike == 0) {
            result = "낫싱";
        }
        return result;
    }

    public int getStrikes() {
        return this.strike;
    }
}
