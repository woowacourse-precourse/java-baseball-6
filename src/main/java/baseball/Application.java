package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static class BaseBallGame {
        private List<Integer> computerNumbers;
        private List<Integer> userNumbers;
        private int[] count;
        private final Scanner scanner;

        public BaseBallGame(InputStream inputStream) {
            this.scanner = new Scanner(inputStream);
        }

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

        public void setComputerNumbers(List<Integer> computerNumbers) {
            this.computerNumbers = computerNumbers;
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
            System.out.print("숫자를 입력해주세요 : ");
            String[] numbers = scanner.nextLine().split("");

            checkUserNumbers(numbers);

            List<Integer> nextUserNumbers = new ArrayList<>();
            for (String numberString : numbers) {
                nextUserNumbers.add(Integer.parseInt(numberString));
            }
            return nextUserNumbers;
        }

        public void checkUserNumbers(String[] numbers) {
            if (numbers.length < 1 || numbers.length > 3) {
                throw new IllegalArgumentException("정해진 수의 범위를 넘었습니다.");
            }
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

        public String getResult() {
            String result = "";

            result += this.count[0] > 0 ? String.format("%d볼 ", this.count[0]) : "";
            result += this.count[1] > 0 ? String.format("%d스트라이크", this.count[1]) : "";
            result = result.trim();

            if (result.equals("")) {
                result = "낫싱";
            }

            System.out.println(result);

            return result;
        }

        public boolean checkInningEnd() {
            if (count[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            return false;
        }

        public boolean checkExit() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int exitCode = scanner.nextInt();
            if (exitCode == 1) {
                scanner.nextLine();
                return false;
            } else if (exitCode == 2) {
                return true;
            } else {
                throw new IllegalArgumentException("종료 코드를 잘못 입력했습니다.");
            }
        }

        public void playGame() {
            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                setComputerNumbers();
                while (true) {
                    setUserNumbers();
                    setCount();
                    getResult();
                    if (checkInningEnd()) {
                        break;
                    }
                }
                if (checkExit()) {
                    break;
                }
            }
        }

    }


    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(System.in);
        baseBallGame.playGame();
    }
}
