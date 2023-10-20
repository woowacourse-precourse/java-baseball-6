package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RunGame {

    public static void runBaseBallGame() {
        String number = generateNumber();
        int ball = 0, strike = 0;

        while (true) {
            String userAnswer = getUserAnswer();
            checkUserAnswer(userAnswer);
            if(printResult(ball, strike))
                break;
        }
    }

    private static String generateNumber() {
        List<Integer> list = new ArrayList<>();

        int cnt = 3;
        while(cnt-- > 0) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randomNumber))
                list.add(randomNumber);
        }

        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static String getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private static void checkUserAnswer(String answer) {
        if(!isAnswerLengthRight(answer)
                && !isAnswerDigit(answer)
                && isAnswerContainZero(answer))
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    private static boolean printResult(int ball, int strike) {
        if(strike == 3)
            return true;

        if(ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if(ball == 0)
            System.out.println(strike + "스트라이크");
        else if(strike == 0)
            System.out.println(ball + "볼");
        else
            System.out.println(ball + "볼 " + strike + "스트라이크");

        return false;
    }

    private static boolean isAnswerLengthRight(String answer) {
        return answer.length() == 3;
    }

    private static boolean isAnswerDigit(String answer) {
        return answer.chars().allMatch(Character::isDigit);
    }

    private static boolean isAnswerContainZero(String answer) {
        return answer.chars().anyMatch(ch -> ch == '0');
    }
}
