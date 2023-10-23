package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GamePlay {
    private Computer computer;

    private Compare compare;

    public void isFinished() {
        this.computer = new Computer();
        do {
            start();
        } while (restart());
    }

    public void start() {
        printStartMsg();    // 게임 시작 문구 출력
        computer.getNumbers();// 컴퓨터 랜덤 수 생성
        pritUserInput();    // 사용자 입력 문구 출력
        getUserInput();     // 사용자 입력 받기
    }

    private void printStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void pritUserInput() {
        System.out.print("숫자를 입력해주세요 :");
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private Boolean restart() {
        int input = 0;
        while (invalidInput(input)) {
            printRestartMsg();
            input = Integer.parseInt(getUserInput());
        }
        // 에러 메시지 출력
        return (input == 1);
    }

    private boolean invalidInput(int input) {
        return (input != 1) && (input != 2);
    }

    private void printRestartMsg() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
