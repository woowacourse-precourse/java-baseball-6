package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


/*1. 숫자 형식
첫번째 자리,두번째 자리,세번째 자리를 나누어야함
문자열 표준 함수가 정의되어 있는 string 자료형으로 처리하는 것이 좋아보임
*/

public class Application {
    static void isThreeDigitNumbers(String input) {
        try {
            if(input.length()!=3) throw new IllegalArgumentException("범위 오류");
            char first=input.charAt(0);
            char middle=input.charAt(1);
            char last=input.charAt(2);
            if(first==middle || middle==last||last==first) throw new IllegalArgumentException("중복된 숫자 존재");
            int number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static void isDigit(String input){
        if (input.length()!=1) throw new IllegalArgumentException("길이가 1이 아님");
        try {
            int number=Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아님");
        }
    }
    static boolean checkAnswer(List<Integer> computer,String answer){
        String[] answer_splited=answer.split("");
        List<Integer> answer_int = new ArrayList<>();
        int strike = 0,ball=0;
        for (String c :answer_splited){
            answer_int.add(Integer.parseInt(c));
        }
        //정답 판정법? 일단 값과 위치가 같아야...
        for (int i=0;i<answer_int.size();i++){
            int cur_answer=answer_int.get(i);
            for(int j=0;j<computer.size();j++){
                if(cur_answer==computer.get(j)){
                    if(i==j) strike+=1;
                    if(i!=j) ball+=1;
                }
            }
        }
        if (ball > 0) System.out.print(ball+"볼 ");
        if(strike>0) System.out.print(strike+"스트라이크");
        if (strike == 0 && ball == 0) System.out.print("낫싱");
        System.out.println();//개행 문자 출력
        if(strike==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        };
        return false;
    }
    public static void main(String[] args) {
        // TODO: 숫자야구 프로그램 구현
        // 1. 숫자형식 구현
        // 2. 컴퓨터 랜덤 구현
        // 3. 정답 구현
        //에러판단 변수 정의
        boolean start=true;
        while (start){
            List<Integer> computer=new ArrayList<>();
            while (computer.size()<3){
                int randomNumber= Randoms.pickNumberInRange(1,9);
                if(!computer.contains(randomNumber)){
                    computer.add(randomNumber);
                }
            }
            System.out.println("숫자 야구 게임을 시작합니다.");
            //정답이라면 반복문 탈출
            //정답이 아니라면 반복
            boolean isnotAnswer=true;
            while (isnotAnswer) {
                System.out.println("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                //입력에서 잘못된 값 유형시 에러
                isThreeDigitNumbers(input);
                if(checkAnswer(computer,input)) isnotAnswer=false;
                if(!isnotAnswer){
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                    input=Console.readLine();
                    try {
                        if(!(Integer.parseInt(input)==1 ||Integer.parseInt(input)==2)) throw new IllegalArgumentException();
                        if(Integer.parseInt(input)==2) start=false;
                    }catch (Exception e){
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
    }

}
