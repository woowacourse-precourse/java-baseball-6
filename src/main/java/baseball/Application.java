package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        while(true) {
            List<Integer> randNum = makerand();
            System.out.println("숫자 야구 게임을 시작합니다.");

            while(true){
                System.out.println("숫자를 입력해주세요 :");

                /*try{

                }catch (IllegalArgumentException e){

                }*/

                String userInput = readLine();
                String[] inputStr = userInput.split(" ");
                List<Integer> inputNum = changeList(inputStr);
                List<Integer> resultNum = checkresult(randNum, inputNum);

                if((resultNum.get(0) == 0) & (resultNum.get(1) ==0)){
                    System.out.println("낫싱");
                }else{
                    if(resultNum.get(0) ==0){
                        System.out.println(resultNum.get(1)+"스트라이크");
                    }else if(resultNum.get(1) ==0){
                        System.out.println(resultNum.get(0)+"볼");
                    }else{
                        System.out.println(resultNum.get(0)+"볼 "+resultNum.get(1)+"스트라이크 ");
                    }
                }

                if(resultNum.get(1) ==3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String continueInput = readLine();
            if(Integer.parseInt(continueInput) == 2){break;}
        }
    }


    public static List<Integer> changeList(String[] inputNum){
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<3;i++){
            res.add(Integer.parseInt(inputNum[i]));
        }
        return res;
    }

    // 랜덤 숫자 생성
    public static List<Integer> makerand(){
        List<Integer> randnum = new ArrayList<>();
        //computer init
        while (randnum.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!randnum.contains(randomNumber)) {
                randnum.add(randomNumber);
            }
        }
        return randnum;
    }

    // 결과 출력
    public static List<Integer> checkresult(List<Integer> i1, List<Integer> i2){
//        System.out.println("checkresult\n");
//        System.out.println(i1);
//        System.out.println(i2);
        List<Integer> res = new ArrayList<>();
        res.add(0);res.add(0);res.add(0);

        for(int i=0;i<i1.size();i++){
            for(int j=0;j<i1.size();j++){
                if(i==j){
                    if(i1.get(i) == i2.get(j)){
                        res.set(1, res.get(1)+1);
                    }
                }else{
                    if(i1.get(i) == i2.get(j)){
                        res.set(0, res.get(0)+1);
                    }
                }
            }
        }

        return res;
    }

    //값 잘못 입력시
    public static boolean checkInput(String[]  array){
        if((array[0] != array[1]) & (array[0] != array[2])){
            if(array[1]!=array[2]){return true;}
            return false;
        }
        return false ;
    }
}
