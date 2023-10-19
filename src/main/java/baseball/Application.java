package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean isFirstGame = true;
        int restart = 1;

        while (restart == 1) {
            if (isFirstGame) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                isFirstGame = false;
            }

            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                restart = Integer.valueOf(Console.readLine());
            } catch (RuntimeException e) {
                throw new IllegalArgumentException("숫자를 입력해주세요.", e);
            }

            if (restart != 1 || restart != 2) {
                throw new IllegalArgumentException("1 혹은 2를 입력해주세요.");
            }
        }
    }
}
