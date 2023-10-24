package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private int[] computerNumber;
    private boolean isGameOver;

    public Application() {
        computerNumber = generateComputerNumber();
        isGameOver = false;
    }

    private static int[] generateComputerNumber() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int number;
            do {
                number = Randoms.pickNumberInRange(1, 9);
            } while (contains(numbers, number));
            numbers[i] = number;
        }
        return numbers;
    }

    private static boolean contains(int[] numbers, int number) {
        for (int num : numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    private int[] getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }

        int[] userGuess = new int[3];
        for (int i = 0; i < 3; i++) {
            userGuess[i] = Character.getNumericValue(input.charAt(i));
//            if (userGuess[i] < 1 || userGuess[i] > 9) {
//                throw new IllegalArgumentException("입력은 1에서 9 사이의 숫자여야 합니다.");
//            }
        }
        return userGuess;
    }

    private void checkGuess(int[] userGuess) {
        if (!isValidInput(userGuess)) {
            throw new IllegalArgumentException();
        }

        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (userGuess[i] == computerNumber[i]) {
                strikes++;
            } else if (containsNumber(userGuess[i])) {
                balls++;
            }
        }

        if (strikes == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isGameOver = true;
        } else if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            String output = "";
            if (balls > 0 && strikes == 0) {
                output += balls + "볼";
            } else if (balls > 0) {
                output += balls + "볼 ";
            }
            if (strikes > 0) {
                output += strikes + "스트라이크";
            }
            System.out.println(output);
        }
    }

    private boolean containsNumber(int number) {
        for (int digit : computerNumber) {
            if (digit == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidInput(int[] userGuess) {
        if (userGuess.length != 3) {
            return false; // 입력 길이가 3이 아닌 경우
        }
        for (int i = 0; i < 3; i++) {
            if (userGuess[i] < 1 || userGuess[i] > 9) {
                return false; // 1에서 9 사이의 숫자가 아닌 경우
            }
            for (int j = i + 1; j < 3; j++) {
                if (userGuess[i] == userGuess[j]) {
                    return false; // 중복된 숫자가 있는 경우
                }
            }
        }
        return true;
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!isGameOver) {
            int[] userGuess = getUserInput();
            checkGuess(userGuess);
        }
    }

    public static void main(String[] args) {
        Application game = new Application();
        game.play();

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        if (choice == 1) {
            main(args);
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }
}

//public class Application {
//
//    private int[] computerNumber;
//    private boolean isGameOver;
//
//    public Application() {
//        computerNumber = generateComputerNumber();
//        isGameOver = false;
//    }
//
//    private static int[] generateComputerNumber() {
//        int[] numbers = new int[3];
//        for (int i = 0; i < 3; i++) {
//            int number;
//            do {
//                number = Randoms.pickNumberInRange(1, 9);
//            } while (contains(numbers, number));
//            numbers[i] = number;
//        }
//        return numbers;
//    }
//
//    private static boolean contains(int[] numbers, int number) {
//        for (int num : numbers) {
//            if (num == number) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private int[] getUserInput() {
//        System.out.print("숫자를 입력해주세요 : ");
//        String input = Console.readLine();
//        int[] userGuess = new int[3];
//        for (int i = 0; i < 3; i++) {
//            userGuess[i] = Character.getNumericValue(input.charAt(i));
//        }
//        return userGuess;
//    }
//
//    private void checkGuess(int[] userGuess) {
//        if (!isValidInput(userGuess)) {
//            throw new IllegalArgumentException();
//        }
//
//        int strikes = 0;
//        int balls = 0;
//        for (int i = 0; i < 3; i++) {
//            if (userGuess[i] == computerNumber[i]) {
//                strikes++;
//            } else if (containsNumber(userGuess[i])) {
//                balls++;
//            }
//        }
//
//        if (strikes == 3) {
//            System.out.println("3스트라이크");
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            isGameOver = true;
//        } else if (strikes == 0 && balls == 0) {
//            System.out.println("낫싱");
//        } else {
//            String output = "";
//            if (balls > 0 && strikes == 0) {
//                output += balls + "볼";
//            } else if (balls > 0) {
//                output += balls + "볼 ";
//            }
//            if (strikes > 0) {
//                output += strikes + "스트라이크";
//            }
//            System.out.println(output);
//        }
//    }
//
//    private boolean containsNumber(int number) {
//        for (int digit : computerNumber) {
//            if (digit == number) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isValidInput(int[] userGuess) {
//        if (userGuess.length != 3) {
//            return false;
//        }
//        for (int i = 0; i < 3; i++) {
//            for (int j = i + 1; j < 3; j++) {
//                if (userGuess[i] == userGuess[j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public void play() {
//        System.out.println("숫자 야구 게임을 시작합니다.");
//
//        while (!isGameOver) {
//            int[] userGuess = getUserInput();
//            checkGuess(userGuess);
//        }
//    }
//
//    public static void main(String[] args) {
//        Application game = new Application();
//        game.play();
//
//        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//        int choice = Integer.parseInt(Console.readLine());
//        if (choice == 1) {
//            main(args);
//        } else {
//            System.out.println("게임을 종료합니다.");
//        }
//    }
//}