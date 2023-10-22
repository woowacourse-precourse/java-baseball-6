package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class RunGame {

    public RunGame() {
        startGame();
    }

    private static void startGame() {
        printStart();

        while(true) {
            runBaseBallGame();
            if(!wantToRestartOrEnd())
                break;
        }
    }

    private static void runBaseBallGame() {
        Game.generateNumber();

        while (true) {
            User.getUserAnswer();
            Game.compareNumber(User.getAnswer());
            if(Game.printResult())
                break;
        }
    }

    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static boolean wantToRestartOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();

        if(!isRightAnswer(answer))
            throw new IllegalArgumentException("잘못된 수를 입력하였습니다.");

        return answer.equals("1");      //1일 경우 게임을 재시작합니다.
    }

    public static boolean isRightAnswer(String answer) {
        return answer.equals("1") || answer.equals("2");
    }

}
