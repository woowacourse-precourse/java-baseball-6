package baseball;

import baseball.givennum.GivenNum;
import baseball.judge.Judge;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        GivenNum givenNum = new GivenNum();
        Judge judge = new Judge(givenNum);

        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다");
            int[] userGuess;
            String result = "";

            while (!result.equals("3스트라이크")) {
                System.out.print("숫자를 입력해주세요 : ");
                input = sc.nextLine();
                userGuess = ParseNum.parseInput(input);
                result = judge.strikesAndBalls(userGuess);
                System.out.println(result);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            input = sc.nextLine();

            if (!input.equals("1")) {
                break; // 게임 종료
            }
        }

        sc.close();
    }
}