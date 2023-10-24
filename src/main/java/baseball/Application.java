package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            startBaseballShell();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        Console.close();
    }

    public static void startBaseballShell() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            String answer = getInput("숫자를 입력해주세요 : ", "\\d\\d\\d");
        }
    }

    public static String getInput(String message, String regex) {
        System.out.print(message);
        String userInput = Console.readLine();
        isMatches(userInput, regex);
        return userInput;
    }

    public static boolean isMatches(String string, String regex) {
        if (string.matches(regex)) {
            return true;
        }
        throw new IllegalArgumentException(string + " 은(는) 형식에 맞지 않습니다.");
    }


}