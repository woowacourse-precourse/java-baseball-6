package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

    static String guessNum;
    static boolean canPlay;
    static String theAnswer;

    public static void gameInitializer() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        canPlay = true;

        while (canPlay){
            theAnswer = AnswerController.makeAnswer();
            System.out.println("answer: " + theAnswer);    // 테스트용

            gamePlay();
        }
    }

    private static void gamePlay() {
        System.out.print("숫자를 입력해주세요 : ");
        guessNum = Console.readLine();
        System.out.println("guessNum = " + guessNum);   // 테스트용

        int resultCount = Counter.hitBallCounter(guessNum, theAnswer);
        System.out.println("resultCount = " + resultCount);     // for test

    }


}
