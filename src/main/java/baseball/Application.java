package baseball;
import controller.selectComputerNum;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            selectComputerNum selectComputer = new selectComputerNum();//create Object
            selectComputer.randomlySelectComputerNum();//computer randomly select number

            System.out.println("숫자를 입력해주세요 : ");//input
            char[] selectUser = readLine().toCharArray();//user select number

            User user = new User(selectUser);//create Object
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();//startGame() 호출
    }
}
