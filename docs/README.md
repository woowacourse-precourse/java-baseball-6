### 1. computer 랜덤 숫자<br/>
1.  "computer"의 변수의 size가 3이하라면 무한 반복을 해준다.
2. Randoms.pickNumberInRange을 이용하여 1~9까지 값 출력.
3. 이전에 포함했던 순서인지 확인 후 list 삽입  

### 2. 사용자 숫자
#### 1. 제대로된 값 확인을 위해(길이 체크 및  전체 숫자인지 체크)
- 1-1, 문자열의 길이로 3이 아닌지 확인
- 1-2. 숫자인지 체크

#### 2. 1~9까지의 수로 작성했는지 체크 및 서로다른 숫자인지 체크
- 2-1) 문자열 -> int로 변환
- 2-2) 1~9까지와 서로 다른 숫자 체크해준다.

### 3. 각 요소의 strikes찾기
- 각 "user"의 입력 숫자와 각 "computer"의 입력 숫자를 비교하여 스트라이크 수를 계산한다.
1. "user"의 입력과 "computer"의 숫자는 size는 3개로 같기 때문에 사용자의 숫자의 사이즈로 for문을 돌린다.
2. 같은 자리수에서의 "user"의 입력수와 computer의 입력수가 같을 경우 strikes 증가.

### 4.각 요소의 Balls찾기
- "user"의 입력과 "computer"의 숫자를 비교하여 ball 수를 계산합니다.
1. "user"의 각 요소가 "computer"의 모든 요소들을 비교하기위해 2중 for문을 이용.
2. "user" 리스트의 요소와 "computer" 리스트의 요소를 비교하고, 만약 각 요소가 동일한 위치(같은 자리수)에 있지 않다면 "balls"  증가

### 5. strikes 가 3개인 경우
#### 1. 1인 경우(재시작)
#### 2. 2인 경우(게임종료)
#### 3. 그외 : 잘못 입력


### 5. result(strike가 3이 아닌 경우)
- 3strikes가 아닌 경우
- <code>balls > 0 && strikes > 0</code>
  - 둘다 맞춘 경우
- <code> balls > 0 && strikes == 0</code>
  - balls만 맞춘 경우
- <code> balls == 0 && strikes > 0</code>
  - strikes만 맞춘 경우
- 그외
  - 아무것도 맞추지 못한 경우