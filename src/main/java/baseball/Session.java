package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Session {
    // 프로그램 시작, 응답받기
    public static void startGame() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String answer = Console.readLine();

            Validation.isValidAnswerTarget(answer);
            Defender.printScore(answer);

        } while (!endGame());
    }

    // 프로그램 종료하기
    private static boolean endGame() {
        boolean isRestart = false;
        String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        if (Defender.isThreeStrikes()) {
            System.out.println(endMessage);
            String restart = Console.readLine();

            // TODO: Validation 클래스 이용
            isRestart = Validation.isValidAnswerReset(restart);
        }
        return isRestart;
    }
}
