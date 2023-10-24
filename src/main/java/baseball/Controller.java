package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Controller {
    public static void intro() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static ArrayList<Integer> queryNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String string = Console.readLine();

        if (string.length() != 3) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        int num;
        try {
            num = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i >= 0; i--) {
            arr.add(0, num % 10);
            num /= 10;
        }

        return arr;
    }

    public static boolean queryRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String string = Console.readLine();
        if (string.equals("1")) {
            return true;
        }
        if (string.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("입력이 올바르지 않습니다.");
    }

    public static void showResult(BaseballResultState result) {
        System.out.println(result);
    }
}
