package baseball;

import java.util.Scanner;

public class GameProgress {
    int userNumber;

    void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
    }

    void scanUserNumber() {
        Scanner scan = new Scanner(System.in);
        userNumber = scan.nextInt();
    }

    void printResult() {

    }
}
