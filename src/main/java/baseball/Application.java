package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 컴퓨터가 번호를 3개 세팅한다.
        List<Integer> computer = new ArrayList<>();
        setRandomNumberToComputer(computer);

        View view = new View();
        view.opening();
        while (true) {
            view.input();
            final String inputNumberStr = Console.readLine();
            // 입력을 제대로 못받을 경우 예외 던진다. ( 현재는 무조건 3글자만 )
            if (inputNumberStr.length() != 3) {
                throw new IllegalArgumentException("잘못된 입력값 입니다.(입력:3자리 숫자)");
            }
            Score score = getCompareResultWithInputNumberAndComputerNumber(
                    inputNumberStr, computer);
            view.score(score);
            if (score.hasWinScore()) {
                String input = Console.readLine();
                if (!List.of("1", "2").contains(input)) {
                    throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
                }
                if (Integer.parseInt(input) == 1) {
                    // 컴퓨터 번호 리셋
                    computer = new ArrayList<>();
                    setRandomNumberToComputer(computer);
                }
                if (Integer.parseInt(input) == 2) {
                    break;
                }
            }
        }
    }

    private static Score getCompareResultWithInputNumberAndComputerNumber(String inputNumberStr,
                                                                          List<Integer> computer) {
        Score score = new Score();
        for (int i = 0; i < inputNumberStr.length(); i++) {
            int inputNumberAt = Character.getNumericValue(inputNumberStr.charAt(i));
            if (computer.get(i) == inputNumberAt) {
                score.increaseStrikeCount();
            } else if (computer.contains(inputNumberAt)) {
                score.increaseBallCount();
            }
        }
        return score;
    }

    private static void setRandomNumberToComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
