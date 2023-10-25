package baseball.service;

import baseball.repository.BaseballRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {
    public BaseballRepository baseballRepository = new BaseballRepository();

    public List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void startNewGame() {
        List<Integer> newNumbers = generateComputerNumber();
        baseballRepository.saveComputer(newNumbers);
    }

    public int[] getGameResult() {
        List<Integer> user = baseballRepository.getUser();
        List<Integer> computer = baseballRepository.getComputer();
        int[] result = new int[2];
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (user.get(i) == computer.get(i)) {
                strike += 1;
            } else if(computer.contains(user.get(i))){
                ball += 1;
            }
        }

        result[0] = strike;
        result[1] = ball;
        return result;
    }

    public String convertResultToString(int[] result) {
        int strike = result[0];
        int ball = result[1];
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }

    public boolean isCorrectGuess(int strike) {
        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }
}
