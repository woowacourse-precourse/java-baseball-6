package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class NumberBaseBallGame {
    public void baseBallGame() {

        int strike = 0;
        int ball = 0;
        int out = 0;
        int start = 1;
        int input;
        try {
            while (start == 1) {
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                List<Integer> inputList = new ArrayList<>();

                System.out.println("숫자 야구 게임을 시작합니다.");
                while (strike != 3) {
                    System.out.print("숫자를 입력해주세요 : ");
                    input = Integer.parseInt(Console.readLine());
                    if (987 < input || input < 123) {
                        throw new IllegalArgumentException("3자리만 입력해주세요");
                    }
                    inputList.add(input/100);
                    inputList.add(input / 10 % 10);
                    inputList.add(input % 10);
                    if (inputList.get(0) == inputList.get(1)) {
                        throw new IllegalArgumentException("중복오류");
                    } else if (inputList.get(0) == inputList.get(2)) {
                        throw new IllegalArgumentException("중복오류");
                    } else if (inputList.get(1) == inputList.get(2)) {
                        throw new IllegalArgumentException("중복오류");
                    }

                    for (int i = 0;i < 3;i++) {
                        if (computer.contains(inputList.get(i))) {
                            if (computer.get(i) == inputList.get(i)) {
                                strike += 1;
                            } else {
                                ball += 1;
                            }
                        } else {
                            out += 1;
                        }
                    }
                    if (strike == 3) {
                        System.out.printf("%d스트라이크\n", strike);
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        strike = 0;
                        ball = 0;
                        out = 0;
                        inputList.clear();
                        break;
                    } else if (out == 3) {
                        System.out.println("낫싱");
                    } else if (ball == 0) {
                        System.out.printf("%d스트라이크\n", strike);
                    } else {
                        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                    }

                    strike = 0;
                    ball = 0;
                    out = 0;
                    inputList.clear();
                }

                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
                start = Integer.parseInt(Console.readLine());
            }
            if (start != 2) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
