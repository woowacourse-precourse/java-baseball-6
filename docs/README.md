## 0. 개발 전
### [ JDK 17 설정 ]
### [ 작동 흐름 ]
- MC : "숫자 야구 게임을 시작합니다."
- computer : 1~9까지 서로 다른 임의수 3개 선택

- MC : "숫자를 입력해주세요 :"
- player : 서로 다른 3개 숫자 입력 > 값 잘못 입력시 IllegalArgumentException 발생 후 Application 종료
- computer : 결과 출력(볼, 스트라이크, 낫싱)

- MC : (3스트라이크 인 경우) "3개의 숫자를 모두 맞히셨습니다! 게임종료"
- MC : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

- 반복 > computer의 숫자 맞출시 종료 > 다시 시작/완전 종료 (입력인 1과 2를 통해 구분)

### [ 구현 목표 ]
- while문을 통한 반복
- MC의 말을 출력
- computer의 임의 값 3개 설정
- player의 값 받기
- 결과 함수 구축 및 return 값으로 볼,스트라이크,낫싱여부 도출
- while문 빠져 나오기


## 1. 1차 개발 완료.
- 코드 리펙토링 필요
- 입력값 예외처리는 아직 안함
- './gradlew.bat clean test' 코드 실행시 오류 2개 발생
  - ApplicationTest > 게임종료_후_재시작() FAILED
    java.lang.ArrayIndexOutOfBoundsException at ApplicationTest.java:33

  - ApplicationTest > 예외_테스트() FAILED
  java.lang.AssertionError at ApplicationTest.java:27
