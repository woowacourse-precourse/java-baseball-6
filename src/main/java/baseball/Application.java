package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    static void game(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        Set<Integer> computerSet = new HashSet<>();

        //computer의 랜덤 숫자 생성 후 List와 Set에 add 함.
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                computerSet.add(randomNumber);
            }
        }

        while(true){

            //user의 숫자를 입력 받는다.
            System.out.print("숫자를 입력해주세요 : ");
            String n = Console.readLine();


            //숫자 길이가 3이 아닌경우
            if(n.length()!=3){
                throw new IllegalArgumentException();
            }

            //중복 숫자가 입력된 경우
            if(n.charAt(0)==n.charAt(1)||n.charAt(0)==n.charAt(2)||n.charAt(1)==n.charAt(2)){
                throw new IllegalArgumentException();
            }

            //숫자가 아닌 문자를 입력하는 경우
            Integer[] nums = {1,2,3,4,5,6,7,8,9};
            Set<Integer> numberSet = new HashSet<>(Arrays.asList(nums));
            for(int i=0;i<3;i++){
                if(!numberSet.contains(Character.getNumericValue(n.charAt(i)))){
                    throw new IllegalArgumentException();
                }
            }

            //List에 넣는다.
            List<Integer> user = new ArrayList<>();
            for(int i=0;i<3;i++){
                user.add(Character.getNumericValue(n.charAt(i)));
            }

            //스트라이트 개수를 카운팅 한다.
            int strikeCnt = 0;
            for(int i=0; i<3 ; i++){
                //if(computer.get(i) == user.get(i)) strikeCnt++;
                if(computer.get(i).equals(user.get(i))) strikeCnt++;
            }

            //컴퓨터의 숫자와 유저의 숫자가 몇개가 같은지 카운팅한다.
            int sameNumCnt=0;
            for(int i=0; i<3 ; i++){
                if(computerSet.contains(user.get(i))) sameNumCnt++;
            }

            //스크라이크, 볼, 낫싱을 판단 후 출력한다.
            if(strikeCnt == 0 && sameNumCnt == 0) System.out.println("낫싱");
            else if(strikeCnt == 0) System.out.printf("%d볼%n",sameNumCnt-strikeCnt);
            else if(sameNumCnt-strikeCnt == 0) System.out.printf("%d스트라이크%n",strikeCnt);
            else System.out.printf("%d볼 %d스트라이크%n",sameNumCnt-strikeCnt,strikeCnt);

            //스트라이크가 3개 인것 판단
            if(strikeCnt==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while(true){

            game();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String answer = Console.readLine();

                if(answer.equals("1")){
                    continue;
                }
                if(answer.equals("2")){
                    break;
                }
                //1 또는 2가 아니면 IllegalArgumentException이 throw된다.
                throw new IllegalArgumentException();

            }

        }




    }

