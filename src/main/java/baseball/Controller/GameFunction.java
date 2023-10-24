package baseball.Controller;

import baseball.View.InputView;
import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameFunction {
    public String inputUserNum(){
        String num = Console.readLine();
        return num;
    }

    public void compareString(String comData, String userData){
        Vaildation vaildation = new Vaildation();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        
        int strick = 0;
        int ball = 0;

        while(!comData.equals(userData)){
            vaildation.exption(userData);

            strick = compareStrick(comData, userData);
            ball = compareBall(comData, userData);
            outputView.resultMsg(strick, ball);

            inputView.inputMsg();
            userData = inputUserNum();
        }
    }

    public int compareStrick(String comData, String userData){
        int ch = 0;
        for(int i = 0; i< comData.length(); i++){
            if(comData.charAt(i) == userData.charAt(i)){
                ch += 1;
            }
        }
        return ch;
    }

    public int compareBall(String comData, String userData){
        int ch = 0;
        for(int i = 0; i < comData.length();i++){
            for (int j = 0; j < userData.length() ; j++){
                if (i != j && comData.charAt(i) == userData.charAt(j)){
                    ch += 1;
                }
            }
        }
        return ch;
    }

    public boolean branchChoice(String branchNum){
        if (branchNum.equals("1")){
            return true;
        }
        else if(branchNum.equals("2")){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }    
}
