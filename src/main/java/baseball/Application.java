package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int a = 1;
        Scanner scan = new Scanner(System.in);
        while (a == 1) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                int number = scan.nextInt();
                if((int) (Math.log10(number) + 1) != 3){
                    throw new IllegalArgumentException();
                }
                ArrayList<Integer> inputs = new ArrayList<>();
                inputs.add(0, number / 100);
                inputs.add(1, (number % 100) / 10);
                inputs.add(2, (number % 10));

                int ballCount = 0;
                int strikeCount = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Objects.equals(computer.get(i), inputs.get(j))) {
                            if (i == j) {
                                strikeCount++;
                            } else {
                                ballCount++;
                            }
                        }
                    }
                }
                if (ballCount > 0) {
                    System.out.print(ballCount + "볼 ");
                }
                if (strikeCount > 0) {
                    System.out.println(strikeCount + "스트라이크");
                }
                if (ballCount == 0 && strikeCount == 0) {
                    System.out.println("낫싱");
                }
                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            a = scan.nextInt();
            if (a != 1 && a != 2) {
                throw new IllegalArgumentException();
            }
        }
        scan.close();
    }
}
