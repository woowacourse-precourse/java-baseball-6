package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startProgram();

        while ( retryCheck() ) {
            startProgram();
        }
    }

    private static boolean retryCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String retry = Console.readLine();

        switch (retry) {
            case "1" -> {
                return true;
            }
            case "2" -> {
                System.out.println("stop");
                Console.close();
                return false;
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }


    private static void startProgram() {
        String goal = generateValue();
        playGame(goal);
    }

    private static void playGame(String goal) {
        System.out.println("숫자를 입력해주세요");
        String input = Console.readLine();
        validation(input);

        boolean rightAnswer = apply(goal, input);

        if (rightAnswer) {
            playGame(goal);
        } else {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
    }

    private static String generateValue(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (Integer i : computer) {
            resultBuilder.append(i.toString());
        }
        return resultBuilder.toString();
    }

    private static void validation(String input){
        String pattern = "[1-9]{1,3}";

        boolean regex = Pattern.matches(pattern, input);
        if ( !regex ) throw new IllegalArgumentException();

        boolean isDuplicated = duplicateCheck(input);
        if ( isDuplicated ) throw new IllegalArgumentException();
    }

    private static boolean duplicateCheck(String input) {
        Set<Character> characters = new HashSet<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        return characters.size() != input.length();
    }

    private static boolean apply(String goal, String input) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char goalChar = goal.charAt(i);

            if (inputChar == goalChar) {
                strikes++;
            } else if (goal.contains(String.valueOf(inputChar))) {
                balls++;
            }
        }

        if (strikes == input.length()) {
            System.out.println(strikes + "스트라이크");
            return false;
        }

        if (balls > 0 && input.length() >= balls && strikes == 0) {
            System.out.println(balls + "볼 ");
        } else if (balls > 0 && input.length() >= balls && strikes > 0) {
            System.out.print(balls + "볼 ");
        }

        if (strikes > 0) {
            System.out.println(strikes + "스트라이크");
        }
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }

        return true;
    }

}
