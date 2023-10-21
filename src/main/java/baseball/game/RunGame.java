package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class RunGame {

    public RunGame() {
        runBaseBallGame();
    }

    private static void runBaseBallGame() {
        Game.generateNumber();

        while (true) {
            String userAnswer = getUserAnswer();
            checkUserAnswer(userAnswer);
            Game.compareNumber(userAnswer);
            if(Game.printResult())
                break;
        }
    }

    private static String getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private static void checkUserAnswer(String answer) {
        if(!isAnswerLengthRight(answer)
                || !isAnswerDigit(answer)
                || isAnswerContainZero(answer))
            throw new IllegalArgumentException("잘못된 입력입니다.");
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
