package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] arg) {
        String loopCheck = "1"; // 정답을 모두 맞추었을시 1 또는 2를 입력받아 사용자가 게임을 다시 할지 말지 확인하는 변수,

        while (loopCheck.equals("1"))
        {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Number computer = new Number(); // 파라미터가 없는 Number 클래스 생성
            String answerCheck = ""; //사용자가 정답을 맞추었는지 못 맞추었는지 확인 하는 변수
            while (true)
            {
                System.out.printf("숫자를 입력해주세요 : ");
                String userInput = Console.readLine(); //사용자가 입력한 정보를 String으로 받음
                Number user = new Number(userInput); // 사용자가 입력한 값을 Number클래스 생성

                answerCheck = 게임종료_후_재시작(computer.getCardList(), user.getCardList()); // 컴퓨터와 유저의 카드(숫자)리스트를 전달.
                System.out.println(answerCheck); // 결과 출력

                if (answerCheck.equals("3스트라이크")){ // 만약 결과가 3스트라이크 라면 게임 종료
                    break;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"); // 게임을 계속할지 안할지 입력 받기.
            loopCheck = Console.readLine();
        }
    }

    public static String 게임종료_후_재시작(List<Integer> computer , List<Integer>user)
    {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3 ;++i)
        {
            int number = user.get(i); // i번째 index의 값을 받음
            if (computer.contains(number)) // user가 예측한 숫자가 computer가 뽑은 리스트에 있다면 ball 혹은 strike 임
            {
                int computerIndex = computer.indexOf(number); // computer 리스트에서 number가 존재하는 index를 추출
                if (computerIndex == i) // 현재 비교하고 있는 i와 computerIndex가 같다면 같은 위치에 있는 같은 숫자이기 때문에 strike
                {
                    strike += 1;
                }else{
                    ball += 1; // index가 다르마면 ball
                }
            }
        }
        if(ball==0 && strike==0) { // 예측 결과에 따라 출력 결과가 다르기 때문에 상황에 맞게 출력.
            return "낫싱";
        }else if (ball == 0){
            return strike+"스트라이크";
        }else if(strike == 0)
        {
            return ball+"볼";
        }else{
            return ball+"볼 "+strike+"스트라이크";
        }
    }


}
class Number{
    private List<Integer> cardList = new ArrayList<>();

    public Number() { // 생성자 매개변수 없이 들어오면 컴퓨터가 랜덤으로 생성하는 숫자를 의미
        while(cardList.size() < 3) // 3번 반복
        {
            int randomNumber = Randoms.pickNumberInRange(1,9); //1~9 까지 랜덤한 숫자 입력
            if(!cardList.contains(randomNumber)) // 중복되는 값이 들어가면 안되기 때문에 contains로 확인
            {
                cardList.add(randomNumber);
            }
        }
    }

    public Number(String userInput) // 유저가 입력한 String을 매개변수로 Number클래스를 생성하는 생성자.
    {
        if (userInput.length() != 3) // 유저가 입력한 글자의 길이가 3글자인지 검증
        {
            throw new IllegalArgumentException();
        }
        for (int i  =0;i < 3;++i)
        {
            if(Character.isDigit(userInput.charAt(i))) // 사용자가 입력한 정보가 숫자인지 아닌지 검증.
            {
                int number = userInput.charAt(i)-'0';
                cardList.add(number);
            }else{
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getCardList() {
        return cardList;
    }
}


