package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        GameManager gm = new GameManager();    //클래스 생성
        gm.startGame();    //클래스 내의 startGame 메서드를 불러옴.
    }
}

class GameManager {
    private boolean playing = true;
    private List<Integer> computer = new ArrayList<>();

    void startGame() {
        while (playing) {
            computer = NumberGenerator.generateUniqueNumbers(computer);
            //NumberGenerator 클래스의 generateUniqueNumbers 함수를 불러옴.
            System.out.print("숫자를 입력해주세요: ");
            String input = readLine();

            try {
                Preconditions.validateInput(input);    //사용자 입력 값에 대한 검사
                playing = playGame(input, computer);
                if (!playing) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String option = readLine();
                    handleGameOption(option);
                }
            } catch (IllegalArgumentException e) {
                throw e;    //예외처리
            }
        }
    }

    private void handleGameOption(String option) {
        if ("1".equals(option)) {
            resetGame();
        } else if ("2".equals(option)) {
            endGame();
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    private void resetGame() {
        computer.clear();    //컴퓨터 숫자 초기화
        playing = true;
    }

    private void endGame() {
        playing = false;
    }

    private boolean playGame(String user, List<Integer> computer) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int userDigit = user.charAt(i) - '0';
            int computerDigit = computer.get(i);

            if (userDigit == computerDigit) {
                strikes++;
            } else if (computer.contains(userDigit)) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }

        if (strikes != 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        }

        if (balls != 0 && strikes == 0) {
            System.out.println(balls + "볼");
        }

        if (strikes != 0 && balls != 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크 ");
        }

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }
}

class NumberGenerator {
    static List<Integer> generateUniqueNumbers(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

class Preconditions {
    static void validateInput(String input) {
        try {
            if (input.length() != 3) {
                throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
            }

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (input.charAt(i) == input.charAt(j)) {
                        throw new IllegalArgumentException("입력한 숫자에 중복이 있습니다.");
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                char digit = input.charAt(i);
                if (digit < '1' || digit > '9') {
                    throw new IllegalArgumentException("1~9까지의 숫자를 입력해주세요.");
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
