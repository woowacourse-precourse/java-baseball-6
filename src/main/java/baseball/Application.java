package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int RESTART_NUM = 1;
    private static final int EXIT_NUM = 2;

    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            BaseballController game = new BaseballController();
            game.startGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            int again = playagain();
            if (again == EXIT_NUM){
                break;
            }
        }
    }
    // 경기 재시작 여부
    private static int playagain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int reGame = Integer.parseInt(Console.readLine());
        if (reGame != RESTART_NUM && reGame != EXIT_NUM){
            throw new IllegalArgumentException("입력 오류");
        }
        return reGame;
    }
}