package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
import java.util.List;
import static baseball.Error.*;

public class BaseballGame {
    public void initGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        do game();
        while(reGame()==1);

        System.out.println("게임 종료");
    }

    public void game(){
        Player computer = new Player();
        List<Integer> resultList;

        do{
            System.out.print("숫자를 입력해주세요 : ");
            Player user = new Player(Console.readLine());
            resultList = compareNumList(user.getBallList(), computer.getBallList());
        }while(!printResults(resultList));
    }

    public int reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getGameState();
    }

    public List<Integer> compareNumList(List<Integer> pList, List<Integer>cList){
        int strikes = 0;
        int balls = 0;

        for(int i=0; i<numLength; i++){
            int num = pList.get(i);

            if(cList.contains(num) && cList.get(i) == num)
                strikes++;
            else if (cList.contains(num))
                balls++;
        }

        return Arrays.asList(strikes, balls);
    }

    public boolean printResults(List<Integer> res){
        int strikes = res.get(0);
        int balls = res.get(1);

        if (strikes==3){
            System.out.println(strikes + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (strikes != 0 && balls != 0)
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        else if (strikes != 0)
            System.out.println(strikes + "스트라이크");
        else if (balls != 0)
            System.out.println(balls + "볼");
        else
            System.out.println("낫싱");

        return false;
    }

    public int getGameState(){
        String input;
        int inputToInt = 0;

        try{
            input = Console.readLine();
            inputToInt = Integer.parseInt(input);
        }catch (Exception e){
            throwError(INVALID_INPUT);
        }

        if(inputToInt != GAME_STATE_CONTINUE && inputToInt != GAME_STATE_END)
            throwError(INVALID_GAME_STATE);

        return inputToInt;
    }
}
