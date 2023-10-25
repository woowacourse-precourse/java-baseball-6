package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isExit = false;

        while (!isExit) {
            List<Integer> randomList = new ArrayList<>();
            while (randomList.size() < 3) {
                int randomInt = Randoms.pickNumberInRange(1, 9);
                if (!randomList.contains(randomInt)) {
                    randomList.add(randomInt);
                }
            }

            while (true) {
                int strikeCount = 0;
                int ballCount = 0;
                StringBuilder output = new StringBuilder();

                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if (input.length() != 3) {
                    throw new IllegalArgumentException();
                } else if (!input.matches("[0-9]+")) {
                    throw new IllegalArgumentException();
                }

                String[] inputArr = input.split("");
                List<Integer> inputList = Arrays.stream(inputArr).map(Integer::parseInt).toList();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        //NOTE 스트라이크 경우
                        if (Objects.equals(randomList.get(i), inputList.get(j)) && i == j) {
                            strikeCount++;
                            break;
                        }

                        //NOTE 볼 경우
                        if (Objects.equals(randomList.get(i), inputList.get(j))) {
                            ballCount++;
                            break;
                        }
                    }
                }

                if (strikeCount == 0 && ballCount == 0) {
                    output.append("낫싱");
                }

                if (ballCount > 0) {
                    output.append(ballCount).append("볼");
                }

                if (ballCount > 0 && strikeCount > 0) {
                    output.append(" ");
                }

                if (strikeCount > 0) {
                    output.append(strikeCount).append("스트라이크");
                }

                System.out.println(output);

                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String restartExitInput = Console.readLine();

                    if (restartExitInput.equals("1")) {
                        break;
                    } else if (restartExitInput.equals("2")) {
                        isExit = true;
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
    }
}
