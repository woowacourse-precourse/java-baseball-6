package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class MainGame {
    private final CustomException exception = new CustomException();
    public void play(){
        Numbers makeNumbers = new Numbers();
        Computer com = new Computer();
        boolean again = true;

        while(again){
            List<Integer> answer = makeNumbers.makeRandomNumbers();
//            System.out.println(answer);
            List<Integer> player = gameStart();
            List<Integer> sb =  com.count(answer, player);
            // 스트라이크 볼 여부로 3개다 맞추면 게임 끝, 아니면 다시 계속
            while(!result(sb)){
                player = gameProgress();
                sb = com.count(answer, player);
            }
            again = playAgain();
        }
    }
    public String hint(List<Integer> sb){
        if(sb.get(0) == 0 && sb.get(1) == 0){
            return "낫싱";
        }else if(sb.get(0) == 0){
            return sb.get(1) + "볼";
        }else if(sb.get(1) == 0){
            return sb.get(0)+ "스트라이크";
        }
        return sb.get(1) + "볼" + sb.get(0)+ "스트라이크";
    }
    public boolean result(List<Integer> sb){
        System.out.println(hint(sb));
        return sb.get(0) == 3;
    }
    public List<Integer> gameStart(){
        CustomView.printStart();
        String player = Console.readLine();
        exception.checkInputValidation(player);
        CustomView customView = new CustomView();
        return customView.strToList(player);
    }
    public boolean playAgain(){
        CustomView.printResult();
        String playEnd = Console.readLine();
        return playEnd.equals("1");
    }
    public List<Integer> gameProgress(){
        CustomView.printNumber();
        String player = Console.readLine();
        exception.checkInputValidation(player);
        CustomView customView = new CustomView();
        return customView.strToList(player);
    }


}
