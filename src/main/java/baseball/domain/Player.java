package baseball.domain;

import java.util.ArrayList;

import baseball.utils.BaseballUtil;
import baseball.view.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private ArrayList<Integer> playerNumbers;

    public ArrayList<Integer> getPlayerNumbers(int digit){
        return inputPlayerNumbers(digit);
    }

    public int inputEndDecision(){
        while(true){
            GameMessage.printRestartOrExit();

            int restartNum = inputUserNum();
            if(restartNum==1 || restartNum==2){
                return restartNum;
            }
        }
    }

    private int inputUserNum() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }


    private void initPlayerNumbers(){
        playerNumbers = new ArrayList<>(BaseballUtil.splitNumberToList(inputUserNum()));
    }


    private ArrayList<Integer> inputPlayerNumbers(int digits) throws IllegalArgumentException{
        GameMessage.printAskNumber();
        initPlayerNumbers();

        if(playerNumbers.size() != digits || playerNumbers.contains(0)){
            throw new IllegalArgumentException("서로 다른 3자리의 수(1~9)를 입력하세요.");
        }

        return playerNumbers;
    }
}
