package baseball.models;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private boolean status; // 게임 진행 여부

    public boolean isStatus() {
        return status;
    }

    // 게임 시작하는 메소드
    public void init() {
        this.status = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 게임 종료하는 메소드
    public void exit(int playerInput) {
        if (playerInput == 2) {
            this.status = false;
            System.out.println("숫자 야구 게임을 종료합니다.");
        }
    }

    // 사용자에게 숫자 입력을 요청하는 메소드
    public String askForGuess() {
        String result = "";

        System.out.print("숫자를 입력해주세요 : ");
        result = Console.readLine();

        return result;
    }

}
