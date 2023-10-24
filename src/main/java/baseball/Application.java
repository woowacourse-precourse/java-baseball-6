package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Application {
    static ArrayList<Integer> userNum = new ArrayList<>();

    public static void main(String[] args)
    {
        ArrayList<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        int strikeCnt=0, ballCnt=0; // 스트라이크, 볼 카운트 변수
        while(true){ // 게임 전체 반복
            while(computer.size()<3){ // 중복되지 않는 3개의 난수 생성
                int randomNumber = Randoms.pickNumberInRange(1,9);
                if(!computer.contains(randomNumber)){
                    computer.add(randomNumber);
                }
            }// while end

            while(true){ // 게임 시작
                //사용자로부터 3개의 정수를 입력받는다.

                System.out.print("숫자를 입력해주세요 : ");
                int userNumber=0;
                try{
                    String num = Console.readLine();
                    userNumber = Integer.parseInt(num);
                }catch(NumberFormatException e) {
                    throw new IllegalArgumentException();
                }

                setUserList(userNumber);
                int com1,com2,com3;
                int user1,user2,user3;
                com1=computer.get(0);
                com2=computer.get(1);
                com3=computer.get(2);
                user1=userNum.get(0);
                user2=userNum.get(1);
                user3=userNum.get(2);
                if(user1==0 || user2==0 || user3==0){
                    throw new IllegalArgumentException();
                } // 0을 입력했을 경우 예외 처리
                if(user1 == user2 || user1 == user3 || user2 == user3){
                    throw new IllegalArgumentException();
                } // 중복되는 수를 입력했을 경우 예외처리

                // 스트라이크인 경우
                if(com1==user1) strikeCnt++;
                if(com2==user2) strikeCnt++;
                if(com3==user3) strikeCnt++;
                // 볼인 경우
                if(com1==user2 || com1==user3) ballCnt++;
                if(com2==user1 || com2==user3) ballCnt++;
                if(com3==user1 || com3==user2) ballCnt++;

                if(strikeCnt==3){
                    System.out.printf("%d스트라이크\n",strikeCnt);
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                else{
                    if(strikeCnt==0 && ballCnt==0){
                        System.out.println("낫싱");
                    }
                    else if(ballCnt>0 && strikeCnt>0){
                        System.out.printf("%d볼 %d스트라이크\n",ballCnt,strikeCnt);
                    }
                    else if(ballCnt>0){
                        System.out.printf("%d볼\n",ballCnt);
                    }
                    else if(strikeCnt>0 && strikeCnt<3){
                        System.out.printf("%d스트라이크\n",strikeCnt);
                    }

                    strikeCnt=0;
                    ballCnt=0;
                    userNum.clear();
                }

            }//while end
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String num = Console.readLine();
            Console.close();
            int number = Integer.parseInt(num);
            if(number==2){
                return;
            }
            else if(number==1){
                strikeCnt=0;
                ballCnt=0;
                userNum.clear();
                computer.clear();
            }
         }

     }
    public static void setUserList(int num)
    {
        int newNum=num;
        userNum.add(newNum/100);
        newNum=newNum%100;
        userNum.add(newNum/10);
        newNum=newNum%10;
        userNum.add(newNum);
        newNum= 0;
    }
}

