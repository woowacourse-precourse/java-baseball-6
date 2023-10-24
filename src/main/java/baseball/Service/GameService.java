package baseball.Service;

import baseball.Dto.GameResultDto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<Integer> computerNumbers;

    public void startNewGame() {
        computerNumbers = generateComputerNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public GameResultDto checkGuess(List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        return new GameResultDto(strikes, balls);
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }
}
