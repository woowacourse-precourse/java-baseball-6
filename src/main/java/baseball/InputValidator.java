package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int NUMBER_LENGTH = 3;
    //숫자 확인
    private boolean isNumeric(String playerStr){
        return playerStr.matches("\\d+");
    }
    //중복 숫자 체크
    private boolean containsRepeats(String playerStr){
        boolean result = false;
        List<Integer> playerNumList = BaseballGame.playerNum(playerStr);
        Set<Integer> playerNumSet = new HashSet<>(playerNumList);

        if(playerNumList.size() == playerNumSet.size()) result = true;

        return result;
    }

    //입력값 예외 체크
    public void inputChk(String playerStr){
        if (playerStr == null || playerStr.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        else if(playerStr.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다. 입력한 값 : " + playerStr);
        }
        else if(playerStr.contains("0")) {
            throw new IllegalArgumentException("숫자는 1부터 9까지 입력 가능합니다. 입력한 값 : " + playerStr);
        }
        else if(!isNumeric(playerStr)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다. 입력한 값 : " + playerStr);
        }
        else if(!containsRepeats(playerStr)) {
            throw new IllegalArgumentException("중복된 숫자는 입력이 불가능합니다. 입력한 값 : " + playerStr);
        }
    }
}
