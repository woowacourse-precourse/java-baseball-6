package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        if (userInput > 999 || userInput < 123) {
            throw new IllegalArgumentException("1부터 9까지 서로다른 3자리 수로 입력해야합니다.");
        }

        // 입력받은 3자리 수를 자리수별로 쪼개어 배열에 담음
        int[] digits = new int[3];

        for (int i = 2; i >= 0; i--) {
            if (userInput % 10 == 0) {
                throw new IllegalArgumentException("0은 포함될 수 없습니다.");
            }
            digits[i] = userInput % 10;
            userInput /= 10;
        }

        // Set을 사용해 입력받은 3자리 수를 저장
        Set<Integer> digitSet = new HashSet<>();
        for (int digit : digits) {
            digitSet.add(digit);
        }

        // 만약 유저가 입력한 3자리 수에 중복이 존재한다면 size가 3이 안되기때문에 에러 발생
        if (digitSet.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

        // 컴퓨터가 중복없는 3개의 수를 고르는 코드
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 컴퓨터의 숫자와 유저의 숫자를 비교하는 코드

        // 스트라이크, 볼 카운트
        int strike = 0;
        int ball = 0;

        // 유저의 수와 컴퓨터의 수를 하나씩 비교하면서 볼, 스트라이크 카운트 계산
        for (int i = 0; i < 3; i++) {
            int user = digits[i];
            int com = computer.get(i);

            if (computer.contains(user)) {
                if (user == com) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        System.out.println(Arrays.toString(digits));
        System.out.println(computer);
        if (strike + ball != 0) {
            if (ball > 0 && strike > 0) {
                System.out.printf("%d볼 %d스트라이크", ball, strike);
            } else if (ball > 0) {
                System.out.printf("%d볼", ball);
            } else {
                System.out.printf("%d스트라이크", strike);
            }
        } else {
            System.out.println("낫싱");
        }
    }
}
