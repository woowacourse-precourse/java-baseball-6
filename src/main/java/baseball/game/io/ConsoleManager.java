package baseball.game.io;

import baseball.game.model.dto.GameResultDto;
import camp.nextstep.edu.missionutils.Console;


public class ConsoleManager implements Input, Output{

    @Override
    public String readNumber() {
        return Console.readLine();
    }

    @Override
    public int readRetryMenu() {
        String str = Console.readLine();
        return Integer.parseInt(str);
    }

    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void printLineMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printGameResult(GameResultDto resultDto) {
        if (resultDto.getBall() > 0 && resultDto.getStrike() > 0) {
            System.out.printf("%d볼 %d스트라이크\n", resultDto.getBall(), resultDto.getStrike());
            return;
        }

        if (resultDto.getStrike() == 0 && resultDto.getBall() == 0) {
            System.out.println("낫싱");
            return;
        }

        if (resultDto.getStrike() == 0) {
            System.out.printf("%d볼\n", resultDto.getBall());
            return;
        }

        if (resultDto.getBall() == 0) {
            System.out.printf("%d스트라이크\n", resultDto.getStrike());
        }
    }
}
