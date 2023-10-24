package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int NUMBER_COUNT = 3;
    public static int strike, ball;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        numberBaseballGameStart();
    }

    public static void numberBaseballGameStart() {
        initData();

        try {
            List<Integer> computerNumbers = inputComputerNumbers();

            validNumbers(computerNumbers);
            countStrike(computerNumbers);

            System.out.println(NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            ReStart();
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("게임이 종료되었습니다");
        }
    }

    public static void countStrike(List<Integer> computerNumbers) {
        while(strike!=NUMBER_COUNT) {

            List<Integer> playerNumbers = inputPlayerNumbers();
            validNumbers(playerNumbers);
            compareNumbers(computerNumbers, playerNumbers);

        }
    }
    public static void ReStart() {
        System.out.println("게임을 새로 시작려면 1, 종료하려면 2를 입력하세요.");

        String reStartNumber = Console.readLine();
        validInputNumber(reStartNumber);

        if (reStartNumber.equals("1")) {
            numberBaseballGameStart();
            return;
        }
        System.out.println("게임이 종료되었습니다.");
    }

    public static List<Integer> inputComputerNumbers() {

        List<Integer> computer = new ArrayList<>();

        while(computer.size()<NUMBER_COUNT) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

                if(!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }

        }
        return computer;
    }

    public static List<Integer> inputPlayerNumbers() {
        List<Integer> playerNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");

        String player = Console.readLine().replaceAll(" ", "");

        for(int i=0; i<player.length(); i++) {
            playerNumbers.add(player.charAt(i) - '0');
        }

        return playerNumbers;
    }

    public static void compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        initData();

        for(int i=0; i<NUMBER_COUNT; i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
                continue;
            }
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        System.out.println(printResult());
    }

    public static String printResult() {
        if(ball == 0 && strike == 0) {
            return "낫싱";
        }
        if(ball == 0) {
            return strike + "스트라이크";
        }
        if(strike==0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public static void initData() {
        strike = 0;
        ball = 0;
    }

    public static void validNumbers(List<Integer> numbers) {
        if(numbers == null) {
            throw new IllegalArgumentException();
        }
        if(numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
        if(checkDuplicateNumber(numbers, 0, 0)) {
            throw new IllegalArgumentException();
        }
        if(checkOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validInputNumber(String InputNumber) {

        if(!InputNumber.equals("1") && !InputNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkDuplicateNumber(
            List<Integer> numbers,
            int numbersIdx,
            int checkNumberIdx
    ) {
        while(numbersIdx != numbers.size()) {
            int searchNumber = numbers.get(numbersIdx);
            int checkNumber = numbers.get(checkNumberIdx);

            if(numbersIdx == checkNumberIdx) {
                numbersIdx++;
                continue;
            }
            if(checkNumberIdx == numbers.size()-1) {
                checkNumberIdx = 0;
                numbersIdx++;
            }
            if(searchNumber == checkNumber) {
                return true;
            }
            checkNumberIdx++;
        }
        return false;
    }

    public static boolean checkOutOfRangeNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number.equals(0)) {
                return true;
            }
        }
        return false;
    }
}
