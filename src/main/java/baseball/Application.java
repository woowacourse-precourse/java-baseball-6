package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static class BaseBallGame {
        private List<Integer> computerNumbers;
        private List<Integer> userNumbers;
        private Scanner scanner = new Scanner(System.in);

        public BaseBallGame() {
            this.computerNumbers = makeRandomNumbers();
        }

        public List<Integer> getComputerNumbers() {
            return computerNumbers;
        }

        public List<Integer> getUserNumbers() {
            return userNumbers;
        }

        private void setUserNumbers() {
            String[] numbers = scanner.nextLine().split("");

            checkUserNumbers(numbers);

            List<Integer> nextUserNumbers = new ArrayList<>();
            for (String numberString : numbers) {
                nextUserNumbers.add(Integer.parseInt(numberString));
            }
            this.userNumbers = nextUserNumbers;
        }

        private void checkUserNumbers(String[] numbers) {
            for (String number : numbers) {
                if (!number.matches("\\d")) {
                    throw new IllegalArgumentException("잘못된 수가 입력되었습니다.");
                }
            }

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

            setUserNumbers();
        }
    }


    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.playGame();
    }
}
