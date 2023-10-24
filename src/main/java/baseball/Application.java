package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }

    public static void main(String[] args) {
        // TODO1: 게임시작 메세지 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        int gamestart = 1;

        while (gamestart == 1) {
            // TODO2: 랜덤 숫자 설정
            List<Integer> computer = getRandomNumber();

            System.out.println(computer);

            int restart = 1;

            while (restart == 1) {
                // TODO3: 사용자에게 숫자를 입력받기
                Scanner scanner = new Scanner(System.in);
                System.out.print("숫자를 입력해주세요 : ");
                int selectNumber = scanner.nextInt();
                List<Integer> user = new ArrayList<>();
                user.add(selectNumber / 100);
                selectNumber %= 100;
                user.add(selectNumber / 10);
                selectNumber %= 10;
                user.add(selectNumber);

                // TODO4: 볼, 스트라이크 갯수 세기
                int ball = 0;
                int strike = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j & user.get(i) == computer.get(j)) {
                            strike += 1;
                        } else if (user.get(i) == computer.get(j)) {
                            ball += 1;
                        }
                    }
                }

                // TODO5: 정답을 맞출 경우 게임 종료 아니면 재입력
                if (strike == 3) {
                    restart = 0;
                    System.out.printf("%d스트라이크\n", strike);
                } else if (ball > 0 & strike > 0) {
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                } else if (ball > 0) {
                    System.out.printf("%d볼\n", ball);
                } else if (strike > 0) {
                    System.out.printf("%d스트라이크\n", strike);
                } else {
                    System.out.println("낫싱");
                }
            }
        }

    }
}
