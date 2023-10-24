package baseball;

import game.Game;
import game.GameImp;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new GameImp();
        while(true)
        {
            game.start();
            while(!game.getStatus())
            {
                System.out.println("숫자를 입력해주세요 : ");
                String input = readLine();
                try {game.gameInput(input);}
                catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException();
                }
                System.out.println(game.gameoutput());
                if(game.getStatus())
                    break;
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String reinput = readLine();
            boolean chk = false;
            try {
                chk=game.restart(reinput);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
            if(!chk)
                break;
        }
    }
}
