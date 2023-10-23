package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GenerateRandomNum randomNum = new GenerateRandomNum();
        Input input = new Input();
        Judge judge = new Judge();
        PlayAgain playagain = new PlayAgain();
        boolean again = true;

        while (again){
            List<Integer> computer = randomNum.create();
            String result = "";
            while (!result.equals("3스트라이크")){
                result = judge.judgement(computer, input.playerNumber());
                System.out.println(result);
            }
            again = playagain.playAgain();
        }
    }
}
