package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static class BaseBallGame {
        private List<Integer> computerNumbers;
        private List<Integer> userNumbers;
        private int[] count;
        private final Scanner scanner = new Scanner(System.in);

        public List<Integer> getComputerNumbers() {
            return computerNumbers;
        }

        public List<Integer> getUserNumbers() {
            return userNumbers;
        }

        public int[] getCount() {
            return count;
        }

        public void setComputerNumbers() {
            this.computerNumbers = makeRandomNumbers();
        }

        public void setUserNumbers() {
            this.userNumbers = inputUserNumbers();
        }

        public void setCount() {
            this.count = calculateCount();
        }

        private int[] calculateCount() {
            int[] nextCount = new int[2];
            for (int i = 0; i < 3; i++) {
                if (this.userNumbers.get(i).equals(this.computerNumbers.get(i))) {
                    nextCount[1] += 1;
                } else if (this.computerNumbers.contains(this.userNumbers.get(i))) {
                    nextCount[0] += 1;
                }
            }
            return nextCount;
        }

        private List<Integer> inputUserNumbers() {
            String[] numbers = scanner.nextLine().split("");

            checkUserNumbers(numbers);

            List<Integer> nextUserNumbers = new ArrayList<>();
            for (String numberString : numbers) {
                nextUserNumbers.add(Integer.parseInt(numberString));
            }
            return nextUserNumbers;
        }

        public void checkUserNumbers(String[] numbers) {
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

            setComputerNumbers();
            setUserNumbers();
            setCount();

        }

    }


    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.playGame();
    }
}
