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

        // TODO2: 랜덤 숫자 설정
        List<Integer> computer = getRandomNumber();

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

    }
}
