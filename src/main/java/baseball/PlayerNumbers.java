package baseball;

import java.util.List;

public class PlayerNumbers{

    List<Integer> playerNumbers;

    PlayerNumbers (List<Integer> playerNumbers){
        throwIfInvalidLength(playerNumbers);
        throwIfDuplicated(playerNumbers);
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers(){
        return playerNumbers;
    }

    private void throwIfInvalidLength(List<Integer> playerNumbers){
        if (isNotThreeDigits(playerNumbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotThreeDigits(List<Integer> playerNumbers){
        return playerNumbers.size() != 3;
    }

    private void throwIfDuplicated(List<Integer> playerNumbers){
        if (isDuplicated(playerNumbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> playerNumbers){
        int[] visited = new int[10];
        for (int number : playerNumbers){
            if (visited[number] != 0){
                return true;
            }
            visited[number]++;
        }
        return false;
    }

}
