package baseball;

import baseball.Exception.InputConverter;
import baseball.view.ResultView;
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
        return ballCount;
    }
    private static List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;

    }
    public static void main(String[] args) {

        while (true) {

            List<Integer> computer = generateRandomNumber();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> player = InputConverter.convert(Console.readLine());

                int strikeCount = validateStrike(computer, player);
                int ballCount = validateBall(computer, player);

                ResultView.printOutput(ballCount, strikeCount);

                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

            String exitNum = Console.readLine();

            if ("2".equals(exitNum)) {
                break;
            }
        }
    }
}