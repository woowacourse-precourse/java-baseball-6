package baseball;

import java.util.List;

public class BallCountAlg {
    MyException myException = new MyException();
    public int[] countAlg(String input, List<Integer> answer){ //볼, 스트라이크 count Alg.

        char [] myAnswer = input.toCharArray();
        myException.ballException(myAnswer);

        int strike=0;
        int ball=0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(answer.get(i) == myAnswer[j]-'0'){
                    if(i==j){
                        strike++;
                    }else{
                        ball++;
                    }
                }
            }
        }
        return new int[]{ball, strike};
    }

    public int isCorrect(int[] ballCount){  //볼, 스트라이크 유무 체크
        if(ballCount[0]!=0){
            if(ballCount[1]!=0){ //볼과 스트라이크
                return 3;
            }else {//볼만 있음
                return 1;
            }
        }else if (ballCount[1]==3){//3스트라이크
            return 4;
        }else if(ballCount[1]!=0) {//스트라이크만 있음 (3스트라이크 제외)
            return 2;
        }else{                     //아무것도 없음
            return 5;
        }
    }
}
