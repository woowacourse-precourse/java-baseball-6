package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Baseball_Machine {

    private final Keyboard keyboard = new Keyboard();
    private final Answer answer = new Answer();

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String correctAnswer = answer.makeAnswer();
        String userAnswer = "";
        boolean result = false;

        while (!result) {
            userAnswer = keyboard.getInput();
            result = judge(correctAnswer, userAnswer);
        }

        if (selectMenu().equals("1")) play();
    }

    public boolean judge(String correctAnswer, String userAnswer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            char charAtUserAnswer = userAnswer.charAt(i);
            String charToString = String.valueOf(charAtUserAnswer);
            if (correctAnswer.contains(charToString)) {
                if (correctAnswer.indexOf(charAtUserAnswer) == userAnswer.indexOf(charAtUserAnswer)) strike++;
                else ball++;
            }
        }

        printResult(ball, strike);
        return strike == 3;
    }

    private String selectMenu() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public void printResult(int ball, int strike) {
        String result = "";

        if (ball > 0) result += ball + "볼 ";
        if (strike > 0) result += strike + "스트라이크";
        if (result.isEmpty()) result = "낫싱";

        System.out.println(result);
    }
}
