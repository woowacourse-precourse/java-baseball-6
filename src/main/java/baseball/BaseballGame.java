package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {
    final public static int numLength = 3;

    public void initGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        do game();
        while(reGame()==1);

        System.out.println("게임을 종료합니다.");
        return;
    }

    public void game(){
        List<Integer> computerNumList = getRandomList();
        List<Integer> resultList = new ArrayList<>();

        do{
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> playerNumList = getPlayerList();
            resultList = compareNumList(playerNumList, computerNumList);

        }while(!printResults(resultList));
    }

    public List<Integer> getRandomList(){
        List<Integer> ranNumList = new ArrayList<>();

        while(ranNumList.size()<numLength){
            int ranNum = Randoms.pickNumberInRange(1,9);

            if(!ranNumList.contains(ranNum))
                ranNumList.add(ranNum);
        }

        return ranNumList;
    }

    public int reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public List<Integer> getPlayerList(){
        String input = Console.readLine();
        List<Integer> inputList = new ArrayList<>();

        for(int i=0; i<numLength; i++) {
            int num = input.charAt(i) - '0';
            inputList.add(num);
        }

        return inputList;
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
}
