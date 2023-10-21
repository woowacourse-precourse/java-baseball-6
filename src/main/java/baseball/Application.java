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
        boolean checkTheUserResponse = true;
        String[] user;

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
                user = Console.readLine().split("");
                if (user.length != 3)
                    throw new IllegalArgumentException("숫자의 길이가 큽니다");

                int numberOfStrike = 0;
                int numberOfBall = 0;

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

                numberOfBall = numberOfBall - numberOfStrike;

                if (numberOfStrike == 0 && numberOfBall != 0) {
                    System.out.println(numberOfBall + "볼");
                } else if (numberOfStrike == 0 && numberOfBall == 0) {
                    System.out.println("낫싱");
                } else if (numberOfBall == 0 && numberOfStrike != 0) {
                    System.out.println(numberOfStrike + "스트라이크");
                } else {
                    System.out.println(numberOfBall + "볼 " + numberOfStrike + "스트라이크");
                }
            }
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input = Integer.parseInt(Console.readLine());
            if (input == 2) {
                checkTheUserResponse = false;
                //TODO isChecked를 false하면 바로 빠져나오는지 또는 break만 쓰면 빠져나와서 다시 while문에 안들어가는지 확인하기
                break;
            }
        }

    }
}
