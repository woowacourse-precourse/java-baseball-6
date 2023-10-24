package game;

import static constant.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Game{

    public static void start(){
        do{
            int strike = 0;
            gameStart(strike);
        }while(restart());
    }

//  게임 재시작 여부
    private boolean restart(){
        System.out.println(ASK_RESTART_MSG);
        String UserInput = Console.readLine();
        return compareRestart(UserInput);
    }
    private boolean compareRestart(String UserInput){
        //예외상황
        char Input = UserInput.charAt(0);
        if(Input==RESTART_GAME_NUMBER) return true;
        if(Input==EXIT_GAME_NUMBER) return false;
        return false;
    }


//랜덤값 추출
    private List<Integer> getRandomNum(){
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int Num = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(Num)) {
                randomNumber.add(Num);
            }
        }
        return randomNumber;
    }

//사용자 입력값
    private List<Integer> getInputNum(){
        String UserInput = Console.readLine();
        //예외상황 : 1-9 숫자가 아님,중복된 숫자가 있음, 4개이상의 입력값을 입력함
        List<Integer> inputNum = new ArrayList<>();
        for(int i=0;i<UserInput.length();i++){
            int num = charToInt(UserInput.charAt(i));
            inputNum.add(num);
        }
        return inputNum;
    }

    private int charToInt(char ch){
        return ch-'0';
    }

//게임 결과 판독    
    private int gameStart(int strike){
        if(strike==NUM_DIGITS){
            System.out.println(NUM_DIGITS+SUCCESS_MSG);
            return 0;
        }
        List<Integer> targetNumber = new ArrayList<>(getRandomNum());
        System.out.print(ASK_INPUT_NUMBER_MSG);
        List<Integer> inputNumber = new ArrayList<>(getInputNum());
        int ball = getCompare(targetNumber, inputNumber);
        getResult(ball, strike);
        return gameStart(strike);
    }
    private int getCompare(List<Integer> inputNumber, List<Integer> targetNumber){
        int ball;
        for(int i=0;i<NUM_DIGITS;i++){
            for(int j=0;j<NUM_DIGITS;j++){
                if(targetNumber[i]==inputNumber[j] && i==j) strike++;
                if(targetNumber[i]==inputNumber[j] && i!=j) ball++;
            }
        }
        return ball;
    }
    private void getResult(int ball, int strike){
        if(ball==0 && strike==0) System.out.print(NOTHING_MSG);
        if(ball!=0) System.out.print(ball+BALL);
        if(strike!=0) System.out.print(" "+strike+STRIKE);
        System.out.println("");
    }
}