package baseball;

import java.util.Arrays;



public class Application {
    // TODO: 프로그램 구현
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        InputNumber inputNumber = new InputNumber();
        ReturnCount returnCount = new ReturnCount();
        Replay replay = new Replay();
        boolean retry = true;


        while(retry){
            int[] ranNum = randomNumber.createRanArr();
            String counts = "";
            while (!counts.equals("3스트라이크")){
                counts = returnCount.count(inputNumber.checkNum(),ranNum);
                System.out.println(counts);
            }
            retry = replay.replay();
        }
    }
}
