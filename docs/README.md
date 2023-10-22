변수
- computer : 무작위로 선택한 중복 없는 숫자 (len:3)
- userInput1 : computer와 비교할 숫자 3개 (len:3)
- strike : 위치와 숫자까지 맞춤 (0~3)
- ball : 숫자만 맞춤 (0~3)
- userInput2 : 재시작 or 종료 여부 (len:1)

기능
- 중복 없는 숫자 3개 선택 (computer)
- userNumbers 입력 받기
- userInput1 검증 하기
- computer vs user (strike, ball)
- 결과 출력하기 
- userInput2 입력 받기
- userInput2 검증 하기
- 재시작 or 종료 처리

---------------------------------------------
클래스 
1. computer
- List<Integer> numbers
- func 랜덤 숫자 3개 선택에 numbers에 저장

2. User
- List<Integer> numbers
- func numbers에 저장하기
- ret userInput1

3. Score
- int strike
- int ball
- func 선언 초기화
- func addStrike
- func addBall
- ret strike
- ret ball

4. InputValue
- string userInput1
- string userInput2
- func userInput1 입력
- func userInput1 검증
- func userInput1 -> List<Integer>
- func userInput2 입력
- func userInput2 검증
- func userInput2 -> boolean

5. Game
- computer : 초기화x
- user : 초기화
- inputValue : 초기화
- score : 초기화
- func Game
  - 게임 시작 안내
- func play
```sh
computer (새 숫자 생성)
againGame = true (게임 flow)

while (againGame) {
  question
  score = compare
  if (score.strike==3){
    againGame = restart
  }
}
```
- func question
  - 숫자 입력 안내
  - input1 받기
  - input1 검증
  - input1 -> user
- func compare
  - computer vs user
  - score 값 변경
  - score 값 출력
  - return Score
- func restart
  - 게임 재시작 안내
  - input2 받기
  - input2 검증
  - input2 -> true (computer 초기화)
  - input2 -> false (게임 끝)
