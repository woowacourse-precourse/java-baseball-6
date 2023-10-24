## 구현 기능 목록

### game

- baseballGameApplication
    - [x]  게임 종료 후 다시 시작 / 종료 여부 입력받기

- RoundApplication
    - [x]  사용자가 추측한 숫자 입력받기

- Referee
    - [x]  정답 숫자와 사용자의 숫자를 비교해 결과 반환

### domain

- Balls
    - [x]  길이가 3인 List<Integer> balls 저장
    - [x]  전달받은 숫자가 balls에 포함되는지 여부 반환
    - [x]  balls에서 전달받은 인덱스 위치에 있는 숫자 반환
    - [x]  사용자가 입력한 숫자 검증
  
- BallsFactory
    - [x]  1~9의 랜덤 숫자로 구성된 중복이 없는 세 자리 List<Integer> 생성
  
- Pitching

  라운드에서 사용자가 값을 추측하는 한 번의 시도 결과를 저장하는 레코드 클래스


### view

- [x]  안내 메시지 출력하기
- [x]  사용자로부터 값 입력받기