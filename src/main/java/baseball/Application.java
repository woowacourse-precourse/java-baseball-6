package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(SystemMessage.GAME_START_MESSAGE);
        while (true) {
            //한 게임 시작
            Game game = new Game();
            game.start();
            //게임 종료 후 사용자의 입력으로 부터 재시작 여부 확인
            System.out.println(SystemMessage.GAME_RESTART_MESSAGE);

            String flag = Console.readLine();
            if (flag.equals("2")) {
                break;
            }
        }
    }
}