package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Guess {
    private static List<Integer> input;
    private static int ball;
    private static int strike;

    public static void guess() {
        newGuess();
        guessInput();
        guessCheck();
        guessPrint();
        // 전부 스트라이크면 종료 페이즈로
        if (strike == Variables.answerLength) {
            Application.onProcess = false;
        }
    }

    private static void newGuess() {
        // Guess 클래스의 변수 초기화
        input = new ArrayList<>();
        ball = 0;
        strike = 0;
    }

    private static void guessInput() {
        // 질문 출력
        System.out.printf(Text.inputText);
        // 인풋 받기 및 숫자의 List로 저장
        char[] str = Console.readLine().toCharArray();
        for (char c : str){
            if (!input.contains(Character.getNumericValue(c))){
                input.add(Character.getNumericValue(c));
            }
        }
    }

    private static void guessCheck() {
        // 볼 스트라이크 계산
        int i = 0;
        for (int num : input) {
            if (Init.answer.get(i++) == num){
                strike++;
            } else if (Init.answer.contains(num)) {
                ball++;
            }
        }
    }

    private static void guessPrint() {
        // 계산 결과값 출력
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            if (ball != 0) {
                System.out.printf(String.format("%d볼 ", ball));
            }
            if (strike != 0) {
                System.out.printf(String.format("%d스트라이크", strike));
            }
            System.out.println();
        }
    }
}