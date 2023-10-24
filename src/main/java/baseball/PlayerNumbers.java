package baseball;

import java.util.List;

public class PlayerNumbers{

    List<Integer> playerNumbers;

    PlayerNumbers (List<Integer> playerNumbers){
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
            throw new IllegalArgumentException();
        }
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

    private void throwIfNotInRange(List<Integer> playerNumbers){
        if(isNotInRange(playerNumbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotInRange(List<Integer> playerNumbers){
        for (Integer number : playerNumbers){
            if(number<1||number>9){
                return true;
            }
        }
        return false;
    }

}
