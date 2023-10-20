package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Baseball {

    private final PrintMessage printMessage = new PrintMessage();

    public void run(){
        printMessage.gameStartMessage();
        startGame();
    }

    public void startGame(){
        int commandNumber;
        ArrayList<Integer> inputNumberList;
        do {
            ArrayList<Integer> answerNumberList = initRandomNumberList();

            /**
             * 디버깅용 상대정답 코드
             */
            System.out.print("정답 : ");
            for( int num : answerNumberList){
                System.out.print(num + " ");
            }
            System.out.println();

            getNumberInputList();
            inputNumberList = getNumberInputList();
            
//            checkGameScore(answerNumberList, inputNumberList);
            printMessage.gameResult(1, 1);
            printMessage.inputNumberMessage();
            printMessage.gameResult(0, 3);
            printMessage.gameCommand();
            commandNumber = Integer.parseInt(Console.readLine());
        }while (commandNumber == 1);
    }

    public ArrayList<Integer> initRandomNumberList(){

        ArrayList<Integer> answerNumberList = new ArrayList<>();
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

        return answerNumberList;
    }

    public ArrayList<Integer> getNumberInputList(){
        printMessage.inputNumberMessage();
        String inputData = Console.readLine();
        ArrayList<Integer> inputNumberList = new ArrayList<>();
        for(int i = 0; i < inputData.length(); i++) {
            inputNumberList.add(Integer.valueOf(inputData.charAt(i)));
        }
        return inputNumberList;
    }

    public void checkGameScore(ArrayList<Integer> answerNumberList, int[] b){

    }




}
