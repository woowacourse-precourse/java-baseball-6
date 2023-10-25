#### 1. 기능

- 게임을 실행시킬지 종료시킬지 판단한다.
- 1-9 사이의 랜덤 숫자 3가지를 추출한다.
- 1-9 사이의 숫자 3가지를 사용자로부터 입력 받는다.
- 랜덤 숫자와 입력 받은 숫자를 비교해가며 결과를 판독한다.
- 사용자 입력이 잘못된 경우 IllegalArgumentException 발생시킨 후 애플리케이션 종료시킨다.

#### 2. 클래스

- game : 게임 관련 변수와 메서드
- constant : 상수값
- exception : 예외사항

#### 3. 주요 메서드

- run : 게임 실행
- rerun : 게임 재실행 여부 판단
- gameStart : 야구게임 시작
- getResult, getHint : 게임 결과 판독하고 출력
- getRandomNum : 1-9 사이의 서로 다른 랜덤값 3개을 추출
- getInputNum : 1-9 사이의 서로 다른 숫자를 사용자로부터 입력받음
- IllegalArgumentException 