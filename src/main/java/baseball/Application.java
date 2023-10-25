package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import domain.BallNumber;
import domain.Game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

//equalsAt

public class Application {

    public static void main(String[] args) {
        boolean chk=true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        // TODO: 프로그램 구현
        while(chk==true) {
            //게임 값 생성
            BallNumber bn = new BallNumber();
            List<Integer> numberList = bn.makeNumber();
            Game start = new Game(chk);
            chk = start.startGame(numberList);
        }
    }
}
