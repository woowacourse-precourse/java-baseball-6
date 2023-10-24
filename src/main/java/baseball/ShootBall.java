package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class ShootBall {
    final private int[] numbers;

    //(1)생성자 구현
    ShootBall() {
        numbers = new int[10];
    }

    //(3)번 기능
    public void inputNumGenerator(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validNumInspect(input);
        int input_num;
        for(int i=0;i<3;i++){
            input_num = input.charAt(i) - '0';
            numbers[input_num]= i+1;
        }
    }

    //(2)번 기능
    public void randomNumGenerator(){
        int randNum;
        for(int i=1; i<=3;i++) {
            randNum = Randoms.pickNumberInRange(1, 9);
            numbers[randNum] = i;
        }
    }


    //(4)번 기능 구현
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

    //(5)번 기능 구현
    public int[] getNumbers(){return numbers;}
    public boolean baseballReferee(ShootBall inputBall){
        int strike=0,ball=0;
        boolean result = false;
        int[] inputNumbers = inputBall.getNumbers();
        for(int i=1;i<=9;i++){
            if((numbers[i] & inputNumbers[i])!=0)
                if(numbers[i] == inputNumbers[i])
                    strike++;
                else
                    ball++;
        }
        if(ball !=0)
            System.out.print(ball+"볼 " );
        if(strike !=0)
            System.out.print(strike+"스트라이크");
        if(ball==0 && strike==0)
            System.out.print("낫싱");
        if(strike==3){
            result = true;
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.print("\n");
        return result;
    }
}
