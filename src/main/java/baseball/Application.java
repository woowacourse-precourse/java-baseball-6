package baseball;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;




public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer>computerNumber=new Init().getComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            CheckException checkException = new CheckException();

            try {
                if (checkException.error(userInput)) throw new IllegalArgumentException();
            }catch(IllegalArgumentException e){
                break;
            }

            int strike=0,ball=0;
            for (int i=0; i<userInput.length(); i++){
                int digit=Character.getNumericValue(userInput.charAt(i));
                if(digit==computerNumber.get(i)) strike++;
                else if (computerNumber.contains(digit)) ball++;
            }

            if(strike+ball==0)System.out.println("낫싱");
            else {
                if(ball>0) System.out.print(ball+"볼 ");
                if(strike>0)System.out.print(strike+"스트라이크");
                System.out.println();
            }

            boolean error=false;
            if(strike==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String continueOrEnd=Console.readLine();
                if(continueOrEnd.length()!=1) error=true;

                for (int i=0; i<continueOrEnd.length(); i++){
                    if(continueOrEnd.charAt(i)!='1' && continueOrEnd.charAt(i)!='2') {
                        error=true;
                        break;
                    }
                }


                try {
                    if (error) throw new IllegalArgumentException();
                }catch(IllegalArgumentException e){
                    break;
                }

                if(continueOrEnd.charAt(0)=='1'){
                    computerNumber.clear();
                    while (computerNumber.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computerNumber.contains(randomNumber)) {
                            computerNumber.add(randomNumber);
                        }
                    }
                }
                else if(continueOrEnd.charAt(0)=='2'){
                    break;
                }
            }
        }

    }
}
