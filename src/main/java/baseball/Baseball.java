package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Baseball {

    private List<Integer> computer; // 컴퓨터가 생성할 서로다른 3개의 숫자 변수
    private List<Integer> overlap; // 사용자가 입력하는값에 중복된 숫자가 있는지 검사하기 위한 변수
    private int[] result = new int[2]; // strike, ball의 수 저장 변수
    private boolean flag; // 게임 지속 여부 변수

    private List<Integer> setNum(){ // 컴퓨터가 숫자를 생성해주는 함수
        List<Integer> num = new ArrayList<>();

        while (num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }

    private int[] inputNum(){ // 숫자 입력 및 st

        int[] stba = {0, 0}; // strike, ball의 수 저장 변수
        this.overlap = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();

        //입력값이 3자리수인지 체크
        if(str.length()!=3){
            throw new IllegalArgumentException("Invalid argument: "+str);
        }

        for(int i=0; i<3; i++){
            int num = (int) str.charAt(i)-'0';

            //입력값이 정상적인지 체크
            if (num> 9 || num < 1 || overlap.contains(num)){
                throw new IllegalArgumentException("Invalid argument: "+str);
            }
            overlap.add(num);

            //스트라이크와 볼의 수 카운트
            if (computer.get(i) == num){
                stba[0]++;
            } else if (computer.contains(num)) {
                stba[1]++;
            }
        }
        return stba;

    }
    // strike와 볼의 수에 따른 출력 함수
    private boolean printResult(int[] result){
        if (result[0] == 0 && result[1] == 0){
            System.out.println("낫싱");
        } else if (result[0] == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choose = Console.readLine();

            //입력값이 정상적인지 체크와 게임을 다시 진행할지의 여부
            if (choose.equals("1")) {
                computer = setNum();
            } else if(choose.equals("2")){
                return false;
            }else {
                throw new IllegalArgumentException("Invalid argument: "+choose);
            }
        } else if (result[0] == 0) {
            System.out.printf("%d볼\n",result[1]);
        } else if (result[1] == 0) {
            System.out.printf("%d스트라이크\n",result[0]);
        } else {
            System.out.printf("%d볼 %d스트라이크\n",result[1],result[0]);
        }
        return true;
    }

    //숫자야구 진행 함수
    public void playBaseball(){

        computer = setNum(); // 랜덤의 서로다른 숫자 생성

        do {
            result = inputNum(); //사용자의 입력값에 따른 strike, ball의 수 반환
            flag = printResult(result); //스트라이크와 볼의 수에 따른 출력 및 게임 진행 여부
        }while (flag);
    }

}
