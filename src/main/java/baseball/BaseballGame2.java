//package baseball;
//
//import camp.nextstep.edu.missionutils.Console;
//import camp.nextstep.edu.missionutils.Randoms;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class BaseballGame2 {
//
//    /**
//     *
//     * @param args  ㅎㅎㅎㅎㅎㅎ
//     */
//    public static void main(String[] args) {
//        System.out.println("숫자 야구 게임을 시작합니다.");
//
//        while (true) {
//            if (extracted()) break;
//        }
//    }
//
//    private static boolean extracted() {
//        int[] computerNumbers = generateRandomNumbers();
//        System.out.print("서로 다른 3자리의 수를 입력하세요: ");
//        int[] userNumbers = getUserInput();
//
//        int strikes = 0;
//        int balls = 0;
//
//        for (int i = 0; i < computerNumbers.length; i++) {
//            for (int j = 0; j < userNumbers.length; j++) {
//                if (computerNumbers[i] == userNumbers[j]) {
//                    if (i == j) {
//                        strikes++;
//                    } else {
//                        balls++;
//                    }
//                }
//            }
//        }
//
//        if (strikes == 3) {
//            System.out.println("3스트라이크");
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            return true;
//        } else if (strikes > 0 || balls > 0) {
//            System.out.println(strikes + "스트라이크 " + balls + "볼");
//        } else {
//            System.out.println("낫싱");
//        }
//
//
//        // TODO 숫자 잘못입력했을때 재입력 유도
//        System.out.print("게임을 계속하려면 1, 종료하려면 2를 입력하세요: ");
//        int choice = Integer.parseInt(Console.readLine());
//        if (choice != 1 || choice != 2) {
//            while (true) {
//
//                System.out.print("게임을 계속하려면 1, 종료하려면 2를 입력하세요: ");
//                choice = Integer.parseInt(Console.readLine());
//                if (choice == 2) {
//                    return true;
//                }
//            }
//        } else if (choice == 2) {
//            System.out.println("게임을 종료합니다.");
//            return true;
//        }
//        return false;
//    }
//
//    // Hash는 중복'값'을 받지 않음,hashset=inter
//    private static int[] generateRandomNumbers() {
//        int[] numbers = new int[3];
//
//        Set<Integer> usedNumbers = new HashSet<>();
//
//        while (usedNumbers.size() < 3) {
//            int num = Randoms.pickNumberInRange(1, 9);
//            usedNumbers.add(num);
//        }
//
//        int index = 0;
//        for (int num : usedNumbers) {
//            numbers[index++] = num;
//        }
//
//        return numbers;
//    }
//
//    /**
//     *
//     * @return
//     */
//    private static int[] getUserInput() {
//        String input = Console.readLine();
//
//        // 숫자만 입력가능한걸 설명
//        if (input.length() != 3 || !input.matches("[1-9]+")) {
//            throw new IllegalArgumentException("세 자리 숫자를 입력해야 합니다.");
//        }
//
//        int[] numbers = new int[3];
//        for (int i = 0; i < 3; i++) {
//            numbers[i] = Character.getNumericValue(input.charAt(i));
//        }
//
//        return numbers;
//    }
//
//    public static class Test {
//
//    }
//}
