package baseball;
import controller.SelectComputerNum;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            SelectComputerNum selectComputer = new SelectComputerNum();//create Object
            selectComputer.randomlySelectComputerNum();//computer randomly select number

            System.out.println("숫자를 입력해주세요 : ");//input
            char[] selectUsers = readLine().toCharArray();//user select number

            SelectUserNum user = new SelectUserNum(selectUsers);//create Object
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();//startGame() 호출
    }
}
