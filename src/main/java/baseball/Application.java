package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        String input;
        boolean loop = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (loop) {
            List<Integer> computer = getRandomNum();

            boolean isAnswer = false;
            while (!isAnswer) {
                int strike = 0, ball = 0;
                input = Console.readLine();
                List<Integer> inputNum = checkInput(input);

                for (int i = 0; i < inputNum.size(); i++) {
                    for (int j = 0; j < computer.size(); j++) {
                        if (inputNum.get(i) == computer.get(j)) {
                            ball++;
                            if (i == j) {
                                ball--;
                                strike++;
                            }
                        }

                    }
                }

                printResult(strike, ball);

                if (strike == 3) {
                    isAnswer = true;
                }

            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
            loop = isEnd(Integer.parseInt(input));
        }
    }

    private static void printResult(int strike, int ball) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫싱");
        } else if (strike == 0) {
            stringBuilder.append(ball + "볼");
        } else if (ball == 0) {
            stringBuilder.append(strike + "스트라이크");
        } else {
            stringBuilder.append(ball + "볼 " + strike + "스트라이크");
        }

        System.out.println(stringBuilder);
    }

    private static List<Integer> checkInput(String input) {
        Set<Integer> set = new HashSet<>();
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값을 확인해 주세요");
        }

        List<Integer> inputNum = List.of(
                Character.getNumericValue(input.charAt(0)),
                Character.getNumericValue(input.charAt(1)),
                Character.getNumericValue(input.charAt(2))
        );

        for (Integer integer : inputNum) {
            if (set.contains(integer)) {
                throw new IllegalArgumentException("숫자가 중복횝니다");
            }
            set.add(integer);
        }
        return inputNum;
    }

    private static List<Integer> getRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static boolean isEnd(int input) {
        if (input == 1) {
            return true;
        }
        if (input < 1 || input > 2) {
            throw new IllegalArgumentException("입력값을 확인해주세요");
        }

        return false;
    }
}
