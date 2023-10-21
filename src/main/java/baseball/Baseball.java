package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Baseball {

    private final PrintMessage printMessage = new PrintMessage();
    private final Illegalcheck illegalcheck = new Illegalcheck();

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

            inputNumberList = getNumberInputList();

            while(!checkGameScore(answerNumberList, inputNumberList)){
                inputNumberList = getNumberInputList();
            }

            printMessage.endGameCommand();
            commandNumber = Integer.parseInt(Console.readLine());

            illegalcheck.commandCheck(commandNumber);

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
        illegalcheck.gameNumberFilter(inputData);

        ArrayList<Integer> inputNumberList = new ArrayList<>();
        for(int i = 0; i < inputData.length(); i++) {
            inputNumberList.add(Integer.parseInt(String.valueOf(inputData.charAt(i))));
        }
        return inputNumberList;
    }

    public boolean checkGameScore(ArrayList<Integer> answerNumberList, ArrayList<Integer> inputNumberList){
        int num1, num2;
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < 3; i++){
            num1 = answerNumberList.get(i);
            for(int j = 0; j < 3; j++){
                num2 = inputNumberList.get(j);
                if(num1 == num2){
                    if(i == j){
                        strikeCount++;
                        continue;
                    }
                    ballCount++;
                }
            }
        }

        printMessage.gameResult(ballCount, strikeCount);

        if(strikeCount == 3){
            return true;
        }

        return false;
    }
}
