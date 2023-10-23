package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Inspection inspection=new Inspection();
        Game game = new Game();
        boolean gameWon = false;
        //컴퓨터 패 생성
        List<Integer> comList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        comList.forEach(element -> System.out.println(element));

        while (!gameWon) {
            //사용자 패 생성
            List<Integer> userList = inspection.userInputToList();
            userList.forEach(element -> System.out.println(element));
            game.play(comList,userList);
            if (game.getflag() ==true) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameWon = true;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");



    }
}
