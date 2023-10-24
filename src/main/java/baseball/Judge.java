package baseball;

import java.util.List;

public class Judge{

    public Result getResult(ComputerNumbers computerNumber, PlayerNumbers playerNumber){
        int strike = countStrike(computerNumber, playerNumber);
        int ball = countBall(computerNumber, playerNumber, strike);
        return new Result(ball,strike);
    }

    private int countStrike(ComputerNumbers computerNumber, PlayerNumbers playerNumbers){
        int strikeCount = 0;
        for (int i = 0; i < 3; i++){
            if (computerNumber.getComputerNumbers().get(i) == playerNumbers.getPlayerNumbers().get(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(ComputerNumbers computerNumber, PlayerNumbers playerNumbers, int strike){
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

}
