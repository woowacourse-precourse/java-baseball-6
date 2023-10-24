package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isRunning = true;

        while (isRunning) {
            int strike = 0;
            int ball = 0;
            boolean isPlaying = true;
            boolean isSucceeded = false;

            List<Integer> computer = new ArrayList<>();

            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (isPlaying) {
                System.out.print("숫자를 입력해주세요 : ");
                int userInputNumber = Integer.parseInt(Console.readLine());

                List<Integer> inputs = new ArrayList<>();

                // 세 자리 숫자의 각 자리의 숫자를 추출하여 List에 추가
                for (int i = 0; i < 3; i++) {
                    int digit = (userInputNumber / (int) Math.pow(10, 2 - i)) % 10;
                    inputs.add(digit);
                }

                for (int i = 0; i < computer.size(); i++) {
                    for (int j = 0; j < inputs.size(); j++) {
                        //numArr의 i번째 인덱스와 inputArr의 모든 원소들을 비교
                        if (computer.get(i) == inputs.get(j) && i == j) {
                            //같은 숫자가 있고 인덱스도 같으면 스트라이크
                            strike++;
                        } else if (computer.get(i) == inputs.get(j) && i != j) {
                            //같은 숫자만 있으면 볼
                            ball++;
                        }
                    }
                }

                System.out.println((ball > 0 ? (ball + "볼 ") : "") + (strike > 0 ? strike + "스트라이크" : "") + (ball == 0 && strike == 0 ? "낫싱" : ""));

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                    isSucceeded = true;
                }

                strike = 0;
                ball = 0;

                if (isSucceeded) {
                    System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int result = Integer.parseInt(Console.readLine());

                    if (result == 1) {
                        isPlaying = false;
                    } else if (result == 2) {
                        isPlaying = false;
                        isRunning = false;
                    }
                }
            }
        }
    }
}
