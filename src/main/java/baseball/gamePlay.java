package baseball;

import java.util.Scanner;

public class gamePlay {
    public void isFinished() {
        // TODO. 게임 플레이 구현하기 (종료 및 재시작)
        start();
    }

    public void start() {
        printStartMsg();    // 게임 시작 문구 출력
        // 컴퓨터 랜덤 수 생성
        pritUserInput();    // 사용자 입력 문구 출력
        getUserInput();     // 사용자 입력 받기
    }

    private void printStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void pritUserInput() {
        System.out.print("숫자를 입력해주세요 :");
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        // 사용자의 입력이 정수인지 확인
        if (scanner.hasNextInt()) {
            int userInput = scanner.nextInt();
            System.out.print(userInput);
        } else {
            // 에러 메세지 출력
        }
        scanner.close();
    }

}
