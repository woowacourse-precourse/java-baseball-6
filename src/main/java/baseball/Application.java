package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseballGame baseballGame = new BaseballGame();
        BaseballGameController controller = new BaseballGameController();
        BaseballGameView view = new BaseballGameView();
        int size = baseballGame.getNumberBoard()
                                .size();
        System.out.println("게임을 시작합니다. 길이가 " + size + "인 중복되지 않는 숫자를 입력해주세요.");

        while (true){
            String input = Console.readLine();

            if(input.equals("1")) {
                System.out.println("게임을 다시 시작합니다.");
                baseballGame = new BaseballGame();
                continue;
            }

            if(input.equals("2")) {
                System.out.println("게임 종료.");
                break;
            }

            int[] result = controller.guess(baseballGame, input);
            view.print(result);
        }
        Console.close();
    }
}