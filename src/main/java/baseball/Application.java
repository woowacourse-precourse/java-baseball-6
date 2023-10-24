package baseball;

import baseball.computer.Computer;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        String result = "";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine().trim();
            isValidInput(userInput);
            int[] score = computer.getResult(userInput);
            if (score[1] != 0) {
                result += score[1] + "볼";
            }
            if (score[0] != 0) {
                if (!result.isEmpty()) {
                    result += ' ';
                }
                result += score[0] + "스트라이크";
            }
            if (result.isEmpty()) {
                result += "낫싱";
            }
            System.out.println(result);
            if (score[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restart = readLine().trim();
                if (!(restart.equals("1") || restart.equals("2"))) {
                    throw new IllegalArgumentException();
                }
                if (restart.equals("1")) {
                    computer.resetNumber();
                } else {
                    System.out.println("게임 종료");
                    break;
                }
            }
            result = "";
        }
    }

    private static void isValidInput(final String input) {
        if (input.length() != 3 || !input.matches("\\d+") || input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }
}


