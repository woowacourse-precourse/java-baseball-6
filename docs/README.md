### 1. computer 랜덤 숫자<br/>
1.  "computer"의 변수의 size가 3이하라면 무한 반복을 해준다.
2. Randoms.pickNumberInRange을 이용하여 1~9까지 값 출력.
3. 이전에 포함했던 순서인지 확인 후 list 삽입  

### 2. 사용자 숫자
#### 1. 제대로된 값 확인을 위해 
- 1-1) "user"의 수가 정수로 제대로 받았는지 확인하기 위해서 Integer.parseInt()를 통해 int로 변환 가능한 지 확인한다.
- 1-2) 정수가 아닌 수는 "값을 잘못입력하였습니다"라는  IllegalArgumentException 예외를 발생시킨다.
#### 2. 자리수 확인(3자리 수 인지 확인)
- 2-1) int인 숫자를 길이를 확인하기 위해 String으로 바꾼다.
- 2-2) String으로 바꾼 뒤 "myNum"의 변수가 3자리가 아니라면 "세 자리수를 입력하세요" 라는 IllegalArgumentException 예외를 발생시킨다.

#### 3. 각 사용자 숫자 확인을 위해 
- 3-1) 각 숫자별로 구하기 위해 myNum.split("")을 이용 각 자리수마다 자른 후 map을 이용하여 String을 Integer로 변경 후 list로 담아준다.

### 3. 각 요소의 strikes찾기
- 각 "user"의 입력 숫자와 각 "computer"의 입력 숫자를 비교하여 스트라이크 수를 계산한다.
1. "user"의 입력과 "computer"의 숫자는 size는 3개로 같기 때문에 사용자의 숫자의 사이즈로 for문을 돌린다.
2. 같은 자리수에서의 사용자의 입력수와 computer의 입력수가 같을 경우 strikes 증가.

### 4.각 요소의 Balls찾기
- "user"의 입력과 "computer"의 숫자를 비교하여 ball 수를 계산합니다.
2. "user"의 각 요소가 "computer"의 모든 요소들을 비교하기위해 2중 for문을 이용.
2. "user" 리스트의 요소와 "computer" 리스트의 요소를 비교하고, 만약 각 요소가 동일한 위치(같은 자리수)에 있지 않다면 "balls"  증가

### 5. result
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