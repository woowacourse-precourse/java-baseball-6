package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Baseball {

    private final PrintMessage printMessage = new PrintMessage();
    private ArrayList<Integer> answerNumberList;

    public void run(){
        printMessage.gameStartMessage();
        startGame();
    }

    public void startGame(){
        int commandNumber;
        do {
            initRandomNumber();
            for( int num : answerNumberList){
                System.out.println(num);
            }
            printMessage.inputNumberMessage();
            printMessage.gameResult(1, 1);
            printMessage.inputNumberMessage();
            printMessage.gameResult(0, 3);
            printMessage.gameCommand();
            commandNumber = Integer.parseInt(Console.readLine());
        }while (commandNumber == 1);
    }

    public void initRandomNumber(){

        answerNumberList = new ArrayList<>();
        answerNumberList.add(Randoms.pickNumberInRange(1, 9));
        boolean equalPrevNumber = false;

        while(answerNumberList.size() < 3){

            equalPrevNumber = false;

            int nowNumber = Randoms.pickNumberInRange(1, 9);
            for(int prevNumber : answerNumberList){
                if(prevNumber == nowNumber) {
                    equalPrevNumber = true;
                    break;
                }
            }

            if(!equalPrevNumber) {
                answerNumberList.add(nowNumber);
            }

        }
    }
}
