package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    public static void main(String[] args) {
        // 컴퓨터가 생각하고 있는 숫자를 생성합니다.
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        // 게임을 시작합니다.
        startGame(computerNumbers);
    }

    private static void startGame(List<Integer> computerNumbers) {
        // 게임 시작을 알립니다.
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임을 반복합니다.
        boolean isGameOver = false;
        while (!isGameOver) {
            // 사용자로부터 숫자를 입력받습니다.
            String userNumbers = Console.readLine("숫자를 입력해주세요 : ");

            // 입력한 숫자에 대한 결과를 출력합니다.
            printResult(userNumbers, computerNumbers);

            // 게임이 종료되었는지 확인합니다.
            isGameOver = isGameOver(userNumbers, computerNumbers);
        }

        // 게임이 종료되었음을 알립니다.
        System.out.println("게임 종료");

        // 재시작 또는 종료를 선택합니다.
        int choice = Console.readInt("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

        if (choice == 1) {
            startGame(computerNumbers);
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }

    private static void printResult(String userNumbers, List<Integer> computerNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int index = userNumbers.charAt(2 * i) - '0';
            if (index == computerNumbers.get(i)) {
                strike++;
            } else if (computerNumbers.contains(index)) {
                ball++;
            }
        }

        System.out.println(strike + "스트라이크 " + ball + "볼");
    }

    private static boolean isGameOver(String userNumbers, List<Integer> computerNumbers) {
        return userNumbers.equals(String.join("", computerNumbers));
    }
}
