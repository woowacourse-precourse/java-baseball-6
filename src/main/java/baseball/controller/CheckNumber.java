package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckNumber {

    public static void checkNumberRules(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        String afterRegexInput = userInput.replaceAll("[^1-9]", "");
        Set<Character> inputSet = new HashSet<>();
        for (char c : afterRegexInput.toCharArray()) {
            inputSet.add(c);
        }
        if (inputSet.size() != 3) {
//            String errorMessage = "길이 3, 중복없는 1~9까지의 숫자 필요";
            throw new IllegalArgumentException();
        }
    }

    public static void strikesAndBalls(List<Integer> computer, String userInput) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int charUserInput = userInput.charAt(i) - '0';
            if (computer.get(i) == charUserInput) {
                strike++;
            } else if (computer.contains(charUserInput)) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            BaseBallGame.restart = Integer.parseInt(Console.readLine());
            if (BaseBallGame.restart == 1 || BaseBallGame.restart == 2) {
                throw new IllegalArgumentException();
            }
            BaseBallGame.correct = true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            BaseBallGame.correct = false;
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
            BaseBallGame.correct = false;
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
            BaseBallGame.correct = false;
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            BaseBallGame.correct = false;
        }

    }


}
