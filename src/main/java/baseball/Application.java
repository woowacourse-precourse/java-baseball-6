package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

class BaseballGame {
    private static final int NUMBER_LENGTH = 3;
    private List<Integer> computerNumbers = this.generateRandomNumbers();

    public BaseballGame() {
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList();

        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public int play(int guess) {
        List<Integer> guessNumbers = this.convertToList(guess);
        if (guess >= 100 && guess <= 999) {
            int strikeCount = this.getStrikeCount(guessNumbers);
            int ballCount = this.getBallCount(guessNumbers) - strikeCount;
            if (strikeCount == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return 2;
            } else {
                if (strikeCount == 0 && ballCount == 0) {
                    System.out.println("낫싱");
                } else if (strikeCount != 0 && ballCount == 0) {
                    System.out.println("" + strikeCount + "스트라이크");
                } else if (strikeCount == 0 && ballCount != 0) {
                    System.out.println("" + ballCount + "볼");
                } else if (strikeCount != 0 && ballCount != 0) {
                    System.out.println("" + ballCount + "볼 " + strikeCount + "스트라이크");
                }

                return 1;
            }
        } else {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
    }

    private List<Integer> convertToList(int number) {
        String[] strNums = String.valueOf(number).split("");
        List<Integer> numsList = new ArrayList();
        String[] var4 = strNums;
        int var5 = strNums.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String strNum = var4[var6];
            numsList.add(Integer.parseInt(strNum));
        }

        return numsList;
    }

    private int getStrikeCount(List<Integer> guessNumbers) {
        int strike = 0;

        for(int i = 0; i < 3; ++i) {
            if (this.computerNumbers.get(i) == guessNumbers.get(i)) {
                ++strike;
            }
        }

        return strike;
    }

    private int getBallCount(List<Integer> guessNumber) {
        int count = 0;
        Iterator var3 = guessNumber.iterator();

        while(var3.hasNext()) {
            Integer num = (Integer)var3.next();
            if (this.computerNumbers.contains(num)) {
                ++count;
            }
        }

        return count;
    }

    public void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다.");
        } else {
            char[] var2 = input.toCharArray();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                char c = var2[var4];
                if (!Character.isDigit(c) || c == '0') {
                    throw new IllegalArgumentException("입력값에 1-9 범위의 숫자만 포함되어야 합니다.");
                }
            }

            if (this.hasDuplicateCharacters(input)) {
                throw new IllegalArgumentException("입력값에 중복된 숫자가 있습니다.");
            }
        }
    }

    private boolean hasDuplicateCharacters(String input) {
        return input.chars().distinct().count() != (long)input.length();
    }
}
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            BaseballGame game = new BaseballGame();
            startGame(scanner, game);
            if (!restartGame(scanner)) {
                break;
            }
        }
        scanner.close();
        System.out.println("게임을 종료합니다.");
    }

    private static void startGame(Scanner scanner, BaseballGame game) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (!playRound(scanner, game)) {
                break;
            }
        }
    }

    private static boolean playRound(Scanner scanner, BaseballGame game) {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String input = scanner.next();
            game.validateInput(input);
            return game.play(Integer.parseInt(input)) != 2;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean restartGame(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException();
        }
        switch (input) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("잘못된 입력입니다.");
                System.exit(1);
                return false;
        }
    }
}