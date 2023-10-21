package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application{

    public static void main(String[] args){
        startGame();
        List<Integer> computerNumber = createComputerRandomNumber();
        playGame(computerNumber);

    }

    private static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
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
        List<Integer> userNumber = input();
        int strike = findStrike(computerNumber, userNumber);
        int ball = findBall(computerNumber,userNumber,strike);
    }

    private static List<Integer> input(){
        List<Integer> inputNumbers;
        System.out.print("숫자를 입력해주세요: ");
        String inputString = readLine();
        throwIfInvalidInputString(inputString);
        inputNumbers = stringIntoIntegerList(inputString);
        return inputNumbers;
    }

    private static void throwIfInvalidInputString(String inputString){
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
        for(int i=0;i<3;i++){
            if(computerNumber.get(i)==userNumber.get(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static int findBall(List<Integer> computerNumber, List<Integer> userNumber, int strike){
        int ballCount = 0;
        int[] visited = countExistingNumber(computerNumber,userNumber);
        ballCount = countSameNumber(visited)-strike;
        return ballCount;
    }

    private static int[] countExistingNumber(List<Integer> computerNumber, List<Integer> userNumber){
        int[] visited = new int[10];
        for(int i=0;i<3;i++){
            visited[computerNumber.get(i)]++;
            visited[userNumber.get(i)]++;
        }
        return visited;
    }

    private static int countSameNumber(int[] visited){
        int count = 0;
        for(int i=1;i<=9;i++){
            if(visited[i]==2){
                count++;
            }
        }
        return count;
    }

}
