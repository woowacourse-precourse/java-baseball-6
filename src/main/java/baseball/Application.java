package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            //한 게임 시작
            Game game = new Game();
            game.start();
            //게임 종료 후 사용자의 입력으로 부터 재시작 여부 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String flag = Console.readLine();
            if (flag.equals("2")) {
                break;
            }
        }
    }
}