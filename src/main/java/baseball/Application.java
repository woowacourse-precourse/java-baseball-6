package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            playGame();
            if (!wantsToPlayAgain()) {
                break;
            }
        }
    }

    private static void playGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            try {

                if (!isNumeric(userInput)) {
                    throw new IllegalArgumentException("숫자가 아닙니다.");
                }

                if (userInput.length() != 3) {
                    throw new IllegalArgumentException("입력한 숫자는 3자리가 아닙니다.");
                }



                List<Integer> userNumbers = parseInput(userInput); // 사용자 입력을 정수로 변환
                int[] result = calculateResult(computer, userNumbers); // calculateResult 의 결과를 result 에 저장

                if (result[0] == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    displayResult(result);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
                throw e;
            }

        }
    }

    private static List<Integer> parseInput(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char digitChar = userInput.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            userNumbers.add(digit);
        }
        return userNumbers;
    }

    private static int[] calculateResult(List<Integer> computer, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(userNumbers.get(i))) {
                strikes++;
            } else if (computer.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }

    private static void displayResult(int[] result) {
        int strikes = result[0];
        int balls = result[1];

        if (strikes > 0 && balls > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else if (strikes > 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls > 0) {
            System.out.println(balls + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    private static boolean wantsToPlayAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        return choice == 1;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
