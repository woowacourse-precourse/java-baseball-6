package baseball.view;


import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String insertBallNum() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String insertNewGameOrGameOver() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
