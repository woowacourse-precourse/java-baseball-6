//package baseball;
//
//import camp.nextstep.edu.missionutils.Console;
//import java.util.List;
//
//public class BaseballApplication {
//
//    private BaseballApplication() {
//    }
//
//    public static void turnOn() {
//        System.out.println("숫자 야구 게임을 시작합니다.");
//        game();
//    }
//
//    private static void game() {
//        List<Integer> number = NumberGenerator.numberGenerating();
//        boolean isGameOn = true;
//        boolean coin = false;
//        Boolean[] onAndCoin = {isGameOn, coin};
//
//        while (onAndCoin[0]) {
//
//            System.out.println("숫자를 입력해주세요 :");
//            String userNumber = Console.readLine();
//
//            if (!judgeException(userNumber)) {
//                break;
//            }
//
//            judgeNumber(number, userNumber, onAndCoin);
//
//            if (onAndCoin[1]) {
//                number = NumberGenerator.numberGenerating();
//                onAndCoin[1] = false;
//            }
//
//        }
//
//    }
//
//    private static boolean judgeException(String userNumber) {
//        if (userNumber.length() != 3 || !userNumber.matches("\\d+")) {
//            throw new IllegalArgumentException("!!IllegalArgumentException!!");
//        }
//        return true;
//    }
//
//    private static void judgeException() {
//        throw new IllegalArgumentException("!!IllegalArgumentException!!");
//    }
//
//    private static void judgeNumber(List<Integer> number, String userNumber, Boolean[] onAndCoin) {
//        int[] check = new int[10];
//        int strike = 0;
//        int convertedUser = Integer.parseInt(userNumber);
//        int divide = 10;
//        int ball = 0;
//
//        for (int i = 2; i >= 0; i--) {
//            int temp = convertedUser % divide;
//            check[temp]++;
//            check[number.get(i)]++;
//            if (temp == number.get(i)) {
//                strike++;
//            }
//            convertedUser /= divide;
//        }
//        for (int i : check) {
//            if (i == 2) {
//                ball++;
//            }
//        }
//        call(new int[]{strike, ball - strike}, onAndCoin);
//    }
//
//    private static void call(int[] bns, Boolean[] onAndcoin) {
//        if (bns[0] == 0 && bns[1] == 0) {
//            System.out.println("낫싱");
//        } else if (bns[1] == 0) {
//            System.out.printf("3스트라이크\n" +
//                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            newOrStop(onAndcoin);
//        } else if (bns[0] == 0) {
//            System.out.println("3볼");
//        } else if (bns[0] != 0 && bns[1] != 0) {
//            System.out.println(bns[1] + "볼 " + bns[0] + "스트라이크");
//        }
//    }
//
//    private static void newOrStop(Boolean[] onAndcoin) {
//        String userAnswer = Console.readLine();
//        if (userAnswer.equals("1")) {
//            onAndcoin[1] = true;
//        } else if (userAnswer.equals("2")) {
//            onAndcoin[0] = false;
//        } else {
//            judgeException();
//            onAndcoin[0] = false;
//        }
//    }
//}



