package baseball;
import camp.nextstep.edu.missionutils.Console;
public class InputNumber {
    private String inputNumber;

    public String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        if(checkInput(number))
            this.inputNumber = number;
        else throw new IllegalArgumentException("잘못된 형식의 입력입니다.");

        return inputNumber;
    }

    private boolean checkInput(String number){
        String tmp = "";

        if(number.length()!=3){
            return false;
        }
        else{
            try {
                Integer.parseInt(number);
            }catch (NumberFormatException e){
                return false;
            }
        }

        for (char c : number.toCharArray()) {
            if(c=='0'){
                return false;
            }
            if (!tmp.contains(String.valueOf(c))) {
                tmp += String.valueOf(c);
            }
            else return false;
        }
        return true;
    }
}
