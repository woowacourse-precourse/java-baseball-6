package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Session {
    public static void startGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String answer = Console.readLine();

            Validation.isValidAnswer(answer);
            Defender.printScore(answer);

            if (endGame()) {
                break;
            }
        }
    }

    // 프로그램 종료하기
    public static boolean endGame() {
        boolean isRestart = false;

        if (Defender.isThreeStrikes()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();

            // TODO: Validation 클래스 이용
            isRestart = Validation.isValidAnswer2(restart);
        }
        return isRestart;
    }
}
