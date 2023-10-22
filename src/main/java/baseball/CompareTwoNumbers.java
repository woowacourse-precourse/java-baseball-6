package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static baseball.Application.randomBalls;
import static baseball.Application.userNumbers;

public class CompareTwoNumbers {
    ViewResult viewResult = new ViewResult();
    public int play() throws IOException {
        int strike = 0;
        int ball = 0;

        for(int i=0; i<3; i++){
            if(randomBalls.get(i) == userNumbers.get(i)){
                strike++;
            }
            else if(userNumbers.contains(randomBalls.get(i))){
                ball++;
            }
        }
        if(strike == 3){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int result = Integer.parseInt(br.readLine());    // 검증 로직이 필요함

            if(result == 1){//재시작
                return 1;
            }
            else if(result == 2){ // 종료
                return 2;
            }
        }
        else viewResult.printResult(strike,ball); // 계속 반복
        return 3;
    }
}
