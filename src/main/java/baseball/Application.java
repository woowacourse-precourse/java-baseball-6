package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int isEnd = 1;
        System.out.println("숫자 야구 게임을 시작 합니다.");

        // 정답 숫자(3자리) 랜덤 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        List<Integer> user = new ArrayList<>();
        int userNumber = 0;
        // result[0] -> ball, result[1] -> strike
        int[] result = {0, 0};
        String[] resultDisplay = {"볼", "스트라이크"};

        while (isEnd == 1) {
            // 유저로부터 숫자 3자리 입력
            System.out.print("숫자를 입력해주세요 : ");
            userNumber = Integer.parseInt(Console.readLine());
            if (userNumber < 100 || userNumber > 999) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < 3; i++) {
                user.add(0, userNumber % 10);
                userNumber /= 10;
            }

            if (user.size() == 3) {
                for (int i = 0; i < 3; i++) {
                    if (user.get(i) == 0) {
                        throw new IllegalArgumentException();
                    }
                }
            }

            // 유저가 입력한 숫자와 컴퓨터가 입력한 숫자 비교
            for (int i = 0; i < 3; i++) {
                if (computer.contains(user.get(i))) {
                    if (computer.get(i) == user.get(i)) {
                        result[1]++;
                    } else if (computer.get(i) != user.get(i)) {
                        result[0]++;
                    }
                }
            }

            if (result[0] == 0 && result[1] == 0) {
                System.out.print("낫싱");
            }

            for (int i = 0; i < 2; i++) {
                if (result[i] > 0) {
                    System.out.print(result[i] + resultDisplay[i] + " ");
                }
            }
            System.out.println();

            if (result[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                isEnd = Integer.parseInt(Console.readLine());
                if (isEnd == 1) {
                    for (int i = 0; i < 3; i++) {
                        computer.set(i, 0);
                    }
                    for (int i = 0; i < 3; i++) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.set(i, randomNumber);
                        }
                    }
                }
                if (isEnd == 2) {
                    break;
                }
            }

            for (int i = 0; i < 2; i++) {
                result[i] = 0;
            }
        }
    }
}
