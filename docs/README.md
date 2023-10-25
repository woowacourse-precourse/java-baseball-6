# 미션 1 - 숫자 야구 게임

## 💡 구조
```

└── main/
    └── java/
        └── baseball/
            ├── controller/
            │   └── NumberBaseballGame.java
            ├── model/
            │   ├── ComputerNum.java
            │   ├── UserNum.java
            │   ├── RetryGame.java
            ├── view/
            │   ├── InputView.java
            │   └── OutputView.java
            ├── util/
            │   └── DiffNumber.java
            │
            └── Application.java
```
## 📗 Model
- ComputerNum
  - 컴퓨터 값(서로 다른 3자리의 수)를 랜덤 생성 후 반환
- UserNum
  - 유저 값(input 값)에 대한 RegEx(서로 다른 1~9 중의 숫자 3가지) 적용 후 반환
  - RegEx에 맞지 않을 경우 : IllegalArgumentException 발생
- RetryGame
  - 게임 재시작에 대한 판단

## 📕 View
- InputView
  - setUserNumber
    - 유저의 값 입력 
  - setRetryNumber
    - 게임 재시작에 대한 유저의 값 입력
- OutputView
  - printGameStart
    - 게임 시작 메시지 출력
  - printInputMessage
    - 숫자 입력 메시지 출력
  - printResult
    - 컴퓨터 값과 유저값 비교 후 결과 출력
  - printGameSetMessage
    - 게임 종료 메시지 출력
  - printRetryMessage
    - 게임 재시작 메시지 출력

## 📘 Controller
- NumberBaseballGame
  - 결과가 3 스트라이크가 나오기 전까지 계속 게임 실행
  - 게임 재시작 여부에 따른 게임 실행

## 🐥 Util
- DiffNumber
  - CompareNumber
    - 컴퓨터 값과 유저 값을 비교하여 같은 값이 있는 경우의 수(result)를 반환 
  - strikeCount
    - 컴퓨터 값과 유저 값을 비교하여 같은 자리에 같은 값이 있는 경우의 수(strike)를 반환
  - strikeAndBallCount
    - CompareNumber, strikeCount의 반환값을 빼어 ball값 계산
    - total, strike, ball 값에 따른 결과 반환