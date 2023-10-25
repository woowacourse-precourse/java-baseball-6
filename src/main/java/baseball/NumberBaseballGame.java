package baseball;
import baseball.models.Score;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static baseball.controller.StrikeBallCounter.check;

import java.util.ArrayList;
import java.util.List;
import baseball.controller.InputValidator;


public class NumberBaseballGame {

    public void run(){
        List<Integer> computer = getComputerNumber();
        Score score = new Score();
        while(score.getStrikeCnt()!=3){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = getUserNumber();
            check(computer, user, score);
            displayResult(score.getStrikeCnt(), score.getBallCnt());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public List<Integer> getComputerNumber() {
        List<Integer> computerList = new ArrayList<>();
        while(computerList.size() < 3) {
            int randomNumber =  pickNumberInRange(1,9);
            if(!computerList.contains(randomNumber))
                computerList.add(randomNumber);
        }
        return computerList;
    }

    public List<Integer> getUserNumber(){
        String number = readLine();
        InputValidator.isThreeDigitNaturalNumber(number);
        InputValidator.isNumberSize(number);
        return stringToList(number);
    }

    public List<Integer> stringToList(String number){
        List<Integer> returnList = new ArrayList<>();
        for(String s : number.split("")){
            returnList.add(Integer.parseInt(s));
        }
        return returnList;
    }

    public void displayResult(int strikes, int balls) {
        if(strikes == 0 && balls == 0)
            System.out.println("낫싱");
        if(strikes > 0 && balls > 0)
            System.out.println(balls +"볼 " + strikes + "스트라이크");
        else if(strikes > 0)
            System.out.println(strikes + "스트라이크");
        else if(balls > 0)
            System.out.println(balls + "볼");
    }




}
