package baseball;

import java.util.List;

public class PlayerNumbers{

    List<Integer> playerNumbers;

    PlayerNumbers(List<Integer> playerNumbers){
        throwIfInvalidLength(playerNumbers);
        throwIfDuplicated(playerNumbers);
        throwIfNotInRange(playerNumbers);
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers(){
        return playerNumbers;
    }

    private void throwIfInvalidLength(List<Integer> playerNumbers){
        if (playerNumbers.size() != 3){
            throw new IllegalArgumentException("Invalid player numbers length : Player numbers should be 3 length.");
        }
    }

    private void throwIfDuplicated(List<Integer> playerNumbers){
        if (isDuplicated(playerNumbers)){
            throw new IllegalArgumentException("Duplicated player numbers : Player numbers should not have duplicated numbers.");
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

    private void throwIfNotInRange(List<Integer> playerNumbers){
        if (isNotInRange(playerNumbers)){
            throw new IllegalArgumentException("Player numbers not in range : Player numbers should be between 1 and 9.");
        }
    }

    private boolean isNotInRange(List<Integer> playerNumbers){
        for (Integer number : playerNumbers){
            if (number < 1 || number > 9){
                return true;
            }
        }
        return false;
    }

}
