package baseball.game;

import java.util.List;

public class BaseballGame {

    private static Computer computer;
    private static User user;

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        List<Integer> computerNumber = computer.createComputerNumber();
        user.createUserNumber();
        computer.compareEachNumber();
        computer.createResultMessage();
        computer.checkResult();
        computer.decideGameEndAndRestart();

//        public static void Game() {
//            while (true) {
//
//                while (true) {
//                    System.out.print("숫자를 입력해주세요 : ");
//                    String userNumberString = Console.readLine();
//
//                    ArrayList<Integer> userNumber = validateUserNumber(userNumberString);
//
//                    int strike = 0;
//                    int ball = 0;
//
//                    for (int i = 0; i < 3; i++) {
//                        if (computerNumber.get(i).equals(userNumber.get(i))) {
//                            strike++;
//                        }
//                    }
//
//                    for (int number : userNumber) {
//                        if (computerNumber.contains(number)) {
//                            ball++;
//                        }
//                    }
//                    ball -= strike;
//
//                    if (ball != 0) {
//                        System.out.printf(ball + "볼 ");
//                    }
//                    if (strike != 0) {
//                        System.out.printf(strike + "스트라이크");
//                    }
//                    if (ball == 0 && strike == 0) {
//                        System.out.print("낫싱");
//                    }
//                    System.out.println();
//
//                    if (strike == 3) {
//                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//                        String restartOrExit = Console.readLine();
//                        validateRestartOrExitNumber(restartOrExit);
//                        if (restartOrExit.equals("1")) {
//                            break;
//                        } else if (restartOrExit.equals("2")) {
//                            return;
//                        }
//                    }
//                }
//            }
//        }
//
//        private static void validateRestartOrExitNumber(String restartOrExit) {
//            if (!restartOrExit.equals("1") && !restartOrExit.equals("2")) {
//                throw new IllegalArgumentException("게임 재시작 또는 종료 입력이 잘못되었습니다.");
//            }
//        }
//
//        public static ArrayList<Integer> validateUserNumber(String inputNumber) {
//            ArrayList<Integer> userNumber = new ArrayList<>();
//            for (int i = 0; i < inputNumber.length(); i++) {
//                char numberChar = inputNumber.charAt(i);
//                if (!Character.isDigit(numberChar)) {
//                    throw new IllegalArgumentException("숫자가 아닌 입력이 포함되어 있습니다.");
//                }
//                userNumber.add((int) numberChar-'0');
//            }
//
//            if (userNumber.size() != 3) {
//                throw new IllegalArgumentException("입력숫자가 3자리가 아닙니다.");
//            }
//
//            Set<Integer> set = new HashSet<>(userNumber);
//            if (set.size() != userNumber.size()) {
//                throw new IllegalArgumentException("중복되는 숫자가 포함되어 있습니다.");
//            }
//
//            for (int number : userNumber) {
//                if (number == 0) {
//                    throw new IllegalArgumentException("입력숫자에 0이 포함되어 있습니다.");
//                }
//            }
//            return userNumber;
//        }
    }
}
