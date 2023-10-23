package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Inspection inspection=new Inspection();
        Production production = new Production();
        Game game = new Game();
        //컴퓨터 패 생성
        List<Integer> comList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        comList.forEach(element -> System.out.println(element));
        //사용자 패 생성
        List<Integer> userList = inspection.userInputToList();
        userList.forEach(element -> System.out.println(element));
        game.play(comList,userList);


    }

}
