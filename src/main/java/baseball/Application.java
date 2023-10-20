package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static class BaseBallGame {
        private List<Integer> computerNumbers;

        public BaseBallGame() {
            this.computerNumbers = makeRandomNumbers();
        }

        public List<Integer> getComputerNumbers() {
            return computerNumbers;
        }

        private List<Integer> makeRandomNumbers() {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            return computer;
        }

        public void playGame() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

    }


    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.playGame();
    }
}
