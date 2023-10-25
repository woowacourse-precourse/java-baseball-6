package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Baseball {

    private final PrintMessage printMessage = new PrintMessage();
    private final Illegalcheck illegalcheck = new Illegalcheck();
    private final MyInputNumber myInputNumber = new MyInputNumber();

    private ArrayList<Integer> answerNumberList = new ArrayList<>();

    public void run(){
        printMessage.gameStartMessage();
        startGame();
    }

    /**
     * Todo
     * inputNumberList = getNumberInputList(); // 리팩토링이 필요한 부분
     *
     * MyInputNumber객체를 통해 checkGameScore사용
     *
     * 인풋은 MyInputNumber객체에게 역할을 넘김
     *
     * 에러체크는 누구에게 넘겨야하는가 고민
     */
    public void startGame(){
        int commandNumber;
        ArrayList<Integer> inputNumberList;
        do {
            initRandomNumberList();

            inputNumberList = getNumberInputList(); // 리팩토링이 필요한 부분

            while(!checkGameScore(answerNumberList, inputNumberList)){ // MyInputNumber객체를 통해 checkGameScore사용
                inputNumberList = getNumberInputList();
            }

            printMessage.endGameCommand();
            commandNumber = Integer.parseInt(Console.readLine()); // 인풋은 MyInputNumber객체에게 역할을 넘김

            illegalcheck.commandCheck(commandNumber); // 에러체크는 누구에게 넘겨야하는가 고민

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
    // TODO: 2023-10-25 : MyInputNumber객체로 역할 분산
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
