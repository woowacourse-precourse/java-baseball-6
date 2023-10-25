package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int TOTAL_NUMBER = 3;

        BaseballGame gameAI = new BaseballGame(TOTAL_NUMBER);
        System.out.println(gameAI + "을 시작합니다.");

        while (true) {
            gameAI.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String continueInput = readLine();
            if (continueInput.equals("2")) return;
            else if (continueInput.equals("1")) continue;
            else throw new IllegalArgumentException();
        }
    }
}
