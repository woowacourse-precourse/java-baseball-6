package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        loop1 : while (true) {
            // 숫자 선정
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            // System.out.println("결과는 : " + computer.get(0) + computer.get(1) + computer.get(2));

            // 같은 수가 같은 자리에 있으면 스트라이크,
            // 다른 자리에 있으면 볼,
            // 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고,
            // 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

            loop2 : while (true) {
                // 입력 받기
                System.out.print("숫자를 입력해주세요 : ");
                int num = Integer.parseInt(Console.readLine());

                if (num < 100 || num > 999) {
                    System.out.println("3자리 수만 입력 가능합니다.");
                    continue;
                }

                int result1 = 0, result2 = 0;

                for (int i = 2; i >= 0; i--) {
                    int temp = num % 10;
                    num /= 10;

                    for (int j = 2; j >= 0; j--) {
                        if (temp == computer.get(j)) {
                            if (i == j) {
                                result1 += 1;
                            } else {
                                result2 += 1;
                            }
                        }
                    }
                }

                if (result1 == 3) {
                    System.out.println("3스크라이크\n3개의 숫자를 모두 맞히셨습니다. 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    while (true) {
                        int game = Integer.parseInt(Console.readLine());

                        if (game == 1) {
                            break loop2;
                        } else if (game == 2) {
                            break loop1;
                        } else {
                            System.out.println("1 아니면 2만 입력 가능합니다. 다시 입력해주세요.");
                        }
                    }
                } else if (result1 == 0 && result2 == 0) {
                    System.out.println("낫싱");
                } else if (result1 == 0) {
                    System.out.println(result2 + "볼");
                } else if (result2 == 0) {
                    System.out.println(result1 + "스크라이크");
                } else {
                    System.out.println(result2 + "볼 " + result1 + "스크라이크");
                }
            }   // end while

        }   // end loop while

    }
}
