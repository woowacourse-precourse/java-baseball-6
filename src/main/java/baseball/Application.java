package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    //올바른 입력값 체크
    public static List<Integer> check(String num){
        //세자리 수 판별
        if(num.length()>3){
            throw new IllegalArgumentException("3자리를 입력하십시오");
        }
        //숫자가 아닐 경우 판별
        try{
            Integer.parseInt(num);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력하십시오");
        }
        //입력 숫자 정수리스트화
        List<Integer> realNumber = new ArrayList<>();
        for(int i=0; i<3; i++) {
            int slice = (int)num.charAt(i)-'0';
            if(!realNumber.contains(slice)){
                realNumber.add(slice);
            }
        }
        //중복판별
        if (realNumber.size()!=3){
            throw new IllegalArgumentException("중복되지 않는 수를 입력하십시오");
        }
        //System.out.println(realNumber); //함수 최종 체크용
        return realNumber;
    }

    public static void game(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        //System.out.println(computer); //테스트용 컴퓨터 배열 확인

        System.out.println("숫자 야구 게임을 시작합니다.");
        int repeat = 0;
        while (repeat==0) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            List<Integer> realNumber = check(inputNumber);

            int strike = 0;
            int ball = 0;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(realNumber.get(i).equals(computer.get(j))){
                        if(i==j){
                            strike++;
                        }
                        else {
                            ball++;
                        }
                    }
                }
            }

            if (ball==0 && strike==0) {
                System.out.println("낫싱");
            } else if (ball==0 && strike!=3) {
                System.out.println(strike + "스트라이크");
            } else if (strike==0) {
                System.out.println(ball + "볼");
            } else if (strike==3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                repeat = 1;
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String power = Console.readLine();
        switch (power){
            case "1" :
                game();
                break;
            case "2" :
                break;
            default:
                throw new IllegalArgumentException("올바른 명령어를 입력하십시오");
        }
    }

    public static void main(String[] args) {
        game();
    }
}
