package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computer = generateRandomNumbers();

            boolean isGameFinished = false;
            int tries = 0;

            while (!isGameFinished) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if (!isValidInput(input)) {
                    // 잘못된 입력이 들어온 경우 예외를 던지고 프로그램 종료
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                List<Integer> userGuess = parseUserGuess(input);
                int strikes = countStrikes(computer, userGuess);
                int balls = countBalls(computer, userGuess);

                if (strikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isGameFinished = true;
                } else if (strikes == 0 && balls == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(formatResult(strikes, balls));
                }
                tries++;
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());
            if (choice == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }

    // 랜덤한 3자리 숫자를 생성하여 반환
    private static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 사용자 입력이 유효한지 검사 (3자리 서로 다른 숫자인지 확인)
    private static boolean isValidInput(String input) {
        return input.matches("^[1-9]{3}$");
    }

    // 사용자 입력을 3개의 정수로 파싱하여 리스트로 반환
    private static List<Integer> parseUserGuess(String input) {
        List<Integer> userGuess = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            userGuess.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        return userGuess;
    }

    // 스트라이크 개수 계산
    private static int countStrikes(List<Integer> computer, List<Integer> userGuess) {
        int strikes = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(userGuess.get(i)) && strikes < 3) {
                strikes++;
            }
        }
        if (strikes == 3) {
            System.out.println("3스트라이크");
        }
        return strikes;
    }

    // 볼 개수 계산
    private static int countBalls(List<Integer> computer, List<Integer> userGuess) {
        int balls = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(userGuess.get(i)) && !computer.get(i).equals(userGuess.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    // 볼과 스트라이크 개수에 따라 결과 메시지를 생성하고 반환
    private static String formatResult(int strikes, int balls) {
        String result = "";
        if (balls > 0) {
            result += balls + "볼 ";
        }
        if (strikes > 0) {
            result += strikes + "스트라이크";
        }
        return result.trim();
    }
}
