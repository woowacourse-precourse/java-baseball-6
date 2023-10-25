package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class Application {
    static boolean cmd = true;

    public static void main(String[] args)throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다");

        //게임시작
        cmd=true;
        while(cmd) {
            ArrayList<Integer> num = new ArrayList<Integer>();
            while (num.size() < 3) {
                int ran_num = Randoms.pickNumberInRange(1, 9);
                if (!num.contains(ran_num)) {
                    num.add(ran_num);
                }
            }
            //System.out.println(num);
            //입력받아서 스트라이크와 볼 개수 맞추기
            while (true) {
                int strike = 0;
                int ball = 0;


                System.out.print("숫자를 입력해주세요 : ");
                String ask;
                //System.out.println(ask.length());

                //예외발생
                try {
                    ask=Console.readLine();
                    check(ask);
                } catch (IllegalArgumentException e) {
                    // 예외 발생시 프로그램 종료
                    cmd=false;
                    throw e;

                }

                //입력
                String[] ask_array = ask.split("");

                //입력값 정수형으로 변환
                ArrayList<Integer> user_num = new ArrayList<Integer>();
                for (int i = 0; i < 3; i++) {
                    user_num.add(Integer.parseInt(ask_array[i]));
                }

                //스트라이크와 볼 개수
                for (int i = 0; i < 3; i++) {
                    if (num.get(i) == user_num.get(i)) {
                        strike++;
                    } else if (num.contains(user_num.get(i))) {
                        ball++;
                    }
                }

                //결과출력
                if ((strike == 0) && (ball == 0)) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(((ball != 0) ? ball + "볼 " : "") + ((strike != 0) ? strike + "스트라이크" : ""));
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int restart = Integer.parseInt(Console.readLine());
                    if (restart == 1) {
                        break;
                    } else if (restart == 2) {
                        cmd = false;
                        break;
                    }
                }
            }
            // TODO: 프로그램 구현
        }

    }

    //예외사항
    public static void check(String ask) throws IllegalArgumentException{
        if(ask.length()!=3) {
            cmd=false;
            throw new IllegalArgumentException();
        } else if ((ask.charAt(0)<123)&&(ask.charAt(0)>64))  {
            throw new IllegalArgumentException();
        }else if ((ask.charAt(1)<123)&&(ask.charAt(1)>64))  {
            throw new IllegalArgumentException();
        }else if ((ask.charAt(2)<123)&&(ask.charAt(2)>64))  {
            throw new IllegalArgumentException();
        }
    }

}
