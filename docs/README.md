## 구현할 기능 목록 정리 (1차)

### 🛠️ 기능 목록
- ✅ 입력한 숫자와 컴퓨터가 랜덤으로 추출한 숫자를 비교하는 ```compareMyInputNumberAndComputerNumber()``` 함수
    - 입력한 숫자가 컴퓨터가 입력한 숫자에 전부다 포함되지 않는 경우 낫싱
    - 인덱스마다 내가 입력한 문자와 컴퓨터가 입력한 문자가 같다면 ```strike += 1```
    - 인덱스마다 입력한 숫자가 컴퓨터가 입력한 문자에 포함되긴 하지만 인덱스가 다른 경우 int ball 값은 1증가
    - 한번 판단 후(```checkAnswerStrikeAndBall()가 리턴되면```) 변수를 초기화 하고 계속 진행 ```strike = 0, ball = 0```


- ✅ 컴퓨터가 추출한 숫자를 모두 맞혔는지 아닌지 판단하는 ```checkAnswerStrikeAndBall()``` 함수
    - 숫자를 모두 맞췄다면(```strike == 3``` 이라면) 3개의 숫자를 모두 맞히셨습니다! 게임 종료 출력
        - ```determineFinishOrAgainGame()``` 함수를 통해 게임을 다시 할건지 말건지 물어보기
    - 숫자를 정확하게 맞추기 못했다면(int strike != 3 이라면) x볼 y스트라이크 출력해주기
        - ```determineFinishOrAgainGame()``` 함수를 통해 게임을 다시 할건지 말건지 물어보기



- ✅ 게임을 재개할건지 판단하는 ```determineFinishOrAgainGame()``` 함수
    - 숫자 1을 입력했을 때 ```checkAnswerStrikeAndBall()``` 함수 종료
    - 숫자 2를 입력했을 때 ```isExit = true``` 할당 및 ```checkAnswerStrikeAndBall()``` 함수 종료

### ⚠️ 예외 케이스
- ✅ 사용자가 입력한 값이 서로다른 숫자로 이뤄지지 않은 경우
- ✅ 사용자가 입력한 값의 길이가 3이 아닌경우
- ✅ 사용자가 입력한 값에 숫자가 아닌 값이 포함된 경우
