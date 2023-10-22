package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int validateStrike(List<Integer> computer, List<Integer> player) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(player.get(i))) strikeCount++;
        }
        return strikeCount;
    }

    private static int validateBall(List<Integer> computer, List<Integer> player) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i).equals(player.get(j)) && i != j) ballCount++;
            }
        }
        return  ballCount;
    }

    public static void main(String[] args) {

        // 컴퓨터가 서로 다른 3자리를 뽑는 기능
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> player = InputConverter.convert(Console.readLine());

            int strikeCount = validateStrike(computer, player);
            int ballCount = validateBall(computer, player);

            if (ballCount > 0) {
                System.out.print(ballCount + "볼 ");
            }
            if (strikeCount > 0) {
                System.out.print(strikeCount + "스트라이크");
            }
            if (ballCount == 0 && strikeCount == 0) {
                System.out.print("낫싱");
            }
            System.out.println();

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

    }

}
