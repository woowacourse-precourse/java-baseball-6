package baseball;

import java.io.*;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            List<Integer> answer = AnswerGenerator.generateAnswer();
            while(true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                List<Integer> guess = InputValidator.validateInput(input);
                int[] result = StrikeBallCalculator.calculate(guess, answer);

                /*
                * 볼, 스트라이크 판단 여부 출력
                */
                if (result[0] == 0 && result[1] == 0)
                    System.out.println("낫싱");
                else {

                }

                if(result[1] == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    /*
                    * 게임 재시작 및 종료
                    */
                    String game = Console.readLine();
                    if(game.equals("1"))
                        break;
                    if(game.equals("2"))
                        return;
                }

                String output = "";
                if (result[0] > 0)
                    output += result[0] + "볼 ";
                if (result[1] > 0)
                    output += result[1] + "스트라이크";
                if(output.length() != 0)
                    System.out.println(output);

            }

        }

    }
}
