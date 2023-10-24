package baseball;
import java.util.*;

public class GameManager {
    private String playerGuessedNumber;
    private GameCompititor counterPlayer;
    private GameStatus gameStatus;
    private String computerNumber;
    public GameManager(){
        this.counterPlayer = new GameCompititor();
        this.computerNumber = this.counterPlayer.generateRandomNumber();
    }

    public GameStatus processTurn(String playerNumber){
        if (this.isValidForm(playerNumber)){
            this.playerGuessedNumber = playerNumber;

            List<Integer>GameTurnResult = compareBetweenNumbers(this.playerGuessedNumber, computerNumber);

            if (GameTurnResult.get(0) == 3) {
                System.out.println("3 스트라이크");
                return GameStatus.STOP;
            }
            if (GameTurnResult.get(0) == 0 && GameTurnResult.get(1) == 0) {
                System.out.println("낫싱");
                return GameStatus.PLAYING;
            }

            if (GameTurnResult.get(1) != 0){
                System.out.print(GameTurnResult.get(1)+"볼 ");
            }
            if (GameTurnResult.get(0) != 0){
                System.out.print(GameTurnResult.get(0)+"스트라이크");
            }
            System.out.println();
        }
        else {
            throw new IllegalArgumentException();
        }
        return GameStatus.PLAYING;
    }
    public List<Integer> compareBetweenNumbers(String playerNumber, String computerNumber) {
        final int STRIKE = 0;
        final int BALL = 1;
        List<Integer> ballCount = Arrays.asList(0, 0);

        for (int i = 0; i < 3; i++) {
            char computerDigit = computerNumber.charAt(i);

            for (int j = 0; j < 3; j++) {
                char playerDigit = playerNumber.charAt(j);
                if (playerDigit == computerDigit) {
                    if (i == j) {
                        ballCount.set(STRIKE, ballCount.get(STRIKE) + 1);
                    } else {
                        ballCount.set(BALL, ballCount.get(BALL) + 1);
                    }
                }
            }
        }

        return ballCount;
    }

    public boolean isValidForm(String target){
        boolean flag = true;
        Set<Object> set = new HashSet<>();

        if (target.length() != 3){
            flag = false;
        }
        for (int i = 0; i < target.length(); i++){
            char indexValue = target.charAt(i);
            if (!Character.isDigit(indexValue) || !(('0' < indexValue)&&(indexValue <= '9')))
                flag = false;

            if(!set.add(indexValue)){
                flag = false;
            }
        }

        return flag;
    }
}
