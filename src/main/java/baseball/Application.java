package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        boolean restart = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart) {

            BaseBallGame baseBallGame = new BaseBallGame();

            baseBallGame.start();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartInput = Console.readLine();
            restart = restartInput.equals("1");

        }

    }

}
