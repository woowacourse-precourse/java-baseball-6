package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            GameManager gameManager = new GameManager();
            gameManager.playGame();

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            String choice = Console.readLine();
            if (Integer.parseInt(choice) != 1) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}

class GameManager {
    private int[] computerDigits;

    public GameManager() {
        computerDigits = generateRandomDigits();
    }

    public void playGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            try {
                if (isValidInput(userInput)) {
                    BallStrikeResult result = calculateBallStrike(userInput);
                    System.out.println(result.toString());

                    if (result.isGameWon()) {
                        System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                        break;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int[] generateRandomDigits() {
        int[] digits = new int[3];
        for (int i = 0; i < 3; i++) {
            digits[i] = Randoms.pickNumberInRange(1, 9);
        }
        return digits;
    }

    private boolean isValidInput(String input) {
        return input.matches("^[1-9]{3}$");
    }

    private BallStrikeResult calculateBallStrike(String input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int userDigit = Character.getNumericValue(input.charAt(i));
            int computerDigit = computerDigits[i];

            if (userDigit == computerDigit) {
                strike++;
            } else if (input.contains(String.valueOf(computerDigit))) {
                ball++;
            }
        }

        return new BallStrikeResult(ball, strike);
    }
}

class BallStrikeResult {
    private int ball;
    private int strike;

    public BallStrikeResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isGameWon() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if (strike > 0 && ball > 0) {
            return String.format("%d볼 %d스트라이크", ball, strike);
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else {
            return "낫싱";
        }
    }
}