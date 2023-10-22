package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        //입력 받은 123 -> [1,2,3]으로.
        //int[] answer = Stream.of(String.valueOf(computerNum).split("")).mapToInt(Integer::parseInt).toArray();
        //System.out.println(answer.toString());

        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        while(true){
            int myNum;
            myNum=insert();

            ArrayList<Integer> problem=toArray(myNum);

            int[] result;
            result=baseballGame(computer,problem);
            if(result[2]==1){
                System.out.println("낫싱");
            }else if(result[0]==3){
                System.out.println("3스르라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }else if(result[0]==0){
                System.out.println(result[1]+"볼");
            }else if(result[1]==0) {
                System.out.println(result[0] + "스트라이크");
            }else{
                System.out.println(result[1]+"볼 "+result[0]+"스트라이크" );
            }

        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int again=insert();
        if(again==1){

        }


    }
    public static int insert(){
        //Scanner sc=new Scanner(System.in);
        String num=null;
        try{
            num=readLine();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
        return Integer.parseInt(num);
    }
    public static ArrayList<Integer> toArray(int num){
        ArrayList<Integer> itArray = new ArrayList<Integer>();
        do{
            itArray.add(0,num % 10);
            num /= 10;
        } while  (num > 0);
        return itArray;
    }

    //answer는 computer 입력.
    //myNum은 내 입력.
    public static int[] baseballGame(ArrayList<Integer> answer, ArrayList<Integer> myNum){
        int strike=0;
        int ball=0;

        //strike, ball 없으면 nothing으로.
        //contain 사용 위해서.
        for(int i=0; i<answer.size(); i++){
            //숫자 가지고 있고&순서 맞고 -> strike
            if(answer.contains(myNum.get(i))&answer.get(i)==myNum.get(i)){
                strike++;
            }
            //숫자 가지고 있기만 하고 -> ball이니까.
            else if(answer.contains(myNum.get(i))){
                ball++;
            }
        }
        //길이 2인 배열
        int[] result=new int[3];
        if(strike==0&ball==0){
            int nothing=1;
            result[2]=nothing;
        } else{
            result[0]=strike;
            result[1]=ball;
        }

        return result;

    }

}
