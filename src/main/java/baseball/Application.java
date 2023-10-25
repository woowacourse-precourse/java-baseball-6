package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
        Input input = new Input();
        Judge judge = new Judge();
        PlayAgain playagain = new PlayAgain();

        boolean again = true;

        while (again){
            List<Integer> computer = generateRandomNumber.create();
            String result = "";
            while (!result.equals("3스트라이크")){
                result = judge.judge(computer, input.playerNumber());
                System.out.println(result);
            }
            again = playagain.playAgain();
        }
    }
}
