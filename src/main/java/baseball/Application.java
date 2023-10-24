package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int flag=1, user_input;
        List<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            computer.clear();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            for(;;){
                System.out.print("숫자를 입력해주세요 : ");
                user_input= Integer.parseInt(Console.readLine());
                int a=user_input/100;
                int b=(user_input%100)/10;
                int c=user_input%10;
                if(user_input>987||user_input<123||a==b||b==c||a==c){
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
                if(computer.contains(a)||computer.contains(b)||computer.contains(c)){
                    if(computer.contains(a)){
                        if(computer.contains(b)){
                            if(computer.contains(c)){
                                if(computer.get(0)==a){
                                    if(computer.get(1)==b){
                                        System.out.println("3스트라이크");
                                        break;
                                    }else System.out.println("2볼 1스트라이크");
                                } else if (computer.get(1)==b)System.out.println("2볼 1스트라이크");
                                else {
                                    if(computer.get(2)==c)System.out.println("2볼 1스트라이크");
                                    else System.out.println("3볼");
                                }
                            }
                            else if(computer.get(0)==a){
                                if(computer.get(1)==b)System.out.println("2스트라이크");
                                else System.out.println("1볼 1스트라이크");
                            }
                            else if(computer.get(1)==b)System.out.println("1볼 1스트라이크");
                            else System.out.println("2볼");
                        } else if(computer.contains(c)){
                            if(computer.get(0)==a){
                                if(computer.get(2)==c)System.out.println("2스트라이크");
                                else System.out.println("1볼 1스트라이크");
                            } else if (computer.get(2)==c)System.out.println("1볼 1스트라이크");
                            else System.out.println("2볼");
                        }else{
                            if(computer.get(0)==a)System.out.println("1스트라이크");
                            else System.out.println("1볼");
                        }

                    } else if (computer.contains(b)) {
                        if(computer.contains(c)){
                            if(computer.get(1)==b){
                                if(computer.get(2)==c)System.out.println("2스트라이크");
                                else System.out.println("1볼 1스트라이크");
                            } else {
                                if(computer.get(2)==c)System.out.println("1볼 1스트라이크");
                                else System.out.println("2볼");
                            }
                        }
                        else{
                            if(computer.get(1)==b)System.out.println("1스트라이크");
                            else System.out.println("1볼");
                        }
                    }
                    else {
                        if(computer.get(2)==c)System.out.println("1스트라이크");
                        else System.out.println("1볼");
                    }
                }
                else{
                    System.out.println("낫싱");
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            flag=Integer.parseInt(Console.readLine());
        }while (flag==1);
    }
}
