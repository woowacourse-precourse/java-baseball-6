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

    private int inputUserNum() throws IllegalArgumentException{
        while (true){
            try{
                return Integer.parseInt(Console.readLine());
            }catch(NumberFormatException e){
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    private void initPlayerNumbers(){
        int userNum = inputUserNum();
        playerNumbers = new ArrayList<>(BaseballUtil.splitNumberToList(userNum));
    }

    private ArrayList<Integer> inputPlayerNumbers(int digits){
        while(true){
            GameMessage.printAskNumber();
            initPlayerNumbers();

            if(playerNumbers.size()!=digits){
                throw new IllegalArgumentException(digits + "개의 숫자를 입력해주세요.");
            }

            if(playerNumbers.contains(0)){
                throw new IllegalArgumentException("1~9의 숫자만 입력이 가능합니다.");
            }
            //System.out.println(playerNumbers);
            break;
        }
        return playerNumbers;
    }
}
