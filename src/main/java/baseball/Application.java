package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        for (int i = 0; i < 1; ++i) {
            Computer computer = new Computer();
            int[] computerNumber = computer.getComputerNumber();
            for (int j = 0; j < 1; ++j) {
                User user = new User();
                int input = user.usrInput();
                if (input == -1) {
                    break;
                }
                int[] userNumber = user.getUserNumber();
                Game game = new Game();

                int result = game.divideResult(computerNumber, userNumber);
                if (result == 2) {
                    break;
                } else if (result == 1) {
                    i--;
                    break;
                } else if (result == 0) {
                    j--;
                }
            }
        }
    }
}

class Arr {
    public static Boolean checkOverlap(int[] numbers, int num) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            if (num == numbers[i]) {
                return false;
            }
        }
        return true;
    }
}

class Computer {
    private final int[] computerNumber = new int[3];

    Computer() {
        this.pickRandomNumber();
    }

    private void pickRandomNumber() {
        int i = 0;
        while (i < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (Arr.checkOverlap(this.computerNumber, randomNumber)) {
                computerNumber[i] = randomNumber;
                i++;
            }
        }
    }

    public int[] getComputerNumber() {
        return this.computerNumber;
    }
}

class User {
    private final int[] userNumber = new int[3];

    private int inputNumber() {
        String number = Console.readLine();
        return checkNumber(number);
    }

    private int checkNumber(String number) {
        int inputNum = Integer.parseInt(number);
        return inputNum;
    }

    private int ciphers(int inputNum) {
        int k = 100;
        for (int i = 0; i <= 2; i++) {
            int num = inputNum / k;
            try {
                if (!Arr.checkOverlap(userNumber, num) || num == 0) {
                    throw new IllegalArgumentException("error");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return -1;
            }
            userNumber[i] = num;
            inputNum -= (num * k);
            k /= 10;
        }
        return 1;
    }

    public int usrInput() {
        System.out.print("숫자를 입력해주세요 : ");
        int inputNum = inputNumber();
        int k = ciphers(inputNum);
        if (k == -1) {
            return -1;
        }
        return 1;
    }

    public int[] getUserNumber() {
        return this.userNumber;
    }
}

class Game {
    private int ball = 0;
    private int strike = 0;

    private int compareNumbers(final int[] computerNumber, final int[] userNumber) {
        for (int i = 0; i <= 2; ++i) {
            if (Arr.checkOverlap(userNumber, computerNumber[i])) {
                continue; //ball도 아니고strike도 아니다
            } else {
                ball++;
            }
            if (computerNumber[i] == userNumber[i]) {
                ball--;
                strike++;
            }
        }
        return strike;
    }

    public int divideResult(int[] computerNumber, int[] userNumber) {
        if (compareNumbers(computerNumber, userNumber) == 3) {
            int k = this.exitOrStart();
            if (k == 2) {
                return 2;
            } else if (k == 1) {
                return 1;
            }
        } else {
            this.printResult(ball, strike);
        }
        return 0;
    }

    public int exitOrStart() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        int k = Integer.parseInt(input);
        return k;
    }

    private void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.printf("%d%s%n", ball, "볼");
        } else if (ball == 0) {
            System.out.printf("%d%s%n", strike, "스트라이크");
        } else {
            System.out.printf("%d%s %d%s%n", ball, "볼", strike, "스트라이크");
        }
    }
}
