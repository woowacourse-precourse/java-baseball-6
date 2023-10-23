package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.start();
    }
}

class BaseballGame {
    private final ComputerNumberCreator computerNumberCreator = new ComputerNumberCreator();
    private final Ball ball = new Ball();
    private final Judge judge = new Judge();
    private final Result result = new Result();
    private final Message message = new Message();

    void start() {
        int retry = 1;
        message.printStartMessage();

        while (retry == 1) {
            boolean gameEnded = false;

            int[] computerNumberArray = computerNumberCreator.createComputerNumber();

            while (!gameEnded) {
                message.printInputMessage();

                Pitching pitching = new Pitching(ball);
                Referee refree = new Referee(computerNumberArray, pitching, judge);

                int[] outcome = refree.result;
                result.printResult(outcome);

                if (outcome[0] == 3) {
                    message.printEndMessage();
                    gameEnded = true;
                }
            }

            message.printRestartMessage();

            retry = Integer.parseInt(Console.readLine());

            if (retry == 2) {
                break;
            }

        }
    }
}

class Pitching {
    int[] inputNumber;

    Pitching(Ball ball) {
        int input = ball.getInputNumber();
        this.inputNumber = ball.getDigitsArray(input);
    }
}


class Ball {
    static final int NUMBER_DIGIT = 3;
    int number;

    int getInputNumber() {
        number = Integer.parseInt(Console.readLine());

        if (!Validate.verifyTripleDigit(number) || !Validate.verifyEachDigitDuplicate(number)) {
            return number;
        } else {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
        }

    }

    int[] getDigitsArray(int number) {
        int[] intArrayNumber = new int[NUMBER_DIGIT];

        for (int i = NUMBER_DIGIT - 1; i >= 0; i--) {
            intArrayNumber[i] = number % 10;
            number /= 10;
        }

        return intArrayNumber;
    }
}

class Validate {
    public static boolean verifyTripleDigit(int number) {
        return String.valueOf(number).length() != 3;
    }

    public static boolean verifyEachDigitDuplicate(int number) {
        boolean[] digitSeen = new boolean[10];

        while (number > 0) {
            int digit = number % 10;
            if (digitSeen[digit]) {
                return false;
            }
            digitSeen[digit] = true;
            number /= 10;
        }
        return true;
    }


}

class Referee {
    int[] result;

    Referee(int[] computerNumber, Pitching pitching, Judge judge) {
        this.result = judge.getResult(computerNumber, pitching.inputNumber);
    }
}

class Judge {
    int[] getResult(int[] intArrayComputerNumber, int[] intArrayInputNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (intArrayInputNumber[i] == intArrayComputerNumber[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        return new int[]{strike, ball};
    }
}

class Result {
    Message message = new Message();


    void printResult(int[] result) {
        int strike = result[0];
        int ball = result[1];

        if (strike == 3) {
            message.printStrikeCaseMessage(strike);
        } else {
            if (ball == 0 && strike == 0) {
                message.nothingCaseMessage();
            }
            if (ball > 0 && strike > 0) {
                message.printballStrikeCaseMessage(ball, strike);
            }
            if (ball > 0 && strike == 0) {
                message.printBallCaseMessage(ball);
            }
            if (strike > 0 && ball == 0) {
                message.printStrikeCaseMessage(strike);
            }
        }
    }
}

class Message {
    private static final String startMessage = "숫자 야구 게임을 시작합니다.";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String nothingCaseMessage = "낫싱";
    private static final String ballCaseMessage = "%d볼";
    private static final String strikeCaseMessage = "%d스트라이크";
    private static final String ballStrikeCaseMessage = "%d볼 %d스트라이크";
    private static final String EndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    void printStartMessage() {
        System.out.println(startMessage);
    }

    void printRestartMessage() {
        System.out.println(restartMessage);
    }

    //printInputMessage
    void printInputMessage() {
        System.out.print(inputMessage);
    }

    void nothingCaseMessage() {
        System.out.println(nothingCaseMessage);
    }

    void printBallCaseMessage(int ballCount) {
        String ballMessage = String.format(ballCaseMessage, ballCount);
        System.out.println(ballMessage);
    }

    void printStrikeCaseMessage(int strikeCount) {
        String strikeMessage = String.format(strikeCaseMessage, strikeCount);
        System.out.println(strikeMessage);
    }

    void printballStrikeCaseMessage(int ballCount, int strikeCount) {
        String ballStrikeMessage = String.format(ballStrikeCaseMessage, ballCount, strikeCount);
        System.out.println(ballStrikeMessage);
    }

    void printEndMessage() {
        System.out.println(EndMessage);
    }
}

