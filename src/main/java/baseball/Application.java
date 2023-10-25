package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    static boolean[] isNumberUsedComputer;

    public static void main(String[] args) {

        startPrint();

        List<Integer> computerNumbers = generateRandomNumbers();
        markNumberUsed(computerNumbers);

        while (true) {
            List<Integer> userNumbers;
            int strikeCnt = 0;
            int ballCnt = 0;

            try {
                userNumbers = inputNumberOfUser();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                break;
            }

            for (int index = 0; index < 3; index++) {
                int userNumber = userNumbers.get((userNumbers.size() - 1) - index);
                int computerNumber = computerNumbers.get(index);

                if (isStrike(userNumber, computerNumber)) {
                    strikeCnt++;
                    continue;
                }
                if (isBall(userNumber, computerNumber))
                    ballCnt++;
            }

           

        }
        System.out.println("게임을 종료합니다.");

    }

    private static boolean isFinish(int strikeCnt, int ballCnt) {
        if(strikeCnt==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if(strikeCnt+ballCnt==0){
            System.out.println("낫싱");
            return false;
        }
        if(ballCnt!=0)
            sb.append(ballCnt+"볼 ");
        if(strikeCnt!=0) {
            sb.append(strikeCnt+"스트라이크 ");
        }

        System.out.println(sb.toString());
        return false;

    }

    private static boolean isBall(int userNumber, int computerNumber) {
        return isNumberUsedComputer[userNumber];
    }

    private static boolean isStrike(int userNumber, int computerNumber) {
        return userNumber == computerNumber;
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

    private static boolean isNumber(String inputString) {
        return inputString.matches("\\d+");
    }

    private static void startPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static boolean areDistinctNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private static void markNumberUsed(List<Integer> computerNumber) {
        isNumberUsedComputer = new boolean[10];
        for (int index = 0; index < 3; index++)
            isNumberUsedComputer[computerNumber.get(index)] = true;
    }


}