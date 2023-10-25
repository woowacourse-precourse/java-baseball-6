package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int setNumber;
    static String cNumber;
    static String pNumber;

    public static int getSetNumber() {
        return setNumber;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberControl numberControl = new NumberControl();
        Outputs output = new Outputs();
        GameResult gameResult = new GameResult();
        cNumber = numberControl.getComputerNumber(); //생성된 컴퓨터 3자리 난수
        output.wordStart();
        setNumber = 1;
        while (setNumber != 2) {
            output.wordInsertNumber();
            String user = Console.readLine();
            pNumber = numberControl.getPlayerNumber(user); //74,75 합치는 방법 필요함.
            gameResult.printResult(cNumber, pNumber);
        }
    }

}
