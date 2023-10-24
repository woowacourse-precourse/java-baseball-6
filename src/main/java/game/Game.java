
package game;

import static constant.Constant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Game{
    int strike = 0;
    public static void run(){
        System.out.println(START_MSG);
        Game game = new Game();
        do{
            game.strike = 0;
            game.gameStart(game.strike);
        }while(game.rerun());
    }

//게임 재시작 여부
    public boolean rerun(){
        System.out.println(ASK_RESTART_MSG);
        String UserInput = Console.readLine();

        //예외상황 UserInput.length()>1
        if(UserInput.length()>1){
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MSG);
        }

        char Input = UserInput.charAt(0);

        //예외상황 Input!='1', Input!='2'
        if(Input < RESTART_GAME_NUMBER && Input > EXIT_GAME_NUMBER){
            throw new IllegalArgumentException(RANGE_EXCEPTION_MSG);
        }

        return compareRestart(Input);
    }

    private boolean compareRestart(char Input){
        if(Input==RESTART_GAME_NUMBER) return true;
        if(Input==EXIT_GAME_NUMBER) return false;
        return false;
    }

//게임 결과 판독    
    public void gameStart(int strike){
        List<Integer> targetNumber = new ArrayList<>(getRandomNum());
        start(strike, targetNumber);
    }
    private int start(int strike, List<Integer> targetNumber){
        if(strike==NUM_DIGITS) {
            System.out.println(NUM_DIGITS + SUCCESS_MSG);
            return 0;
        }
        System.out.print(ASK_INPUT_NUMBER_MSG);
        List<Integer> inputNumber = new ArrayList<>(getInputNum());
        strike = getCompare(targetNumber, inputNumber);
        return start(strike, targetNumber);
    }
    private int getCompare(List<Integer> inputNumber, List<Integer> targetNumber){
        int ball=0;
        int strike=0;
        for(int i=0;i<NUM_DIGITS;i++){
            for(int j=0;j<NUM_DIGITS;j++){
                if(targetNumber.get(i) == inputNumber.get(j) && i==j) {
                    strike++;
                }
                if(targetNumber.get(i) == inputNumber.get(j) && i!=j) {
                    ball++;
                }
            }
        }
        getResult(ball,strike);
        return strike;
    }
    private void getResult(int ball, int strike){
        if(ball==0 && strike==0) System.out.print(NOTHING_MSG);
        if(ball!=0) System.out.print(ball+BALL+" ");
        if(strike!=0) System.out.print(strike+STRIKE);
        System.out.println("");
    }

    //랜덤값 추출
    private List<Integer> getRandomNum(){
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < NUM_DIGITS) {
            int Num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!randomNumber.contains(Num)) {
                randomNumber.add(Num);
            }
        }
        return randomNumber;
    }

    //사용자 입력값
    private List<Integer> getInputNum(){

        String UserInput;
        UserInput = Console.readLine();

        //예외상황
        if(UserInput.length()>NUM_DIGITS){
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MSG);
        }

        List<Integer> inputNum = new ArrayList<>();
        int num;

        for(int i=0;i<UserInput.length();i++){
            num = charToInt(UserInput.charAt(i));

            //예외상황
            if(num<MIN_NUM && num>MAX_NUM){
                throw new IllegalArgumentException(RANGE_EXCEPTION_MSG);
            }
            if(inputNum.size() > 0 && inputNum.contains(num)){
                throw new IllegalArgumentException(DUPLI_EXCEPTION_MSG);
            }

            inputNum.add(num);
        }
        return inputNum;
    }

    private int charToInt(char ch){
        return ch-'0';
    }
}

