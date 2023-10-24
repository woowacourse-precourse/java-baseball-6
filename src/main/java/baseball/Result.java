package baseball;

import java.util.List;

public class Result {
    public int getGameResultJudgment(List<Integer> computer, List<Integer> mine){
        // 스트라이크 개수 세기
        int strike = 0;
        int flag = 1;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(mine.get(i))){
                strike ++;
            }
        }
        // 볼 개수 세기
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && computer.get(i).equals(mine.get(j))){
                    ball ++;
                }
            }
        }

        getResult(strike, ball);
        if (strike == 3) flag = 2;
        return flag;
    }

    public void getResult(int strike, int ball){
        if (ball == 0 && strike == 0) System.out.println("낫싱");
        else if (ball > 0 && strike == 0){
            System.out.printf("%d볼", ball);
            System.out.println();
        }
        else if(ball == 0 && strike > 0){
            System.out.printf("%d스트라이크", strike);
            System.out.println();
        }
        else{
            System.out.printf("%d볼 %d스트라이크", ball, strike);
            System.out.println();
        }
    }
}
