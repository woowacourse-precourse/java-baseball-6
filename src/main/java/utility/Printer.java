package utility;

import data.GuessNumber;

import java.util.List;

public final class Printer {
    private Printer(){}
    public static void printBaseballNumber(GuessNumber guess){
        List<Integer> guessNumbers = guess.getNumbers();
        for (Integer integer : guessNumbers) {
            System.out.print(integer);
        }
        System.out.println();
    }
    public static void printResult(final List<Integer> countResult){
        int ball = countResult.get(0);
        int strike = countResult.get(1);
        StringBuilder result = new StringBuilder();

        if(ball == 0 && strike == 0){
            result.append("낫싱");
        }
        if (strike == 3) {
            result.append("3스트라이크\n")
                    .append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (ball > 0 && strike > 0 || ball < 3 && strike < 3){
            result.append(ball).append("볼 ").append(strike).append("스트라이크");
        }
        System.out.println(result);
    }
}
