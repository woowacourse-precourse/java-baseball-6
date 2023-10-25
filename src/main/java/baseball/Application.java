package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isRetry = true;
        while (isRetry) {
            Target target = new Target();

            boolean isStrikeOut = true;
            while (isStrikeOut) {
                Output output = new Output();

                System.out.print("숫자를 입력해주세요 : ");
                Input input = new Input();

                for (int i = 0; i < target.getNumberList().size(); i++) {
                    for (int j = 0; j < input.getNumberList().size(); j++) {
                        //NOTE 스트라이크 경우
                        if (Objects.equals(target.getNumberList().get(i), input.getNumberList().get(j))
                                && i == j) {
                            output.addStrikeCount();
                            break;
                        }

                        //NOTE 볼 경우
                        if (Objects.equals(target.getNumberList().get(i), input.getNumberList().get(j))) {
                            output.addBallCount();
                            break;
                        }
                    }
                }

                System.out.println(output.getOutputStr());

                if (output.getStrikeCount() == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String restartExitInput = Console.readLine();

                    if (restartExitInput.equals("1")) {
                        isStrikeOut = false;
                    } else if (restartExitInput.equals("2")) {
                        isStrikeOut = false;
                        isRetry = false;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
    }
}
