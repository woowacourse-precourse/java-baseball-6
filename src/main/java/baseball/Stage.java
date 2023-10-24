package baseball;

import java.util.stream.IntStream;

public class Try extends Game{
    public int getStrike(int[] user_try) {
        int strike = 0;

        for (int i = 0; i<3;i++) {
            if (user_try[i] == this.answer[i]) {
                strike += 1;
            }
        }
        return strike;
    }

    public int getBall(int[] user_try,int strike) {
        int ball = 0;

        for (int i = 0; i<3;i++){
            int target = this.answer[i];
            if(IntStream.of(this.answer).anyMatch(x -> x == target)){
                ball += 1;
            }
        }
        return ball - strike;
    }

    public String getResult(int strike,int ball){
        if (strike == 3){
            return "3스트라이크";
        }
        if (strike == 2 & ball == 0){
            return "2스트라이크";
        }
        if (strike == 1 & ball == 2){
            return "1스트라이크 2볼";
        }
        if (strike == 1 & ball == 1){
            return "1스트라이크 1볼";
        }
        if (strike == 1 & ball == 0){
            return "1스트라이크";
        }
        if (strike == 0 & ball == 3){
            return "3볼";
        }
        if (strike == 0 & ball == 2){
            return "2볼";
        }
        if (strike == 0 & ball == 1){
            return "1볼";
        }
        if (strike == 0 & ball == 0) {
            return "낫싱";
        }
        //수정필요
        return "에러";
    }



}
