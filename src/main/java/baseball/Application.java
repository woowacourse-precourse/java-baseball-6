package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();

        while (true) {
            boolean gameWon = false;

            System.out.println("숫자 야구 게임을 시작합니다.");
            int targetNum = computer.generateRandomNumber();

            while (!gameWon) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = readLine();

                try {
                    if (isValidInput(userInput)) {
                        int guess = Integer.parseInt(userInput);
                        int result = checkGuess(targetNum, guess);
                        int strikes = result / 10;
                        int balls = result % 10;

                        if (strikes == 3) {
                            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                            gameWon = true;
                        }
                        else if (result == 0) {
                            System.out.println("낫싱");
                        }
                        else {
                            if (strikes == 0) {
                                System.out.println(balls + "볼");
                            }
                            else if (balls == 0) {
                                System.out.println(strikes + "스트라이크");
                            }
                            else {
                                System.out.println(balls + "볼 " + strikes + "스트라이크");
                            }
                        }
                    }
                    else {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                    return;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String playAgain = readLine().toLowerCase();

            if (!playAgain.equals("1")) {
                break;
            }
        }
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private static int checkGuess(int target, int guess) {
        String targetStr = Integer.toString(target);
        String guessStr = Integer.toString(guess);
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (targetStr.charAt(i) == guessStr.charAt(i)) {
                strikes++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (targetStr.contains(String.valueOf(guessStr.charAt(i))) && targetStr.charAt(i) != guessStr.charAt(i)) {
                balls++;
            }
        }

        return (strikes * 10) + balls;
    }
}