package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static baseball.Application.randomBalls;
import static baseball.Application.userNumbers;

public class CompareTwoNumbers {
    ViewResult viewResult = new ViewResult();
    static int strike;
    static int ball;
    public int play() throws IOException {
        strike = 0;
        ball = 0;
        checkBalls();
        if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int result = Integer.parseInt(Console.readLine());    // 검증 로직이 필요함

            if(result == 1){//재시작
                return 1;
            }
            else if(result == 2){ // 종료
                return 2;
            }
        }
        else viewResult.printResult(strike,ball); // 계속 반
        return 3;
    }

    private void checkBalls() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(randomBalls.get(i) == userNumbers.get(j)){
                    if(i==j){
                        strike++;
                    }
                    else ball++;
                    break;
                }
            }
        }
    }
}
