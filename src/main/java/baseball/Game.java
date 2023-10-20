package baseball;

import java.util.List;

public class Game {
    public int run(){
        User user = new User();
        Computer com = new Computer();
        boolean end_game = true;
        int one_more=2;
        do {
            List<Integer> user_answer = user.userChoice();
            String result = com.check(user_answer);
            System.out.println(result);
            if(result.equals("3스트라이크")){
                end_game = false;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                one_more = user.regame();
            }
        }while(end_game);
        return one_more;
    }
}
