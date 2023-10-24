package DTO;

import java.util.List;

public class ComputerDto {

	private List<Integer> computer;
	
	public List<Integer> getComputer() {
		return computer;
	}
	public ComputerDto() {
		this.computer = new baseball.ProcessMembers().getRandomNumbers();
	}
}
