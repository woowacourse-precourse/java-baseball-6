package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        int cnt = 3;
        boolean going = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(going){
            int[]answer = new int[cnt];
            boolean wrong = true;

            //랜담으로 3가지 숫자 지정
            for(int i=0; i<cnt; i++){
                answer[i] = Randoms.pickNumberInRange(1,9);
            }
            while(wrong){
                int strike = 0;
                int ball = 0;
                String result = "";

                System.out.println("숫자를 입력해주세요 :");
                String reply = Console.readLine();

                //답변 숫자가 3개가 아닐경우 Exception
                if(reply.length()!=3){
                    throw new IllegalArgumentException();
                }

                //스트라이크, 볼 체크
                for(int ri=0; ri<cnt; ri++){
                    for(int ai=0; ai<cnt; ai++){
                        int rindex = reply.charAt(ri) - '0';

                        //답변숫자는 1~9지만 0이 나올 경우 Exception 이란 말은 없다..
                        //if(rindex==0){
                        //    throw new IllegalArgumentException();
                        //}

                        if(answer[ai]==rindex){
                            if(ai==ri){
                                strike+=1; //위치가 일치할 경우 스트라이크
                            }
                            if(ai!=ri){
                                ball+=1; //위치가 다를 경우 볼
                            }
                        }
                    }
                }

                if(ball>0){
                    result += ball+"볼 ";
                }
                if(strike>0){
                    result += strike+"스트라이크";
                }
                if(result.isEmpty()){
                    result = "낫싱";
                }

                System.out.println(result.trim());

                //숫자가 일치하는 경우 게임 종료
                if(strike==3){
                    wrong = false;
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());

            if(choice!=1&&choice!=2){
                throw new IllegalArgumentException(); //입력값이 1 또는 2가 아닐 경우 Exception 발생
            }

            if(choice==2){
                going = false;
            }
        }

    }
}
