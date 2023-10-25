package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CreateNum createnum = new CreateNum();
        PlayGame playgame = new PlayGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            List<Integer> answer = createnum.CreateNumber();

            playgame.playGame(answer);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            char retry = Console.readLine().charAt(0);
            if(retry =='2')
                break;
        }
    }
}
