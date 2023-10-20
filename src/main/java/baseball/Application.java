package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean newGame;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            newGame = true;
            List<Integer> comList = new ArrayList<>();
            while (comList.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!comList.contains(randomNumber)) {
                    comList.add(randomNumber);
                }
            }
            boolean game = true;
            while (game) {
                System.out.print("숫자를 입력해주세요: ");
                int ball = 0;
                int strike = 0;
                int num = Integer.parseInt(Console.readLine());
                if (num < 100 || num > 999) {
                    throw new IllegalArgumentException();
                }
                int[] myList = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
                for (int i = 0; i < 3; i++) {
                    if (myList[i] != comList.get(i)) {
                        boolean contains = comList.contains(myList[i]);
                        if (contains) {
                            ball++;
                        }
                    } else {
                        strike++;
                    }
                }
                if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                } else {
                    if (ball != 0) {
                        System.out.print(ball + "볼 ");
                    }
                    if (strike == 0) {
                        System.out.println();
                    }
                    if (strike != 0) {
                        System.out.println(strike + "스트라이크");
                    }
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    game = false;
                    int value = Integer.parseInt(Console.readLine());
                    if (value == 1) {
                        newGame = true;
                    } else if (value == 2) {
                        newGame = false;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        } while (newGame);
    }
}
