package baseball;

import baseball.givennum.GivenNum;
import baseball.judge.Judge;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다");

            // 새로운 GivenNum 객체를 생성하여 새로운 무작위 숫자 생성
            GivenNum givenNum = new GivenNum();
            Judge judge = new Judge(givenNum);

            int[] userGuess;
            String result = "";

            try {
                while (!result.equals("3스트라이크")) {
                    System.out.print("숫자를 입력해주세요 : ");
                    String input = Console.readLine();
                    userGuess = ParseNum.parseInput(input);
                    result = judge.strikesAndBalls(userGuess);
                    if (!result.equals("3스트라이크")) {
                        System.out.println(result);
                    }
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
            }

            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            String input = Console.readLine();

            if (!input.equals("1")) {
                break; // 게임 종료
            }
        }
    }
}
