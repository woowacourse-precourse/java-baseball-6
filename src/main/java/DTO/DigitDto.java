package DTO;

public class DigitDto {

	private int first_digit;
	private int second_digit;
	private int third_digit;

	public int getFirst_digit() {
		return first_digit;
	}
	public int getSecond_digit() {
		return second_digit;
	}
	public int getThird_digit() {
		return third_digit;
	}
	public DigitDto(int first_digit,int second_digit,int third_digit) {
		this.first_digit=first_digit;
		this.second_digit=second_digit;
		this.third_digit=third_digit;
	}
}
