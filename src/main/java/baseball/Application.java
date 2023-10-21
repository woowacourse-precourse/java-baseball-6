package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        CreateRandomNumber randomNumber = new CreateRandomNumber();
        Readline readline = new Readline();
        CheckStrike checkStrike = new CheckStrike();
        Replay replay = new Replay();
        boolean PlayAgain = true;

        while(PlayAgain){
            String result = "";
            List<Integer> computer = randomNumber.MakeRandomNumber();
            while(!result.equals("3스트라이크")){
                List<Integer> input = readline.ReadPlayerNumber();
                result = checkStrike.CheckStrikeCount(computer, input);
                System.out.println(result);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            PlayAgain = replay.ReplayGame();
        }
    }
}
