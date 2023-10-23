package baseball;

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
        int inputNumber = 123;
        System.out.println("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 : " + inputNumber);
        if (inputNumber == randomNumber){
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println("1볼");
        }






        //PlayGame playGame = new PlayGame();
        // playGame.inputNumber = 123;
        //String game = playGame.gameRestart(1);
        //System.out.println(game);



    }
}