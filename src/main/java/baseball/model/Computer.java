package baseball.model;

import java.util.List;

public class Computer {
    private BaseballNumberGenerator baseballNumberGenerator;
    private List<Integer> baseballNumber;

    public Computer(BaseballNumberGenerator baseballNumberGenerator){
        this.baseballNumberGenerator = baseballNumberGenerator;
    }

    public void createBaseballNumber(){
        this.baseballNumber = baseballNumberGenerator.createRandomBaseballNumber();
    }

    public Integer countStrike(List<Integer> playerBaseballNumber){
        Integer strike =0;

        for(int i=0;i<playerBaseballNumber.size();i++){
            if(playerBaseballNumber.get(i).equals(this.baseballNumber.get(i))){
                strike++;
            }
        }

        return strike;

    }

    public Integer countBall(List<Integer> playerBaseballNumber){
        int ball =0;

        for(int i=0;i<playerBaseballNumber.size();i++){
            if(playerBaseballNumber.contains(this.baseballNumber.get(i))
            && !playerBaseballNumber.get(i).equals(this.baseballNumber.get(i))
            ){
                ball++;
            }

        }

        return ball;

    }
}
