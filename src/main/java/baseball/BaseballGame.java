package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

    //게임 시작을 알리는 문구 '숫자 야구 게임을 시작합니다'
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            if (playGame()) {
                break;
            }
        }
    }

    private static boolean playGame() {
        boolean isCondition = true;
        while (true) {
            int[] computerNumbers = generateRandomNumbers();
            System.out.print("서로 다른 3자리의 수를 입력하세요: ");
            int[] userNumbers = getUserInput();

            int strikes = 0;
            int balls = 0;

            // 컴퓨터가 랜덤으로 정한 3개의 숫자및 위치와 사용자가 input한 3개의 숫자및 위치를 비교하여 strike, balls 값 설정
            for (int i = 0; i < computerNumbers.length; i++) {
                for (int j = 0; j < userNumbers.length; j++) {
                    if (computerNumbers[i] == userNumbers[j]) {
                        if (i == j) {
                            strikes++;
                        } else {
                            balls++;
                        }
                    }
                }
            }

            if (strikes == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            } else if (strikes > 0 && balls > 0) {
                System.out.println(strikes + "스트라이크 " + balls + "볼");
            } else {
                System.out.println("낫싱");
            }

            //게임을 한번 플레이 한 후 바로 결과값 알려주고 바로 나오는 문구
            System.out.print("게임을 계속하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());

            if (choice != 1 && choice != 2) {

                //게임을 한 번 플레이 한 후 입력한 값이 1,2가 아닐때
                while (isCondition) {
                    System.out.print("올바른 형태가 아닙니다. 게임을 계속하려면 1, 종료하려면 2를 입력하세요: ");
                    int gostop = Integer.parseInt(Console.readLine()); //다시입력받음
                    if (gostop == 1) {
                        isCondition = false;
                    } else if (gostop == 2) {
                        System.out.println("게임을 종료합니다.");
                        return true;
                    }
                }
            } else if (choice == 1) { // 입력한값이 1인경우, 게임을 계속
                isCondition = false;
                continue;
            } else if (choice == 2) { // 입력한값이 2인경우, 게임 종료
                System.out.println("게임을 종료합니다.");
                return true;
            }

        }
    }

    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        Set<Integer> usedNumbers = new HashSet<>();

        while (usedNumbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            usedNumbers.add(num);
        }

        int index = 0;
        for (int num : usedNumbers) {
            numbers[index++] = num;
        }

        return numbers;
    }

    private static int[] getUserInput() {
        String input;

        while (true) {
            input = Console.readLine();
            if (input.length() != 3) {
                System.out.println("세 자리 숫자를 입력해야 합니다.");
                continue;
            }
            //  숫자가 아닌걸 찾기
            else if (!input.matches("[1-9]+")) {
                System.out.println("1이상의 숫자만 입력해야 합니다.");
                continue;
            }
            //중복된 숫자의 경우 찾기
//            else if (hasDuplicate(input)) {
            else if (!input.matches("^(?!.*(.).*\\1)[1-9]{3}$")) {
                System.out.println("중복된 숫자는 입력할 수 없습니다.");
                continue;
            }
            break;
        }

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }
        return numbers;
    }

//    private static boolean hasDuplicate(String input) {
//        char[] chars = input.toCharArray();
//        Set<Character> charSet = new HashSet<>();
//
//        for (char c : chars) {
//            if (!charSet.add(c)) {
//                return true; // 중복된 숫자가 있음
//            }
//        }
//        return false; // 중복된 숫자가 없음
//    }
}

