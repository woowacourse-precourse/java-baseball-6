package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Match {

    private final GameNumber computer;

    public Match() {
        computer = new GameNumber();
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = Console.readLine();
            GameNumber player = new GameNumber(input);

            int ball = GameNumber.ball(computer, player);
            int strike = GameNumber.strike(computer, player);

            String output = "";
            if (ball != 0) {
                output += ball + "볼 ";
            }
            if (strike != 0) {
                output += strike + "스트라이크";
            }
            if (ball == 0 && strike == 0) {
                output = "낫싱";
            }
            System.out.println(output);

            if (strike == GameNumber.SIZE) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                break;
            }
        }
    }
}
