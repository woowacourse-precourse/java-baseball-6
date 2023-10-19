package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static boolean gameOver = false;
    static int[] computer = new int[3];
    static int[] user = new int[3];

    public static void main(String[] args) {
        while (!gameOver) {
            gameStart();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");

                String input = readLine();

                if (!isValidNumber(input)) {
                    try {
                        inputError();
                    } catch (IllegalArgumentException e) {
                        gameOver = true;
                        break;
                    }
                }
            }
        }
    }

    private static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 상대방의 수 생성
        Set<Integer> hashSet = new HashSet<>();

        while (hashSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            hashSet.add(randomNumber);
        }

        Iterator<Integer> iterator = hashSet.iterator();
        for (int i = 0; i < 3; i++) {
            computer[i] = iterator.next();
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
