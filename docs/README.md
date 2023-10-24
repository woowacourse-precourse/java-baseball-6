# 미션 - 숫자야구

## 필요한 Class

- Game class
    - 숫자야구 게임을 반복적으로 실행
- Player class
    - input을 받음
    - input exception 검사
    - 숫자야구 결과 계산
- Computer class
    - random 숫자 생성
    - 숫자야구 결과 계산
- Exception class
    - 3자리 input exception 검사
    - 1자리 input exception 검사

## 프로그램 동작 과정

1. Game Class에서 숫자야구 실행
2. Computer instance와 Player instance 생성
3. input을 받으면 exception 검사
4. 숫자야구 진행 후 결과 출력
5. 정답을 맞출시 재시작 여부 input을 받고 exception 검사
6. 숫자야구 종료

## 고려해야 할 예외 상황

- 3자리 숫자인지
- 숫자가 아닌 다른 문자인지
- 중복된 숫자를 입력했는지
- 재시작 여부 input일 시 다른 기준 검사