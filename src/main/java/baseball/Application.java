package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    static boolean[] isNumberUsedComputer;
    static List<Integer> computerNumbers;
    static List<Integer> userNumbers;
    static int strikeCnt,ballCnt;
    static final int NUMBER_COUNT = 3;

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean playAgain = true;

        while (playAgain) {
            playAgain=playRound();
        }

        System.out.println("게임을 종료합니다.");

    }

    private static boolean playRound() {

        setComputerNumbers();

        boolean isFinished = false;

        while(!isFinished){
            setUserNumbers();
            isFinished=evaluateGuess();
        }

        return restart();
    }

    private static void setUserNumbers() {
        try {
            userNumbers = inputNumberOfUser();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    private static List<Integer> inputNumberOfUser() {
        System.out.print("숫자를 입력해주세요 : ");

        String inputStr = Console.readLine();
        if (!isNumber(inputStr))
            throw new IllegalArgumentException("숫자가 아닙니다.");

        int number = Integer.parseInt(inputStr);
        List<Integer> userNumber = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            userNumber.add(number % 10);
            number /= 10;
        }

        if (!areDistinctNumbers(userNumber))
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다. ");

        return userNumber;
    }

    private static void setComputerNumbers() {
        computerNumbers = generateRandomNumbers();
        markNumberUsed(computerNumbers);
    }

    private static boolean evaluateGuess() {
         strikeCnt = 0;
         ballCnt = 0;

        for (int index = 0; index < 3; index++) {
            int userNumber = userNumbers.get((userNumbers.size() - 1) - index);
            int computerNumber = computerNumbers.get(index);

            checkStrikeAndBall(userNumber,computerNumber);
        }

        if (isFinish(strikeCnt, ballCnt)) {
            return false;
        }
        return true;
    }

    private static void checkStrikeAndBall(int userNumber, int computerNumber) {
        if (isStrike(userNumber, computerNumber)) {
            strikeCnt++;
            return;
        }
        if (isBall(userNumber))
            ballCnt++;
    }

    private static boolean restart() {
        String restartGameInput = Console.readLine();

        if (restartGameInput.equals("2"))
            return false;
        if (restartGameInput.equals("1"))
            return true;
        throw new IllegalArgumentException("범위 밖의 입력입니다. 1과 2중 입력해 주세요");
    }

    private static boolean isFinish(int strikeCnt, int ballCnt) {
        if (strikeCnt == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (strikeCnt + ballCnt == 0) {
            System.out.println("낫싱");
            return false;
        }

        StringBuilder sb = new StringBuilder();

        if (ballCnt != 0)
            sb.append(ballCnt + "볼 ");
        if (strikeCnt != 0) {
            sb.append(strikeCnt + "스트라이크 ");
        }

        System.out.println(sb.toString());
        return false;

    }

    private static boolean isBall(int userNumber) {
        return isNumberUsedComputer[userNumber];
    }

    private static boolean isStrike(int userNumber, int computerNumber) {
        return userNumber == computerNumber;
    }

    private static boolean isNumber(String inputString) {
        return inputString.matches("\\d+");
    }
    
    private static boolean areDistinctNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == NUMBER_COUNT;
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            addUniqueNumber(computerNumbers, randomNumber);
        }
        return computerNumbers;
    }

    private static void addUniqueNumber(List<Integer> numbers, int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    private static void markNumberUsed(List<Integer> computerNumber) {
        isNumberUsedComputer = new boolean[10];
        for (int index = 0; index < 3; index++)
            isNumberUsedComputer[computerNumber.get(index)] = true;
    }

}