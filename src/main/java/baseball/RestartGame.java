package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RestartGame {
    public boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            String input = reader.readLine();

            if (input != null && !input.isEmpty()) {
                int restart = Integer.parseInt(input);

                if (restart != 1 && restart != 2) {
                    throw new IllegalArgumentException();
                }

                if (input.equals("1")) {
                    return true;
                } else if (input.equals("2")) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return false;
    }
}