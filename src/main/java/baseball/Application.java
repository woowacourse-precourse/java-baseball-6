package baseball;
import controller.CheckResult;
import controller.SelectComputerNum;
import controller.SelectUserNum;
import model.Computer;
import model.User;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void reStart() {
        SelectComputerNum selectComputerNum= new SelectComputerNum();//create Object
        Computer computer = selectComputerNum.randomlySelectComputerNum();//computer randomly select number

        while(true) {
            try{
                System.out.println("숫자를 입력해주세요 : ");//input

                String selectUsers = readLine();//user select number
                SelectUserNum selectUserNum = new SelectUserNum(selectUsers);//create Object
                User user = selectUserNum.returnSelectUserNum();

                CheckResult checkResult = new CheckResult(computer, user);//create Object
                boolean playResult = checkResult.equalsComputerAndUser();

                if (playResult) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    int userChoice = Integer.parseInt(readLine());
                    if(userChoice == 1) {reStart();}
                    if(userChoice == 2) {return;}
                    throw new IllegalArgumentException("Invalid argument: " + userChoice);
                };
            }catch (IllegalArgumentException e){
                System.out.println("close Application: IllegalArgumentException");
                return;
            }catch (NullPointerException e) {
                System.out.println("close Application: NullPointerException");
                return;
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        reStart();
    }
}
