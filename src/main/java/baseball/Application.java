package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static Scanner s = new Scanner(System.in);

    private static void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> correctAnswer = makeAnswer();
        List<Integer> userAnswer;
        boolean result = false;

        while (!result) {
            userAnswer = getUserAnswer();
            result = judge(correctAnswer, userAnswer);
        }

    }

    private static List<Integer> makeAnswer() {
        List<Integer> correctAnswer = new ArrayList<>();

        while (correctAnswer.size() < 3) {
            int r = Randoms.pickNumberInRange(1, 9);
            if (!correctAnswer.contains(r)) {
                correctAnswer.add(r);
            }
        }

        return correctAnswer;
    }

    private static List<Integer> getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        int n = s.nextInt();
        List<Integer> userAnswer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            userAnswer.add(n % 10);
            n /= 10;
        }

        Collections.reverse(userAnswer);
        return userAnswer;
    }

    private static boolean judge(List<Integer> correctAnswer, List<Integer>userAnswer) {
        int ball = 0;
        int strike = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int number = userAnswer.get(i);
            if (correctAnswer.contains(number)) {
                if (correctAnswer.indexOf(number) == userAnswer.indexOf(number)) strike++;
                else ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }

        if (ball > 0) result.append(ball).append("볼 ");
        if (strike > 0) result.append(strike).append("스트라이크");
        if (result.isEmpty()) result.append("낫싱");

        System.out.println(result);
        return false;
    }

    private static int selectMenu() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return s.nextInt();
    }

    public static void main(String[] args) {
        play();
        if (selectMenu() == 1) play();
        else System.out.println("프로그램을 종료합니다.");
    }
}
