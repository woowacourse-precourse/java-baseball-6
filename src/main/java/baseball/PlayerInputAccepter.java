package baseball;

	import java.util.ArrayList;
	import java.util.List;
	import camp.nextstep.edu.missionutils.*;
	
public class PlayerInputAccepter {
	String ReadNum;
	List<Integer> PlayerInput;
	
	public void InputUserNum(String input) {
		List<Integer> PlayerInput = new ArrayList<>();
		String[] SplitInput = input.split("");
		
		for(String s : SplitInput) {
			PlayerInput.add(Integer.parseInt(s));
		}
		this.PlayerInput = PlayerInput;
	}
	
	public void ReadNumber() {
		ReadNum = Console.readLine();
	}
}

