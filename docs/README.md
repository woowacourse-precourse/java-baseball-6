# class Computer
- 변수
	- randomList : 생성된 수가 순서대로 저장되는 배열이다. index로 접근 가능하도록 하기 위해 ArrayList를 이용했다.
    - randomSet : 볼 판정(숫자가 포함되어 있는지)을 빠르게 하기 위해 Set을 이용했다.
- 메서드  
    - generate : 1-9 사이의 난수를 생성해 randomSet에 들어있지 않으면 추가한다. randomList의 길이가 3이 될 때까지 반복한다.
    - get : 입력으로 index를 받아 randomList의 index번째 값을 반환한다.
    - contains : 입력값이 randomSet에 존재하면 true, 존재하지 않으면 false를 반환한다.
    
<br/>

# class MyNumber
- 변수
	- arr : 입력받은 수가 순서대로 저장되는 배열이다. index로 접근 가능하도록 하기 위해 ArrayList를 이용했다.
- 메서드  
    - input : 입력을 받아 숫자로 변환해 arr에 저장한다. 입력받은 값이 1-9인 숫자가 아니거나, 길이가 3이 아니거나, 모두 다르지 않으면 예외가 발생한다.
    - get : 입력으로 index를 받아 arr의 index번째 값을 반환한다.

<br/>

# 기능
1. 랜덤 숫자 생성 <br/>
	Computer 클래스의 generate 메서드로 구현했다.<br/><br/>
	
2. 입력 받기 <br/>
	MyNumber 클래스의 input 메서드로 구현했다.<br/><br/>

3. 판정 <br/>
	Application 내부의 judge 함수로 구현했다.<br/>
	메서드 내에서 index 0~2일 때 MyNumber.get(index)값이 Computer.get(index)값과 같으면 스트라이크 +1, 그렇지 않고 MyNumber.get(index)값이 Computer의 randomSet에 포함되어 있으면 볼 +1한다. judge()는 스트라이크 값과 볼 값이 담긴 배열을 반환한다. <br/><br/>

4. 결과 출력 <br/>
	Application 내부의 printResult 함수로 구현했다.<br/>
	스트라이크 값과 볼 값을 입력으로 받는다. 입력값에 따라 힌트 문구를 출력한다. 3스트라이크 시 재시작 여부를 위한 입력을 받아 0 또는 2를 반환한다. 이때 1,2가 아닌 다른 값이 입력되면 예외가 발생한다. 3스트라이크가 아닐 시 1을 반환한다. <br/><br/>

5. 게임 재시작과 종료 <br/>
	Application 내부의 printResult 함수의 반환값으로 구현했다.<br/>
	0이 반환되면 반복문이 실행되지 않고 프로그램이 종료된다. 1이 반환되면 반복문이 실행되어 다음 입력을 받는다. 2가 반환되면 Computer 클래스의 generate 메서드를 실행해 숫자를 다시 선택하며 게임이 다시 시작된다.