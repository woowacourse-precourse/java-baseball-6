package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        Baseball baseball = new Baseball();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            Baseball.Result guessResult = baseball.guess(userInput);
            System.out.println(guessResult.toHangul());

            if (guessResult.isCorrect()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String endInput = Console.readLine();
                if ("1".equals(endInput)) {
                    baseball = new Baseball();
                } else if ("2".equals(endInput)) {
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid end input");
                }
            }
        }
    }

}
