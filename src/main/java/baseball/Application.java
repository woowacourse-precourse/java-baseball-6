package baseball;

import data.ComputerNumber;
import data.GuessNumber;
import utility.Input;
import utility.Printer;

import java.util.List;

import static utility.Command.*;

public class Application {
    public static void main(String[] args){
        int[] computerInput = {1,3,5,5,8,9};
        BaseballGame game = BaseballGame.getInstance();

        ComputerNumber computerNumber;
        GuessNumber guessNumber;
        List<Integer> chunk;
        List<Integer> countResult;
        int command = INITIALIZE;

        int chunkIndex = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");
        chunk = Input.sliceToThree(computerInput, chunkIndex);
        computerNumber = new ComputerNumber(chunk);
        chunkIndex++;

        while(command == INITIALIZE || command == RESTARTED) {
            if(command == RESTARTED) {
                chunk = Input.sliceToThree(computerInput, chunkIndex);
                computerNumber = new ComputerNumber(chunk);
                chunkIndex++;
            }

            System.out.print("숫자를 입력해 주세요 : ");
            guessNumber = new GuessNumber();
            Printer.printBaseballNumber(guessNumber);
            countResult = game.count(computerNumber, guessNumber);
            Printer.printResult(countResult);
            command = game.checkRestart(countResult);
        }
    }
}

