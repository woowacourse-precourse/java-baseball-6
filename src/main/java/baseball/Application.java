package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        CreateRandomNumber randomNumber = new CreateRandomNumber();
        Readline readline = new Readline();
        CheckStrike checkStrike = new CheckStrike();
        Replay replay = new Replay();
        // 다시 게임을 하는 것에 대한 여부를 확인하기 위한 변수
        boolean PlayAgain = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(PlayAgain){
            // 결과와 컴퓨터의 임의의 3자리수 변수 지정
            String result = "";
            List<Integer> computer = randomNumber.MakeRandomNumber();
            // 입력한 값에 대해서 결과를 나타낸다.
            // eqeals를 통해 result가 "3스트라이크"가 아닐 경우 숫자를 계속해서 입력하도록 한다.
            while(!result.equals("3스트라이크")){
                List<Integer> input = readline.ReadPlayerNumber();
                result = checkStrike.CheckStrikeCount(computer, input);
                System.out.println(result);
            }
            // 숫자를 맞췄을 경우 게임이 종료된다.
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            // 계속해서 게임을 할지 물어 본다.
            PlayAgain = replay.ReplayGame();
        }
    }
}
