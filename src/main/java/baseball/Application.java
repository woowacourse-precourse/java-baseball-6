package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.game.StartNewGame.startNewGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int flag = 0;
        while(flag != 2){
            startNewGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            flag = Integer.parseInt(Console.readLine());
        }
    }
}
