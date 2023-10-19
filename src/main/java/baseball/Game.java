package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    public void run(){
        printInsert();
        UserNumber userNumber = new UserNumber();
        ComputerNumber computerNumber = new ComputerNumber();
        NumberCompare comparator = new NumberCompare();

        while (true){
            System.out.println(userNumber.getUserNumber());
            String userNumber1 = userNumber.setUserNumber();
            boolean check = comparator.PrintHint(userNumber, computerNumber);


            if(check){
                win();
            }

        }

    }

    public void printInsert(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printWinMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void win(){
        printWinMessage();
        int input = Integer.parseInt(Console.readLine());
        if(input != 1){
            return;
        }
        run();
    }

}
