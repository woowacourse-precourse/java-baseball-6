package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

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
            String user = Console.readLine();

            ArrayList<Integer> userInputList = user.chars()
                    .mapToObj(Character::getNumericValue)
                    .collect(Collectors.toCollection(ArrayList::new));

            System.out.println("computer = " + computer);
            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < 3; i++) {
                if (userInputList.get(i) == computer.get(i)) {
                    strikeCount++;
                } else if (computer.contains(userInputList.get(i))) {
                    ballCount++;
                }
            }


            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            if (strikeCount == 0 && ballCount == 0) {
                System.out.println("낫싱");
            } else if (strikeCount > 0 && ballCount == 0) {
                System.out.println(strikeCount + "스트라이크");
            } else if (strikeCount == 0 && ballCount > 0) {
                System.out.println(ballCount + "볼");
            } else if (strikeCount > 0 && ballCount > 0) {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            }
        }

    }
}
