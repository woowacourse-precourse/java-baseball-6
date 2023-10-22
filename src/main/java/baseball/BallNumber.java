package baseball;

import java.util.Random;

public class BallNumber {
    private int ballNumber;
    private int num;
    public  int[]
    public BallNumber(int number){
        this.ballNumber = number;
    }

    public int makeNumber(){
        Random random = new Random();
        this.num = random.nextInt(9);
    }
}
