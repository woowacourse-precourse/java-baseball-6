package baseball.models;

import camp.nextstep.edu.missionutils.Console;

import baseball.utils.Utils;

public class Game {

    public static final int NUM_LENGTH = 3;
    public boolean status; // 게임 진행 여부

    public boolean isStatus() {
        return status;
    }

    Utils utils = new Utils();

    // 게임 시작하는 메소드
    public void init() {
        this.status = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 게임 종료하는 메소드
    public void exit() {
        System.out.println("숫자 야구 게임을 종료합니다.");
    }

    // 사용자에게 숫자 입력을 요청하는 메소드
    public String askForGuess() {
        String result = "";
        try {
            System.out.print("숫자를 입력해주세요 : ");
            result = Console.readLine();
            Utils.validateInputValue(result, NUM_LENGTH);
        } catch (IllegalArgumentException e) {
            System.out.println("입력이 잘못되었습니다.");
            changeStatus();
        }
        return result;
    }

    // 정답을 맞힌 경우 게임 재시작 여부 입력 요청하는 메소드
    public void askForRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();
        utils.validateRestartInput(playerInput);
        if (playerInput.equals("2")) {
            changeStatus();
        }
    }

    // status를 변경
    public void changeStatus() {
        if (this.status) {
            this.status = false;
        } else if (!this.status) {
            this.status = true;
        }
    }

}
