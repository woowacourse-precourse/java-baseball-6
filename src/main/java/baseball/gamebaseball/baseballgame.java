package baseball.gamebaseball;

import baseball.check.Checknum;
import baseball.data.Data;
import baseball.distinguishnumber.Distinguish;
import baseball.output.Output;
import camp.nextstep.edu.missionutils.Console;

public class baseballgame {

    Distinguish distinguish;
    Checknum checknum;
    Output output;
    Data data;

    public baseballgame(Distinguish distinguish, Checknum checknum, Output output, Data data) {
        this.distinguish = distinguish;
        this.checknum = checknum;
        this.output = output;
        this.data = data;
    }

    public void play() {

        output.start();

        while(data.getTof()){
            output.getInput();
            String userNum = Console.readLine();

            //입력값에 대한 판단
            Checking(userNum);
            distinguish.distinguish(data.getAnswer(), data.getUser(userNum));
            data.setResult(output.makeString(data.getStrike(), data.getBall()));

            output.outResult(data.getResult());
            if(data.getStrike() == data.getDigit()){
                printEnd();
            }

            data.clear();
        }

    }

    private boolean Checking(String num){
        return checknum.checkIsNum(num) && checknum.checkIsThreeDigit(num) && checknum.checkIsDuplicate(num);
    }

    private boolean restart(String res){
        return Integer.parseInt(res) == 1;
    }

    private void printEnd(){
        output.collect();
        String res = Console.readLine();

        if(restart(res)) {
            data.resetAnswer();
            data.clear();
        }else{
            data.setTof(false);
        }
    }
}
