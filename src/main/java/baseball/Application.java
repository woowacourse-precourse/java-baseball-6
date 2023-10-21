package baseball;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;




public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumber= new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            boolean error=false;
            if(userInput.length()!=3) error=true;
            else{
                for (int i=0; i<userInput.length(); i++){
                    if(userInput.charAt(i)<'1' || userInput.charAt(i)>'9') {
                        error = true;
                        break;
                    }
                }

                List<Integer>numberCount = new ArrayList<>();
                for (int i=0; i<=9; i++){
                    numberCount.add(0);
                }
                for (int i=0; i<userInput.length(); i++){
                    int digit=Character.getNumericValue(userInput.charAt(i));
                    numberCount.set(digit,numberCount.get(digit)+1);
                }

                for (int i=1; i<=9; i++){
                    if(numberCount.get(i)>1) {
                        error = true;
                        break;
                    }
                }
            }

            try {
                if (error) throw new IllegalArgumentException();
            }catch(IllegalArgumentException e){
                break;
            }


        }

    }
}
