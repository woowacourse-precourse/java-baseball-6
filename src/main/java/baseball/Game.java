package baseball;

import DTO.ComputerDto;
import camp.nextstep.edu.missionutils.Console;

public class Game {

	private final ProcessMembers proc=new ProcessMembers();
	private final String init_result="";
	
	public void runGame() {

		DTO.ComputerDto com=new ComputerDto();
		String result=init_result;

		iterater(result,com);
	}
	
	public void iterater(String result,ComputerDto com) {
		
		while(!result.equals("3스트라이크")) {

			result=answer(com,validInput());
	    	rerun_or_stop(result);
    	}
	}
	
	public String validInput() {
		
		System.out.printf("숫자를 입력해주세요 : ");
		String input=Console.readLine();
		
		new EncouterException(input);
		
		return input;
	}
	
	public String answer(ComputerDto com,String input) {
		
		String result=proc.inspection(com.getComputer(),input);
    	System.out.println(result);
    	
    	return result;
	}
	
	public void rerun_or_stop(String result) {
		
		if(result.equals("3스트라이크"))
	    	new ReplayDecision();
	}
}
