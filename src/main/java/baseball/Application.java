import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private List<Integer> computerNumbers;

    public Application() {
        generateComputerNumbers();
    }

    private void generateComputerNumbers() {
        computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다. 1부터 9까지 서로 다른 수로 이루어진 3자리 숫자를 맞춰보세요.");

        while (true) {
            List<Integer> userGuess = getUserGuess();
            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (userGuess.get(i).equals(computerNumbers.get(i))) {
                    strikes++;
                } else if (computerNumbers.contains(userGuess.get(i))) {
                    balls++;
                }
            }

            if (strikes == 3) {
                System.out.println("3스트라이크! 게임 종료.");
                if (askForRestart()) {
                    generateComputerNumbers();
                } else {
                    System.out.println("게임 종료.");
                    break;
                }
            } else if (strikes > 0 || balls > 0) {
                System.out.println(balls + "볼 " + strikes + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
        }
    }

    private List<Integer> getUserGuess() {
        while (true) {
            System.out.print("3자리 숫자를 입력하세요: ");
            String input = Console.readLine();

            try {
                List<Integer> userGuess = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    char inputChar = input.charAt(i);
                    int number = Character.getNumericValue(inputChar);
                    if (number < 1 || number > 9 || userGuess.contains(number)) {
                        throw new IllegalArgumentException("잘못된 입력입니다. 1부터 9까지 서로 다른 수로 이루어진 3자리 숫자를 입력해야 합니다.");
                    }
                    userGuess.add(number);
                }
                return userGuess;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다. 1부터 9까지 서로 다른 수로 이루어진 3자리 숫자를 입력해야 합니다.");
            }
        }
    }

    private boolean askForRestart() {
        while (true) {
            System.out.print("게임을 다시 시작하시겠습니까? (1: 재시작, 2: 종료): ");
            String input = Console.readLine();

            try {
                int choice = Integer.parseInt(input);
                if (choice == 1) {
                    return true;
                } else if (choice == 2) {
                    return false;
                } else {
                    System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
            }
        }
    }

    public static void main(String[] args) {
        Application game = new Application();
        game.play();
    }
}
