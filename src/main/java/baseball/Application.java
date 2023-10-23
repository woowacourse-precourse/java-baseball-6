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
            // CreateRandomNumber를 통해 순서도 1번 실행
            List<Integer> computer = randomNumber.MakeRandomNumber();
            // 순서도 5번의 정답이 맞지 않을 경우 계속해서 반복한다.
            while(!result.equals("3스트라이크")){
                List<Integer> input = readline.ReadPlayerNumber(); // Readline을 통해서 순서도 2번 실행
                result = checkStrike.CheckStrikeCount(computer, input); // CheckStrike를 통해 순서도 3번과 4번을 실행
                System.out.println(result); // 순서도 5번 : 결과 값 출력
            }
            // 숫자를 맞췄을 경우 게임이 종료된다.
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            // Replay를 통해 순서도 6번을 실행
            PlayAgain = replay.ReplayGame();
        }
    }
}
