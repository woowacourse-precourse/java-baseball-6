package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Production {
    Inspection inspection=new Inspection();

    Game game = new Game();
    //컴퓨터 패 생성

    List<Integer> comList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    //사용자 패 생성
    List<Integer> userList = inspection.userInputToList();





}
