### 1. computer 랜덤 숫자<br/>
1. Randoms.pickNumberInRange을 이용하여 1~9까지 값 출력.
2. 이전에 포함했던 순서인지 확인 후 list 삽입  

### 2. 사용자 숫자
1. 숫자 길이(3)을 구해야 하기에 String으로 받음
2. 숫자 길이가 3이 아닌경우 <code>throw new IllegalArgumentException("세 자리수를 입력하세요");</code> 
3. 각 숫자별로 구하기 위해 myNum.split("")을 이용 map으로 Integer로 변경 후 list로 담아줌

### 3. findstrikes()
- 사용자의 입력과 "computer"의 숫자를 비교하여 스트라이크 수를 계산합니다.
1. <code>int strikes = 0;</code> 으로 초기화
2. 사용자 size 즉 3번 for문으로 반복하여 각 자리수가 같다면 "strikes" 변수 1증가

### 4. findBall()
- 사용자의 입력과 "computer"의 숫자를 비교하여 볼 수를 계산합니다.
1. <code>int balls = 0;</code> 으로 초기화
2. 2중 for문을 이용하여 사용자와 컴퓨터의 ball 계산 
3.  "user" 리스트의 요소와 "computer" 리스트의 요소를 각각 비교하고, 만약 같은 요소가 동일한 위치에 있지 않다면 "balls" 변수를 증가

### 5. result()
1. "strikes" 변수가 3개 있을 경우 (맞춘 경우)
- "play" 변수에 1 또는 2를 입력</br> 
- 1일 경우 2중 while문 중 안쪽 while문을 끝냄으로써 프로그램 다시 시작할 수 있도록 함. 
- 2일 경우 2중 while문 중 바깥쪽 while문을 끝냄으로써 프로그램을 완전히 끝냄.
2. 완전히 맞추지 못한 경우
- <code>balls > 0 && strikes > 0</code>
  - 둘다 맞춘 경우
- <code> balls > 0 && strikes == 0</code>
  - balls만 맞춘 경우
- <code> balls == 0 && strikes > 0</code>
  - strikes만 맞춘 경우
- 그외
  - 아무것도 맞추지 못한 경우





