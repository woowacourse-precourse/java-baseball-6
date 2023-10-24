package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class Baseball_Model {

    private static final int Strike_Count = 3;

    private List<Integer> Computer_Number;

    private List<Integer> Random_Number(){ // README.md 2.
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public Baseball_Model(){ // README.md 1.
        this.Computer_Number = Random_Number();
    }

    public boolean Check_Input(String Input){ // README.md 3.
        return Input.length() == Strike_Count && Input.chars().distinct().count() == Strike_Count;
    }

    public List<Integer> Input_To_Number(String Input){ // README.md 4.
        List<Integer> User_Number = new ArrayList<>();
        for(char ch : Input.toCharArray()){
            User_Number.add(Character.getNumericValue(ch));
        }
        return User_Number;
    }

    public String Play(String User_Input){ // README.md 5.
        if(!Check_Input(User_Input)){
            throw new IllegalArgumentException("사용자 입력 오류");
        }
        List<Integer> User_Number = Input_To_Number(User_Input);

        int strike = 0;
        int ball = 0;

        for(int i=0; i<Strike_Count; i++){
            if(Computer_Number.get(i).equals(User_Number.get(i))){
                strike++;
            }
            else if(Computer_Number.contains(User_Number.get(i))){
                ball++;
            }
        }

        if(strike == Strike_Count){
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if(strike == 0 && ball == 0){
            return "낫싱";
        }
        return (ball > 0 ? ball + "볼 " : "") + (strike > 0 ? strike + "스트라이크" : "");
    }
}
