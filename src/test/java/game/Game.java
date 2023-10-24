package game;

import static constant.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Game{

    public static void start(){
        do{
            List<Integer> targetNumber = new ArrayList<>(getRandomNum());
            System.out.print(ASK_INPUT_NUMBER_MSG);
            List<Integer> inputNumber = new ArrayList<>(getInputNum());

        }while(restart());
    }

//  게임 재시작 여부
    private boolean restart(){
        System.out.println(ASK_RESTART_MSG);
        String UserInput = Console.readLine();
        return compareRestart(UserInput);
    }
    private boolean compareRestart(int UserInput){
        if(UserInput==RESTART_GAME_NUMBER) return true;
        if(UserInput==EXIT_GAME_NUMBER) return false;
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
        //예외상황
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
}