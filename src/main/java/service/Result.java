package service;

import java.util.List;

import static baseball.Application.TOTAL_CARDS;

public class Result {
    private int balls = 0;
    private int strikes = 0;

    public Result(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public static Result getResult(List<Integer> computer, String input) {
        int balls = 0;
        int strikes = 0;
        char[] inputChars = input.toCharArray();

        for (int i = 0; i < TOTAL_CARDS; i++) {
            for (int j = 0; j < TOTAL_CARDS; j++) {
                if (computer.get(i) == Character.getNumericValue(inputChars[j])) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                    break;
                }
            }
        }

        return new Result(balls, strikes);
    }

    public static void printResult(Result result) {
        if (result.getBalls() == 0 && result.getStrikes() == 0) System.out.println("낫싱");
        else if (result.getBalls() == 0) System.out.println(result.getStrikes() + "스트라이크");
        else if (result.getStrikes() == 0) System.out.println(result.getBalls() + "볼");
        else System.out.println(result.getBalls() + "볼" + " " + result.getStrikes() + "스트라이크");
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }
}
