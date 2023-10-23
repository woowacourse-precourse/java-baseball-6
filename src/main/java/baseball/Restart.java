package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    public void askPlayer(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        int number = Integer.parseInt(input);
        validateNumber(number);

        if(number == 1){
            PlayGame playGame = new PlayGame();
            playGame.run();
        }
    }

    public static void validateNumber(int choice){
        if(!(choice == 1 || choice == 2))
            throw new IllegalArgumentException("there are only 2 choices. 1 or 2");
    }

}
