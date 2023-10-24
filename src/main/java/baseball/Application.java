package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        // 게임 시작 문구를 출력한다.
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 상대방(컴퓨터)의 수를 결정하는 프로그램을 작성한다.
        List<Integer> computer = createComputerNumbers();

        while(true) {

            // 숫자를 입력한다.
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();

            // 입력의 예외를 처리한다.
            inputValidCheck(inputNumber);

            // 입력의 값을 상대방의 값과 동일한 자료구조로 변환한다.
            List<Integer> guessNumbers = convertListNumber(inputNumber);

            // 입력값과 컴퓨터의 값을 비교하여 게임이 끝났는지 체크한다.
            boolean gameOver = compareNumbers(computer, guessNumbers);

            // 게임이 끝났다면(3스트라이크의 경우) 게임을 지속할 것인지, 게임을 끝낼 것인지 정한다.
            if(gameOver) {
                boolean isContinue = continueCheck();

                if(isContinue) {
                    computer = createComputerNumbers();
                } else {
                    break;
                }
            }
        }
    }

    private static List<Integer> createComputerNumbers() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static void inputValidCheck(String inputNumber) {

        // 입력숫자의 길이가 3이 아닐경우
        checkValidNumberLength(inputNumber);

        // 입력값이 숫자가 아닐경우
        checkValidNumberDigit(inputNumber);

        // 중복된 숫자가 입력이 된 경우
        checkDuplicateNumber(inputNumber);
    }

    private static void checkValidNumberLength(String inputNumber) {
        if(inputNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private static void checkValidNumberDigit(String inputNumber) {
        for(int i = 0; i < inputNumber.length(); i++) {
            if(!Character.isDigit(inputNumber.charAt(i))) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    private static void checkDuplicateNumber(String inputNumber) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < inputNumber.length(); i++) {
            int digit = inputNumber.charAt(i) - '0';
            if(set.contains(digit)) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
            set.add(digit);
        }
    }

    private static List<Integer> convertListNumber(String input) {
        List<Integer> guessNumber = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            guessNumber.add((input.charAt(i) - '0'));
        }

        return guessNumber;
    }


    private static boolean compareNumbers(List<Integer> computer, List<Integer> guessNumbers) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < guessNumbers.size(); i++) {
            if(guessNumbers.get(i) == computer.get(i)) {
                strike++;
            } else if(computer.contains(guessNumbers.get(i))) {
                ball++;
            }
        }

        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        if(strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if(strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if(ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }

        if(strike == 3) {
            return true;
        }

        return false;
    }

    private static boolean continueCheck() {

        String continueNumber = Console.readLine();

        if(continueNumber.equals("1")) {
            return true;
        } else if(!continueNumber.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }

        return false;
    }


}
