package baseball;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Baseball{
    private CreateComputerNumber createComputerNumber;
    private InputUserNumber inputUserNumber;
    public void playball(){
        List<Integer> computer;
        List<Integer> user;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            createComputerNumber = CreateComputerNumber.createComputerNumber();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                inputUserNumber = InputUserNumber.inputUSerNumber();
                computer = createComputerNumber.getComputer();
                user = inputUserNumber.getUser();
                if (strikeBall(user, computer)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            if(!reGame())
                break;
        }

    }


    public boolean strikeBall(List<Integer> user, List<Integer> computer){
        int strike = 0, ball = 0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(user.get(i) == computer.get(j)){
                    if(i==j) strike +=1;
                    else ball +=1;
                }
            }
        }


        if(strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        else {
            if(strike == 0 && ball == 0)
                System.out.println("낫싱");
            else if(strike == 0 && ball != 0)
                System.out.println(ball + "볼");
            else if(strike != 0 && ball == 0)
                System.out.println(strike + "스트라이크");
            else System.out.println(ball + "볼 " + strike + "스트라이크");
            return false;
        }
    }

    public boolean reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        int number = isNum(input);

        if(number != 1 && number != 2)
            throw new IllegalArgumentException();

        if(number == 1) return true;
        if(number == 2) return false;


        return false;
    }

    public static int isNum(String input){
        try{
            int num = Integer.parseInt(input);
            return num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }


}