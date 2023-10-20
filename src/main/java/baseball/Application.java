package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            int cnt=0; //게임 완전히 종료 여부 저장 변수
            List<Integer> computer = randomNumber(); //random 정답 생성

            while(true){
                List<Integer> user=userInput(); //사용자 input 받기
                resultOutput(score(computer,user)); //결과 계산 후 출력

                if (score(computer,user).get(1)==3){ //게임 종료
                    String checkEnd=endGame();
                    if (checkEnd.equals("2")) //게임 완전히 종료
                        cnt=1;
                    break;
                }

            }
            if (cnt==1) //게임 완전히 종료 확인
                break;
        }

    }
    public static List<Integer> randomNumber(){ //게임 정답을 랜덤으로 생성하는 함수
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
//        for (int i=0;i<3;i++)
//            System.out.print(computer.get(i));

        return computer;
    }
    public static List<Integer> userInput(){ //사용자 입력 함수
        List<Integer> user=new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");

        String number=camp.nextstep.edu.missionutils.Console.readLine();
        if (number.length()!=3)
            throw new IllegalArgumentException();//"3개의 수를 입력X"

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                int check = Character.getNumericValue(c);
                if (user.contains(check)){
                    throw new IllegalArgumentException();//"중복 숫자를 입력"
                }
                user.add(check);
            } else {//유효하지 않은 문자
                throw new IllegalArgumentException();//"유효하지 않은 문자"
            }
        }
        return user;
    }
    public static List<Integer> score(List<Integer> computer,List<Integer> user){ //계산 함수
        List<Integer> result=new ArrayList<>();

        List<Integer> diff=new ArrayList<>(computer);
        diff.removeAll(user);

        if(diff.size()==3){//숫자 3개가 없는 경우
            result.add(0); result.add(0);//낫싱
        }
        else if(diff.size()==0){ //숫자 3개가 포함된 경우
            if(computer.get(0)==user.get(0)&&computer.get(1)==user.get(1)){
                result.add(0); result.add(3); //3스트라이크
            }
            else if(computer.get(0)!=user.get(0)&&computer.get(1)!=user.get(1)&&computer.get(2)!=user.get(2)){
                result.add(3); result.add(0); //3볼
            }
            else{
                result.add(2);result.add(1);//2볼 1스
            }
        }
        else if(diff.size()==2){ //숫자 1개가 포함된 경우
            if((computer.get(0)==user.get(0))||(computer.get(1)==user.get(1))||(computer.get(2)==user.get(2))){
                result.add(0);result.add(1);//1스
            }
            else{
                result.add(1);result.add(0);//1볼
            }
        }
        else{ //숫자 2개가 포함된 경우
            if(computer.get(0)==user.get(0)){
                if(computer.get(1)==user.get(1)){
                    result.add(0);result.add(2);
                }
                if(computer.get(2)==user.get(2)){
                    result.add(0);result.add(2);
                }
                else{
                    result.add(1);result.add(1);
                }
            }
            else if(computer.get(1)==user.get(1)){
                if(computer.get(2)==user.get(2)){
                    result.add(0);result.add(2);
                }
                else{
                    result.add(1);result.add(1);
                }
            }
            else{
                result.add(2);result.add(0);
            }

        }
        return result;
    }
    public static void resultOutput(List<Integer> result){ //계산 결과 출력 함수
        if (result.get(0)!=0&&result.get(1)!=0){
            System.out.println(result.get(0)+"볼 "+result.get(1)+"스트라이크");
        }
        else if(result.get(0)==0&&result.get(1)==0){
            System.out.println("낫싱");
        }
        else if(result.get(0)!=0){
            System.out.println(result.get(0)+"볼");
        }
        else if(result.get(1)!=0){
            System.out.println(result.get(1)+"스트라이크");
        }
    }
    public static String endGame(){ //게임 종료 후 재시작 여부 확인 함수
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String checkEnd=camp.nextstep.edu.missionutils.Console.readLine();

        if (!checkEnd.equals("1")&&!checkEnd.equals("2"))
            throw new IllegalArgumentException();//"종료 문자 이상"

        return checkEnd;
    }

}
