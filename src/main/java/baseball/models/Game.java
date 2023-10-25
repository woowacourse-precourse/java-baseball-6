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
    public void exit(int playerInput) {
        if (playerInput == 2) {
            this.status = false;
            System.out.println("숫자 야구 게임을 종료합니다.");
        }
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
            exit(2);
        }
        return result;
    }

    // 정답을 맞힌 경우 게임 재시작 여부 입력 요청하는 메소드
    public int askForRestart() {
        int playerInput = Integer.parseInt(Console.readLine());
        utils.validateRestartInput(playerInput);
        return playerInput;
    }

}
