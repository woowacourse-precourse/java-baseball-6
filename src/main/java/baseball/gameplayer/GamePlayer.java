package baseball.gameplayer;

import baseball.computer.Computer;
import baseball.user.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GamePlayer {
    Computer computer;
    User user;
    public GamePlayer(){
        computer = new Computer();
        user = new User();
    }

    public Map<String, Integer> oneTurn(List<Integer> computerNums){
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNums = user.inputNumbers();

        Map<String,Integer> score = new HashMap<>();

        Integer strike = (int)Stream.iterate(0,(i)->i+1).
                limit(userNums.size()).
                filter(i->userNums.get(i).equals(computerNums.get(i))).
                count();

        Integer ball = (int)computerNums.stream().
                filter(userNums::contains).
                count();

        ball = ball - strike;

        score.put("strike",strike);
        score.put("ball",ball);

        return score;
    }

    public void printScore(Map<String,Integer> score){
        Integer strike = score.get("strike");
        Integer ball = score.get("ball");

        if((strike+ball)==0){
            System.out.println("낫싱");
            return;
        }else if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.println(String.format("%d볼 %d스트라이크",ball,strike));
    }

    public void oneGame(){
        boolean go = true ;
        List<Integer> computerSelectNumbers = computer.selectNumbers();

        while(go){
            Map<String,Integer> oneTurnResult = oneTurn(computerSelectNumbers);

            printScore(oneTurnResult);

            if(oneTurnResult.get("strike")==3){
                go = false;
            }
        }
    }

    public void playGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        Integer select = 1;
        while(select == 1){
            oneGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            select = Integer.parseInt(Console.readLine());
            validateInput(select);

        }
    }

    private void validateInput(Integer select) throws IllegalArgumentException{
        if(select!=1 && select!=2){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}