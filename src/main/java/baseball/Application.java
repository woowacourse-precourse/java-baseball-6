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
        //TODO: run내용을 BaseballGame 클래스 메서드로 따로 분리하고 1234 넣었을때 exception안뜨는거 해결하기
        //game.run(computerInput);

        ComputerNumber computerNumber;
        GuessNumber guessNumber;
        List<Integer> countResult;
        int exitCommand = INITIALIZE;
        List<Integer> chunk;

        int chunkIndex = 0;

        chunk = Input.sliceToThree(computerInput, chunkIndex);
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumber = new ComputerNumber(chunk);
        chunkIndex++;

        while(exitCommand == INITIALIZE || exitCommand == RESTARTED) {
            if(exitCommand == RESTARTED){
                chunk = Input.sliceToThree(computerInput, chunkIndex);
                computerNumber = new ComputerNumber(chunk);
            }

            System.out.print("숫자를 입력해 주세요 : ");
            guessNumber = new GuessNumber();

            Printer.printBaseballNumber(guessNumber);
            countResult = game.count(computerNumber, guessNumber);
            Printer.printResult(countResult);
            exitCommand = game.checkRestart(countResult);

            if(exitCommand == EXIT)
                return;
        }
    }
}

