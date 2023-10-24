package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballApp{

    void run(){
        while (true){
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computerNumber = createComputerRandomNumber();
            playGame(computerNumber);
            if (terminate()){
                break;
            }
        }
    }

    private static List<Integer> createComputerRandomNumber(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(number)){
                randomNumbers.add(number);
            }
        }
        return randomNumbers;
    }

    private static void playGame(List<Integer> computerNumber){
        while (true){
            List<Integer> userNumber = input();
            int strike = findStrike(computerNumber, userNumber);
            int ball = findBall(computerNumber, userNumber, strike);
            printResult(strike, ball);
            if (isAllStrike(strike)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> input(){
        List<Integer> inputNumbers;
        System.out.print("숫자를 입력해주세요: ");
        String numberInput = readLine();
        throwIfInvalidNumberInput(numberInput);
        inputNumbers = stringIntoIntegerList(numberInput);
        return inputNumbers;
    }

    private static void throwIfInvalidNumberInput(String inputString){
        if (isNotThreeDigits(inputString) || isDuplicated(inputString) || isNotInRange(inputString)){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotThreeDigits(String inputString){
        return inputString.length() != 3;
    }

    private static boolean isDuplicated(String inputString){
        int[] visited = new int[10];
        for (int i = 0; i < inputString.length(); i++){
            int number = inputString.charAt(i) - '0';
            if (visited[number] != 0){
                return true;
            }
            visited[number]++;
        }
        return false;
    }

    private static boolean isNotInRange(String inputString){
        for (int i = 0; i < inputString.length(); i++){
            int number = inputString.charAt(i) - '0';
            if (number < 1 || number > 9){
                return true;
            }
        }
        return false;
    }

    private static List<Integer> stringIntoIntegerList(String inputString){
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++){
            integerList.add(inputString.charAt(i) - '0');
        }
        return integerList;
    }

    private static int findStrike(List<Integer> computerNumber, List<Integer> userNumber){
        int strikeCount = 0;
        for (int i = 0; i < 3; i++){
            if (computerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static int findBall(List<Integer> computerNumber, List<Integer> userNumber, int strike){
        int ballCount = 0;
        int[] visited = countExistingNumber(computerNumber, userNumber);
        ballCount = countSameNumber(visited) - strike;
        return ballCount;
    }

    private static int[] countExistingNumber(List<Integer> computerNumber, List<Integer> userNumber){
        int[] visited = new int[10];
        for (int i = 0; i < 3; i++){
            visited[computerNumber.get(i)]++;
            visited[userNumber.get(i)]++;
        }
        return visited;
    }

    private static int countSameNumber(int[] visited){
        int count = 0;
        for (int i = 1; i <= 9; i++){
            if (visited[i] == 2){
                count++;
            }
        }
        return count;
    }

    private static void printResult(int strike, int ball){
        String result = printIfNothing(strike, ball) + printIfBall(ball) + printIfStrike(strike);
        System.out.println(result);
    }

    private static String printIfNothing(int strike, int ball){
        if (ball == 0 && strike == 0){
            return "낫싱";
        }
        return "";
    }

    private static String printIfBall(int ball){
        if (ball != 0){
            return ball + "볼 ";
        }
        return "";
    }

    private static String printIfStrike(int strike){
        if (strike != 0){
            return strike + "스트라이크";
        }
        return "";
    }

    private static boolean isAllStrike(int strike){
        return strike == 3;
    }

    private static boolean terminate(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String exitInput = readLine();
        throwIfInvalidExitInput(exitInput);
        return exitInput.equals("2");
    }

    private static void throwIfInvalidExitInput(String exitInput){
        if (!exitInput.equals("1") && !exitInput.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}
