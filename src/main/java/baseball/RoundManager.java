package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class RoundManager{

    void playGame(ComputerNumbers computerNumber){
        while (true){
            PlayerNumbers playerNumber = new PlayerNumbers(input());
            int strike = findStrike(computerNumber, playerNumber);
            int ball = findBall(computerNumber, playerNumber, strike);
            printResult(strike, ball);
            if (isAllStrike(strike)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private List<Integer> input(){
        List<Integer> inputNumbers;
        System.out.print("숫자를 입력해주세요: ");
        String numberInput = readLine();
        return stringIntoIntegerList(numberInput);
    }

    private List<Integer> stringIntoIntegerList(String inputString){
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++){
            throwIfNotNumericValue(inputString.charAt(i));
            int number = inputString.charAt(i) - '0';
            integerList.add(number);
        }
        return integerList;
    }

    private void throwIfNotNumericValue(char c){
        if(c-'0'<0||c-'0'>9){
            throw new IllegalArgumentException();
        }
    }

    private int findStrike(ComputerNumbers computerNumber, PlayerNumbers playerNumbers){
        int strikeCount = 0;
        for (int i = 0; i < 3; i++){
            if (computerNumber.getComputerNumbers().get(i) == playerNumbers.getPlayerNumbers().get(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int findBall(ComputerNumbers computerNumber, PlayerNumbers playerNumbers, int strike){
        int ballCount = 0;
        int[] visited = countExistingNumber(computerNumber.getComputerNumbers(), playerNumbers.getPlayerNumbers());
        ballCount = countSameNumber(visited) - strike;
        return ballCount;
    }

    private int[] countExistingNumber(List<Integer> computerNumber, List<Integer> userNumber){
        int[] visited = new int[10];
        for (int i = 0; i < 3; i++){
            visited[computerNumber.get(i)]++;
            visited[userNumber.get(i)]++;
        }
        return visited;
    }

    private int countSameNumber(int[] visited){
        int count = 0;
        for (int i = 1; i <= 9; i++){
            if (visited[i] == 2){
                count++;
            }
        }
        return count;
    }

    private void printResult(int strike, int ball){
        String result = printIfNothing(strike, ball) + printIfBall(ball) + printIfStrike(strike);
        System.out.println(result);
    }

    private String printIfNothing(int strike, int ball){
        if (ball == 0 && strike == 0){
            return "낫싱";
        }
        return "";
    }

    private String printIfBall(int ball){
        if (ball != 0){
            return ball + "볼 ";
        }
        return "";
    }

    private String printIfStrike(int strike){
        if (strike != 0){
            return strike + "스트라이크";
        }
        return "";
    }

    private boolean isAllStrike(int strike){
        return strike == 3;
    }

}
