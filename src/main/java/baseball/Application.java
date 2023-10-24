package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;


public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        boolean flag = false; // 게임 종료 여부 결정

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!flag) {
            String input = Console.readLine();
            if (input.length() == 3 && Pattern.matches("[0-9]+", input)) {
                String result = computer.numberCheck(input);
                System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String newGame = Console.readLine();
                    if (Pattern.matches("[1-2]", newGame)) {
                        flag = newGame.equals(String.valueOf(2));
                        if (!flag) {
                            computer = new Computer();
                        }
                    } else {
                        System.out.println("1 또는 2의 숫자만 입력해 주세요.");
                        throw new IllegalArgumentException();
                    }
                }
            } else {
                System.out.println("3자리의 숫자만 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }

        System.out.println("게임 종료");
    }
}
