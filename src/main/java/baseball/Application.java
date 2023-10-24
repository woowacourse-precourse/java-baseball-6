package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer=ComputerInputNum();
        int Game = 0;
        do{
            List<Integer> user = UserInputNum();
            System.out.println("com"+computer);
            System.out.println("user"+user);
            Game = Game(computer,user);
            if(Game==2){
                break;
            }
            if(Game == 3){
                computer = ComputerInputNum();
            }
        }while(true);

    }


    private static int Game(List<Integer> computer, List<Integer> user){
        int ball = CountBall(user,computer);
        int strike = CountStrike(user,computer);
        if(ball == 0 && strike ==0) System.out.println("낫싱");
        if(ball == 0 && strike != 0) System.out.println(strike+"스트라이크");
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return reGame(computer);
        };
        if(ball != 0 && strike != 0){
            System.out.println(ball+"볼"+" "+strike+"스트라이크");
        }
        if(strike ==0 && ball != 0) System.out.println(ball+"볼");

        return 1;
    }
    private static int reGame(List<Integer> com){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int s = Integer.parseInt(Console.readLine());

        if(s == 2 ) return 2;
        return 3;
    }
    private static List<Integer> ComputerInputNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static List<Integer> UserInputNum(){
        List<Integer> user ;
        System.out.print("숫자를 입력해주세요 : ");
        String us = Console.readLine();
        if(us.length() != 3){
            throw new IllegalArgumentException();
        }
        user = IntToString(us);
        return user;
    }

    private static List<Integer> IntToString(String a){
        List<Integer> r_user = new ArrayList<>();
        // '0'을 통해 '1' ~ '9' 까지 숫자로 변환
        for(int i=0 ; i<3 ; i++){
            r_user.add(a.charAt(i)-'0');
        }

        return r_user;
    }

    private static boolean compareNum(int user, int com){
        if(user == com)
            return true;

        return false;
    }

    private static int CountBall(List<Integer> user, List<Integer> com){
        int ball=0;
        for(int i=1 ; i<3 ; i++){
            if(compareNum(user.get(0),com.get(i)))
                ball++;
        }
        for(int i=0 ; i<3 ; i++){
            if(i !=1 && compareNum(user.get(1),com.get(i)))
                ball++;
        }
        for(int i=0 ; i<2 ; i++){
            if( compareNum(user.get(2),com.get(i)))
                ball++;
        }

        return ball;
    }
    private static int CountStrike(List<Integer> user, List<Integer> com){
        int strike=0;

        for(int i=0 ; i<3 ;i++){
            if(user.get(i).equals(com.get(i))){
                strike++;
            }
        }

        return strike;
    }
}
