package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private String computerNumber;
    private String userNumber;
    private int strikes;
    private int balls;

    public Game(){
        this.strikes = 0;
        this.balls = 0;
    }

    public void computerNumberGeneration(){
        List<Integer> computer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                sb.append(randomNumber);
            }
        }
        this.computerNumber = sb.toString();
    }

    public void calculateResult(){
        for(int i = 0; i < computerNumber.length(); ++i){
            if(userNumber.charAt(i) == computerNumber.charAt(i)){
                this.strikes++;
            }
            else if(computerNumber.contains(String.valueOf(userNumber.charAt(i)))) {
                this.balls++;
            }
        }
    }

    public void setUserNumber(String userNumber){
        this.userNumber = userNumber;
    }

    public void setStrikes(){
        this.strikes = 0;
    }

    public void setBalls(){
        this.balls = 0;
    }

    public int getStrikes(){
        return this.strikes;
    }

    public int getBalls(){
        return this.balls;
    }
}
