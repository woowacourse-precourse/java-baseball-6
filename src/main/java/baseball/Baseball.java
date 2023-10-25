package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Baseball {

    private final PrintMessage printMessage = new PrintMessage();
    private final InputLineConverter InputNumberConverter = new InputLineConverter();
    private ArrayList<Integer> answerNumberList = new ArrayList<>();
    private ArrayList<Integer> myInputNumber = new ArrayList<>();

    public void run(){
        printMessage.gameStartMessage();
        startGame();
    }

    public void startGame(){
        int commandNumber;
        do {
            initRandomNumberList();

            myInputNumber = InputNumberConverter.stringToIntegerList().orElseThrow(
                    () -> new IllegalArgumentException("입력값이 잘못되었습니다.")
            );

            while(!checkGameScore(answerNumberList, myInputNumber)){ // MyInputNumber객체를 통해 checkGameScore사용
                myInputNumber = InputNumberConverter.stringToIntegerList().orElseThrow(
                        () -> new IllegalArgumentException("입력값이 잘못되었습니다.")
                );
            }

            printMessage.endGameCommand();
            commandNumber = InputNumberConverter.commandNumber().orElseThrow(
                    () -> new IllegalArgumentException("입력값이 잘못되었습니다.")
            );

        }while (commandNumber == 1);
    }

    // TODO: 2023-10-25 : 스트림으로 변환하여 가독성을 올릴 수 있는지 로직 재검증
    public ArrayList<Integer> initRandomNumberList(){

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

        return answerNumberList;
    }

    // TODO: 2023-10-25 : 체크할 때 로직 최적화 확인
    public boolean checkGameScore(ArrayList<Integer> answerNumberList, ArrayList<Integer> inputNumberList){ // 로직재검증
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
