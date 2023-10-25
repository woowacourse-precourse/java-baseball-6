package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static String startStr = "숫자 야구 게임을 시작합니다.";
    private static String finishStr = "숫자 야구 게임을 완전히 종료합니다.";
    private static String completeStr = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static String moreOrNotStr = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public Game(){
        printStartStr();
    }

    public String getCompleteStr() {
        return completeStr;
    }

    public String getFinishStr() {
        return finishStr;
    }

    public String getStartStr() {
        return startStr;
    }

    public String getMoreOrNotStr() {
        return moreOrNotStr;
    }

    public static void setCompleteStr(String completeStr) {
        Game.completeStr = completeStr;
    }

    public static void setFinishStr(String finishStr) {
        Game.finishStr = finishStr;
    }

    public static void setMoreOrNotStr(String moreOrNotStr) {
        Game.moreOrNotStr = moreOrNotStr;
    }

    public static void setStartStr(String startStr) {
        Game.startStr = startStr;
    }

    public void printStartStr(){
        System.out.println(startStr);
    }

    public void printMoreOrNotStr(){
        System.out.println(moreOrNotStr);
    }

    public void printFinishStr(){
        System.out.println(finishStr);
    }

    public void printCompleteStr(){
        System.out.println(completeStr);
    }

    public void run(){
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.setNumberList();

        while (true) {
            UserNumber userNumber = new UserNumber();
            userNumber.setNumberList();

            Hint hint = new Hint(userNumber, computerNumber);
            hint.makeHint();

            if(hint.getIsComplete()){
                printCompleteStr();
                if(getInput() == 1) run();
                else printFinishStr();
                return;
            }
        }
    }

    public int getInput(){
        printMoreOrNotStr();
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
