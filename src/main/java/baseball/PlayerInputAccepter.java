package baseball;

	import java.util.ArrayList;
	import java.util.List;
	import camp.nextstep.edu.missionutils.*;
	
public class PlayerInputAccepter {
	String ReadNum;
	List<Integer> PlayerInput;
	
	public void InputUserNum(String input) {//사용자의 INPUT을 List화
		List<Integer> PlayerInput = new ArrayList<>();
		String[] SplitInput = input.split("");
		
		for(String s : SplitInput) {
			PlayerInput.add(Integer.parseInt(s));
		}
		this.PlayerInput = PlayerInput;
	}
	
	public void ReadNumber() {//입력값 받기
		ReadNum = Console.readLine();
	}
}

