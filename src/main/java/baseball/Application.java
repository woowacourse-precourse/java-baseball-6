package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            game.initialize();
            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String input = readLine();
                game.checkInput(input);
                List<Integer> inputList = game.stringToList(input);
                List<Integer> compareResult = game.compareNumbers(inputList);
                System.out.println(game.compareResultToString(compareResult));
                if(compareResult.get(0)==3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = readLine();
            game.checkRestartInput(input);
            if(input.equals("2")){
                break;
            }
        }
    }
}
