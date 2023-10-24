package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballController {
    private static final int NUM_LENGTH = 3;
    private final RandomNumber computer;
    private int strike = 0;
    private int ball = 0;

    // 기본 생성자를 통해 computer 초기화하기
    public BaseballController() {
        computer = new RandomNumber();
    }

    // 다음 질의를 위해 초기화하기
    public void resetCount(){
        strike = 0;
        ball = 0;
    }

    public void startGame() {
        while (strike != 3){
            resetCount();
            String player = getPlayerInput();
            calculateInput(player);
            printResult(strike, ball);
        }
    }

    // 결과 출력하기
    public void printResult(int strike, int ball){
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0 && strike >0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    // 게임 플레이어의 입력값 받기
    public String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        // 입력 값이 3이 아닌 경우 예외 처리
        if (input.length() != NUM_LENGTH) {
            throw new IllegalArgumentException("입력 값 오류");
        }
        return input;
    }

    // 입력값
    public void calculateInput(String input){
        String[] player = input.split("");
        for(int i=0; i<NUM_LENGTH; i++){
            if (computer.getNumber(i) == Integer.parseInt(player[i])){
                strike++;
            } else if (computer.contains(Integer.parseInt(player[i]))){
                ball++;
            }
        }
    }

}
