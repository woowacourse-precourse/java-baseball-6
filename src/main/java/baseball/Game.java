package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private int first_start = 0;

    public void run() {

        if(first_start == 0){
            printStartMessage();
            first_start++;
        }

        ComputerNumber computerNumber = new ComputerNumber();
        UserNumber userNumber = new UserNumber();
        NumberCompare numberCompare = new NumberCompare();

        while (true){

            userNumber.setUserNumber(input());
            boolean isWin = numberCompare.PrintHint(userNumber, computerNumber);

            if(isWin){
                printWinMessage();
                int i = Integer.parseInt(Console.readLine());
                if(i == 1){
                    run();
                }
                break;
            }
        }
    }


    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String input(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void printWinMessage(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public int IsRestart(){
        return Integer.parseInt(Console.readLine());
    }

    public void win(){
        int input = Integer.parseInt(Console.readLine());
        if(input != 1){
            return;
        }
        run();
    }

}
