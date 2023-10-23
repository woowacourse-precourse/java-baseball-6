package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RestartGame {
    public boolean restart() {
        Scanner sc = new Scanner(System.in);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        int reset = sc.nextInt();

        if (reset == 1) {
            return true;
        } else if (reset == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}