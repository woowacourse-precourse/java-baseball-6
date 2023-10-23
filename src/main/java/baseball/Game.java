package baseball;

import java.util.Arrays;

public class Game {
    int[] comArr, userArr;
    private int strikes = 0, balls = 0;

    boolean endFlag=false; //3스트라이트시 재시작 여부 묻기 //여기 없어도 될듯?
    private boolean syncronize(int[] comArr,int[] userArr){ //낫싱?
        for (int userElem : userArr) {
            if (Arrays.stream(comArr).anyMatch(x -> x == userElem)) {
                return true;
            }
        }
        return false;
    }
    private void placeMatch(int[] comArr,int[] userArr){  //볼?스트라이크?


        for (int i = 0; i < comArr.length; i++) {
            for (int j = 0; j < userArr.length; j++) {
                if (comArr[i] == userArr[j]) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                }
            }
        }

        if (balls > 0 && strikes > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }

        else if (balls > 0 ) {
            System.out.println(balls + "볼");
        }
        else if ( strikes > 0){
            System.out.println(strikes + "스트라이크");
            if (strikes == 3) {
                //endFlag = true; // 만약 strikes 값이 3이면 endFlag를 true로 설정
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        else if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }
    }
    public int getStrikes() {
        return strikes;
    }

    //게임 결과
    public void play(int[] comArr,int[] userArr){
        placeMatch(comArr,userArr);
    }


}
