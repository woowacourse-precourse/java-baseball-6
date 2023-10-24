package baseball;

public class GameManager {
    private String playerGuessedNumber;
    private GameCompititor counterPlayer;
    private GameStatus gameStatus;

    public GameManager(){
        this.computerGuessedNumber = new GameCompititor();
    }

    public GameStatus processTurn(String playerNumber){
        if (this.isValidForm(playerNumber)){
            this.playerGuessedNumber = playerNumber;
            gameStatus = compareBetweenNumbers(this.playerGuessedNumber);
        }
        else {
            throw new IllegalArgumentException();
        }
        return gameStatus;
    }
    public GameStatus compareBetweenNumbers(String playerNomber){
        String computerNumber = counterPlayer.generateRandomNumber();
        return GameStatus.PLAYING;
    }
    public boolean isValidForm(String target){
        boolean flag = true;
        if (target.length() != 3){
            flag = false;
        }
        for (int i = 0; i < target.length(); i++){
            if (!Character.isDigit(target.charAt(i)))
                flag = false;
        }
        return flag;
    }
}
