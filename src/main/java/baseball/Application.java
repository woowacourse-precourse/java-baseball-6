package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.print("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        int userInputNumber= 0;
        try {
             userInputNumber = Integer.parseInt(userInput);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닌 것이 섞여 있을 때");
        }
        System.out.println(userInputNumber);

        System.out.println(userInput);





//        int inputNumber = 123;
//        if (inputNumber == randomNumber){
//            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//        } else {
//            System.out.println("1볼");
//        }






        //PlayGame playGame = new PlayGame();
        // playGame.inputNumber = 123;
        //String game = playGame.gameRestart(1);
        //System.out.println(game);



    }
}