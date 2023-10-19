package baseball.utils;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);
    public String input(){
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }
    public String replayInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }
}
