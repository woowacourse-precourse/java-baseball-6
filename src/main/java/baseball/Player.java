package baseball;

import java.util.HashSet;

public class Player {
    private String playerNumber;

    public Player(){

    }

    public void setPlayerNumber(String playerNumber) {
        isLengthCorrect(playerNumber);
        isDigit(playerNumber);
        differentNumber(playerNumber);
        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    private static void isLengthCorrect(String playerNumber){
        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 3자리 수를 입력해야합니다.)");
        }
    }

    private static void isDigit(String playerNumber){
        for(int i = 0; i < 3; i++){
            if (playerNumber.charAt(i) < 49){
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 숫자를 입력해야합니다.)");
            }
            if (playerNumber.charAt(i) > 57){
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 숫자를 입력해야합니다.)");
            }
        }
    }

    private static void differentNumber(String playerNumber){
        HashSet<String> wordList = new HashSet<String>();
        for (int i = 0; i<3; i++){
            String word = Character.toString(playerNumber.charAt(i));
            wordList.add(word);
        }
        if (wordList.size() !=3){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 숫자는 중복 되지 않습니다.)");
        }
    }

}
