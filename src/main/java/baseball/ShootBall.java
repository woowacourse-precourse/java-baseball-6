package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class ShootBall {
    private int[] numbers;

    //TODO:생성자 구현 -23.10.22
    ShootBall() {
        numbers = new int[10];
    }

    //TODO:(3)번 기능 구현 -23.10.22
    public void inputNumGenerator(){
        String input = Console.readLine();
        validNumInspect(input);
        int input_num;
        for(int i=0;i<3;i++){
            input_num = input.charAt(i) - '0';
            numbers[input_num]= i+1;
        }
    }

    //TODO:(2)번 기능 구현 -23.10.22
    private void randomNumGenerator(){
        int randNum;
        for(int i=1; i<=3;i++) {
            randNum = Randoms.pickNumberInRange(1, 9);
            numbers[randNum] = i;
        }
    }


    //TODO:(4)번 기능 구현 -23.10.22
    private void validNumInspect(String input){
        char tmp;
        //3개보다 많은 문자가 입력됐을 시
        if(input.length() != 3)
            throw new IllegalArgumentException("잘못된 입력입니다.");

        for(int i =0;i<3;i++){
            tmp = input.charAt(i);

            //정수형 외의 문자가 입력됐을 때
            if( tmp>'9'||tmp<'0')
                throw new IllegalArgumentException("잘못된 입력입니다.");

            //중복된 입력이 있을 때
            for(int j=i+1; j<3;j++){
                if(tmp==input.charAt(j))
                    throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

    }
}
