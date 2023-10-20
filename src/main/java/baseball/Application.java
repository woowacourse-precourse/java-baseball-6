package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {
    private static int[] arr;
    private static int game() {
        // 정답생성 - 배열에 저장
        arr = new int[3];
        Arrays.fill(arr, 0);
        arr[0] = Randoms.pickNumberInRange(1, 9);
        while (arr[1] == 0) {
            int r = Randoms.pickNumberInRange(1, 9);
            if (arr[0] != r) arr[1] = r;
        }
        while (arr[2] == 0) {
            int r = Randoms.pickNumberInRange(1, 9);
            if (arr[0] != r && arr[1] != r) arr[2] = r;
        }
        // 사용자 입력
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = false;
        while (!flag) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (input.contains("0")) {
                throw new IllegalArgumentException();
            }
            int p = Integer.parseInt(input);
            if (99 < p && p < 1000) {
                flag = verify(input);
            } else throw new IllegalArgumentException();
        }
        // 종료 또는 재시작
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replay = Integer.parseInt(Console.readLine());
        if (!(replay == 1 || replay == 2)) {
            throw new IllegalArgumentException();
        } else if (replay == 1) {
            return 1;
        } else {
            return 2;
        }
    }
    private static boolean verify(String input) {
        //정답 검증 - 피할 수 없는 3x3
        int[] temp = new int[3];
        int p = Integer.parseInt(input);
        temp[0] = p / 100;
        temp[1] = (p / 10) % 10;
        temp[2] = p % 10;
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i] == temp[j]) { // char -> int
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }
        // 출력
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
        return false;
    }
    public static void main(String[] args) {
        int result = 1;
        while (result == 1) {
            result = game();
        }
        if (result == 2) {
            return;
        }
    }
}