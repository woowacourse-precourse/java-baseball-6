package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

    static String guessNum;
    static boolean canPlay;
    static String theAnswer;
    static boolean isAnswer;

    public static void gameInitializer() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        canPlay = true;

        while (canPlay){
            theAnswer = AnswerController.makeAnswer();
            System.out.println("answer: " + theAnswer);    // 테스트용

            isAnswer = false;
            while (!isAnswer) {
                gamePlay();
            }
        }
    }

    private static void gamePlay() {
        System.out.print("숫자를 입력해주세요 : ");
        guessNum = Console.readLine();
        System.out.println("guessNum = " + guessNum);   // 테스트용

        int resultCount = Counter.hitBallCounter(guessNum, theAnswer);
        System.out.println("resultCount = " + resultCount);     // for test

        playAgain(resultCount);
    }

    private static void playAgain(int resultCount) {
        if (resultCount == 3) {
            isAnswer = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종류하려면 2를 입력하세요.");
            int playOrStop = Integer.parseInt(Console.readLine());
            if (playOrStop == 1) {
                canPlay = true;
            } else if (playOrStop == 2) {
                canPlay = false;
            }
        }
    }

}
