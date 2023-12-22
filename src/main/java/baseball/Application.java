package baseball;

import baseball.Computer.ComputerService;
import baseball.Parse.ParseService;
import baseball.check.CheckService;
import baseball.check.Hint;
import baseball.input.InputService;
import baseball.print.PrintService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        PrintService printService = appConfig.printService();
        ComputerService computerService = appConfig.computerService();
        InputService inputService = appConfig.inputService();
        ParseService parseService = appConfig.parseService();
        CheckService checkService = appConfig.checkService();

        List<Integer> computer = computerService.settingComputer();
        printService.gameStartMessage();

        while(true){
            printService.inputMessage();
            List<Integer> numbers = parseService.stringParseToNumbers(inputService.readLine());
            Hint hint = checkService.checkNumber(computer, numbers);
            printService.resultMessage(hint.getStrike(), hint.getBall());
            if(checkService.checkGameOver(hint)){
                printService.gameEndMessage();
                printService.restartMessage();
                if(parseService.isRestart(inputService.readLine())){
                    computer = computerService.settingComputer();
                    continue;
                }
                break;
            }
        }
    }
}
