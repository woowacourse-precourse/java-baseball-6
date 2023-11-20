## 구현할 기능 목록 정리 (1차)

### 🛠️ 기능 목록
- ✅ 입력한 숫자와 컴퓨터가 랜덤으로 추출한 숫자를 비교해 스트라이크, 볼 갯수를 카운트하는 ```countStrikeAndBall()``` 함수
  - myNumber 문자열과 computerNumber 리스트의 index번째 값이 같다면 스트라이크 증가
  - computerNumber의 index번째 값이 myNumber에 있지만 해당 값이 index번째 값이 아닌 경우 볼 증가

      

- ✅ 컴퓨터가 추출한 숫자를 모두 맞혔는지 아닌지 판단 후 정답 출력하는 ```displayBaseballGameResult()``` 함수
  - strike == 0 이고 ball == 0인경우 
    - 낫싱 출력
  - strike == 3 이고 ball == 0 인경우
    - 3스트라이크 출력
    - 3개의 숫자를 모두 맞히셨습니다! 게임 종료 출력
  - 낫싱이 아닌 경우에서 strike != 3인 경우
    -  x볼 y스트라이크 출력 또는 x볼 출력 또는 y스트라이크 출력


- ✅ 게임에서 승리했는지 판단하는 ```isVictory()``` 함수
    - strike == 3인 경우
      - return true
    - strike != 3인 경우
      - return false



- ✅ 게임을 재개할건지 판단하는 ```determineFinishOrAgainGame()``` 함수
    - 숫자 1을 입력한 경우
      - return false 
    - 숫자 2를 입력한 경우 
      - return true

### ⚠️ 예외 케이스
- ✅ 사용자가 입력한 값이 서로다른 숫자로 이뤄지지 않은 경우를 체크하는 ```checkDuplicateNumber()``` 함수 
- ✅ 사용자가 입력한 값의 길이가 3이 아닌경우 ```checkLengthNumber()``` 함수
- ✅ 사용자가 입력한 값에 숫자가 아닌 값이 포함된 경우 ```checkOnlyInterger()``` 함수
- ✅ 사용자가 게임을 종료한 후 다시 시작하거나 완전히 종료할 때 1과 2가아닌 다른 값을 입력한 경우
