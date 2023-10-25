package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.sql.Connection;

public class CheckController {

    public int countStrike(String inputNum, String randomNum) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (inputNum.charAt(i) == randomNum.charAt(i)) {
                strike ++;
            }
        }
        return strike;
    }


    public int countBall(String inputNum, String randomNum){
        int ball = 0;

        for (int j=0; j < 3; j++) {
            if(randomNum.contains(String.valueOf(inputNum.charAt(j))) &&
            inputNum.charAt(j)!=randomNum.charAt(j)){
                ball ++;
            }
        }
        return ball;
    }

    public void reportResult(int strike, int ball){
        if (strike > 0 && ball > 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }  else if (ball>0) {
            System.out.println(ball +"볼");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike>0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    public boolean gameRestart(int check) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartChoice = Integer.parseInt(Console.readLine());

        if (check == 2) {
            return false;
        } else if (check ==1) {
            return true;
        } else {
            throw new IllegalArgumentException("입력한 숫자는 1또는 2여야합니다.");
        }
    }



}
