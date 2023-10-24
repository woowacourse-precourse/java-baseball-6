package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballController {
    private static final int NUM_LENGTH = 3;
    private final RandomNumber computer;
    private int total = 0;
    private int strike = 0;
    private int ball = 0;

    public BaseballController() {
        computer = new RandomNumber();
    }

    public void resetCount(){
        total = 0;
        strike = 0;
        ball = 0;
    }

    public void startGame() {
        while (strike != 3){
            resetCount();
            String player = getPlayerInput();
            calculateResult(player);
            printResult(strike, ball);
        }
    }

    public int countTotal(List<Integer> computer, List<Integer> player) {
        for (Integer number : player) {
            if (computer.contains(number)) {
                total += 1;
            }
        }
        return total;
    }
    public int countStrike(List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < player.size(); i++) {
            if (Objects.equals(computer.get(i), player.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    // 스트라이크와 볼 최종 결정하기
    public void judge(List<Integer> computer, List<Integer> player) {
        total = countTotal(computer, player);
        strike = countStrike(computer, player);
        ball = total - strike;
    }

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

    // 플레이어 입력값 받기
    public String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != NUM_LENGTH) {
            throw new IllegalArgumentException("입력 값 오류");
        }
        return input;
    }

    public void calculateResult(String input){
        List<Integer> playerNumber = new ArrayList<>();
        for (String number : input.split("")) {
            playerNumber.add(Integer.parseInt(number));
        }
        judge(computer.getAllNumbers(), playerNumber);
    }

}
