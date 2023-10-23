package baseball;

import java.util.List;

import DTO.ComputerDto;
import camp.nextstep.edu.missionutils.Console;

public class Game {

	private final ProcessMembers proc=new ProcessMembers();
	private String result;
	//private List<Integer> computer;
	
	public void runGame() {

		DTO.ComputerDto com=new ComputerDto();
		this.result="";
    	
    	while(!this.result.equals("3스트라이크")) {
    		
    		System.out.printf("숫자를 입력해주세요 : ");
    		String input=Console.readLine();
    		
    		if(new EncouterException(input).getFlag())
    			return;
	    	
	    	this.result=proc.inspection(com.getComputer(),input);
    		//this.result=proc.inspection(this.computer,input);
	    	
	    	System.out.println(this.result);
	    	
	    	rerun_or_stop(this.result);
    	}
	}
	
	public void rerun_or_stop(String result) {
		
		if(result.equals("3스트라이크"))
	    	new ReplayDecision();
	}
}
