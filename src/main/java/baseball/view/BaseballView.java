package baseball.view;

import camp.nextstep.edu.missionutils.Console;


public class BaseballView {

    public BaseballView() {
    }

    public int[] getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 수를 입력해야 합니다.");
        }

        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            guess[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return guess;
    }


    public void displayResult(int balls, int strikes) {
        String result = "";


        if (balls > 0) {
            result += balls + "볼";
        }
        if (strikes > 0) {
            result += strikes + "스트라이크 ";
        }
        if(strikes == 0 && balls == 0)
            result += "낫싱";

        System.out.println(result);
    }



    public void displayGameWon() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    public int getRestartChoice() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public void displayGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}


