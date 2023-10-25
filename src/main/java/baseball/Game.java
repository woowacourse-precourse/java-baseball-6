package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static String start = "숫자 야구 게임을 시작합니다.";
    private static String finish = "숫자 야구 게임을 완전히 종료합니다.";
    private static String complete = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static String more = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getComplete() {
        return complete;
    }

    public String getFinish() {
        return finish;
    }

    public String getStart() {
        return start;
    }

    public String getMore() {
        return more;
    }

    public static void setComplete(String complete) {
        Game.complete = complete;
    }

    public static void setFinish(String finish) {
        Game.finish = finish;
    }

    public static void setMore(String more) {
        Game.more = more;
    }

    public static void setStart(String start) {
        Game.start = start;
    }

    public void printStart(){
        System.out.println(start);
    }

    public void printMore(){
        System.out.println(more);
    }

    public void printFinish(){
        System.out.println(finish);
    }

    public void printComplete(){
        System.out.println(complete);
    }

    public void run(){
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.setNumberList();
        while (true) {
            UserNumber userNumber = new UserNumber();
            userNumber.setNumberList();
            Hint hint = new Hint(userNumber.getNumberList(), computerNumber.getNumberList());
            hint.printHint();
            if(hint.getIsSame()){
                printComplete();
                if(getInput() == 1) run();
                return;
            }
        }
    }

    public int getInput(){
        printMore();
        int input=0;
        try{
            input = Integer.parseInt(readLine());
            if(input!=1 && input!=2) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e) {
            throw e;
        }
        return input;
    }

    public static void changeSize(int newSize){
        ComputerNumber.setSize(newSize);
        UserNumber.setSize(newSize);
    }
}
