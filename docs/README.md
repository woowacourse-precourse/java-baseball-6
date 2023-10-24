---

# 구현할 기능 목록
1. 게임 시작
2. 서로 다른 숫자인 3자리 수 생성
3. 입력 값 Validator - 수 예측, 종료 시
4. hint Validator
5. hint 메시지 합치기 및 출력
6. 볼 갯수 세기
7. 스트라이크 갯수 세기
8. 볼 갯수와 스트라이크 갯수 validator

src/ 

├── ./main
│   └── java
│       └── baseball
│           ├── Application.java
│           ├── BaseBallGame.java
│           ├── InitNumber.java
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
│           └── input
│               ├── EndValidator.java
│               ├── LengthValidator.java
│               ├── NumberValidator.java
│               ├── Validator.java
│               └── ZeroValidator.java
└── ./test
    └── java
        └── baseball
            └── ApplicationTest.java