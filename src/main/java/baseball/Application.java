package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final int LENGTH_OF_NUMBER = 3;

        // 게임이 종류을 결정하는 변수
        boolean isChecked = true;
        int numberOfStrike = 0;
        int numberOfBall = 0;
        boolean checkTheUserResponse = true;

        while (checkTheUserResponse) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < LENGTH_OF_NUMBER) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (isChecked) {
                // 사용자의 입력을 받는 부분
                System.out.print("숫자를 입력해주세요 : ");
                String[] user = Console.readLine().split("");

                //TODO 무슨 말인지 모르겠다 공부하자 새로운 언어에서의 문법
                Integer[] userNumber = Stream.of(user).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

                for (int i = 0; i < LENGTH_OF_NUMBER; i++) {
                    if (computer.get(i).equals(userNumber[i]))
                        numberOfStrike++;
                }

                if (numberOfStrike == 3) {
                    break;
                }

                for (int i = 0; i < LENGTH_OF_NUMBER; i++) {
                    if (computer.contains(userNumber[i]))
                        numberOfBall++;
                }
            }
        }

    }
}
