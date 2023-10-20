package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    public void run() {
        printGameStartMessage();

        Game game = new Game();

        int userInput = userInputReceive();

    }

    public int userInputReceive() {
        printInputDemandMessage();

        return rawInputToCheckedInput(Console.readLine());
    }

    public int rawInputToCheckedInput(String rawInput) {
        int parsedInt ;

        try{
            parsedInt = Integer.parseInt(rawInput);

            if (!(parsedInt >= 100) || !(parsedInt <= 999)){
                throw new IllegalArgumentException();
            }

        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        return parsedInt;
    }

    public void printInputDemandMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    private void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
