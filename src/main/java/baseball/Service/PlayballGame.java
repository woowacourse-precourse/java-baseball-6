package baseball.Service;
import baseball.View.UserInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class PlayballGame {



    //set게임
    public static String createRandomNumbers(){
        String numbers = null;
        while(numbers.length() != 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1,9));
            while (numbers.contains(randomNumber)) {
                randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            }
            numbers += randomNumber;
        }
        return numbers;
    }

    String computernumber = createRandomNumbers();

    //사용자 입력받기
    public static String requestInput()throws IllegalArgumentException {
        UserInput.askUserInput();
        String inputNumbers = Console.readLine();
        //예외. 3자리 수인가?
        if(inputNumbers.length()!=3){
            throw new IllegalArgumentException();
        }
        return inputNumbers;
    }

    String usernumbers = requestInput();
    int strike = 0;
    int ball = 0;

    public void gameplay(String usernumbers,String computernumber){


        //computernumber와 inputNumbers를 비교하여 힌트 모으기
        for(int i=0;i<usernumbers.length();i++){
            for(int j=0;usernumbers.length();i++){
                if(computernumber[i] == usernumbers[j] && i ==j){
                    strike +=1;
                    break;
                }
                if(computernumber[i] == usernumbers[j] && i != j){
                    ball +=1;
                    break;
                }
            }
        }

        //힌트 출력
        if(strike ==0 && ball==0){
            System.out.println("낫싱");
        }
        if(strike !=0 | ball !=0){
            System.out.println(strike + "스트라이크" + ball + "볼");
        }

        if(strike == 3){
            System.out.println("3스트라이크 정답을 맞추셨습니다.");
        }
    }




}
