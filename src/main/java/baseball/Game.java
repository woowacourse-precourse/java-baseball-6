package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Integer> answer;

    public void playGame() {
        answer = makeAnswer();

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException("사용자가 잘못된 값을 입력했습니다.");
            }

            List<Integer> userGuess = Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            String result = CalculateResult.calculateResult(answer, userGuess);
            System.out.println(result);

            if (userGuess.equals(answer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private List<Integer> makeAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
