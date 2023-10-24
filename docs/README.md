---

# 구현할 기능 목록
1. 게임 시작
2. 서로 다른 숫자인 3자리 수 생성
3. 입력 값 Reader(+Validator)
4. 종료 값 Reader(+Validator)
5. hint Validator
6. hint 메시지 합치기
7. hint Message 출력
8. 볼 갯수 세기
9. 스트라이크 갯수 세기
10. 볼 갯수와 스트라이크 갯수 validator

src/

.
├── main
│   └── java
│       └── baseball
│           ├── Application.java
│           ├── constant
│           │   ├── ServiceMessage.java
│           │   └── StatusMessage.java
│           ├── counter
│           │   ├── Ball.java
│           │   ├── CounterValidator.java
│           │   └── Strike.java
│           ├── hint
│           │   ├── Message.java
│           │   ├── Printer.java
│           │   └── TotalMessage.java
│           ├── input
│           │   ├── EndReader.java
│           │   ├── EndValidator.java
│           │   ├── LengthValidator.java
│           │   ├── NumberValidator.java
│           │   ├── Reader.java
│           │   ├── Validator.java
│           │   └── ZeroValidator.java
│           └── service
│               ├── BaseBallGame.java
│               ├── GameEnding.java
│               ├── GamePlaying.java
│               ├── InitNumber.java
│               └── ServiceMessagePrinter.java
└── test
    └── java
        └── baseball
            └── ApplicationTest.java