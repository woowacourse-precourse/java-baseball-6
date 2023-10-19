package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = br.readLine();

            if (!isValidNumber(input)) {
                try {
                    inputError();
                } catch (IllegalArgumentException e) {
                    return;
                }
            }
        }
    }

    private static boolean isValidNumber(String s) {
        if (s.length() != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            int j = s.charAt(i) - '0';

            if (!(j >= 1 && j <= 9)) {
                return false;
            }
        }

        return true;
    }

    private static void inputError() {
        throw new IllegalArgumentException();
    }
}
