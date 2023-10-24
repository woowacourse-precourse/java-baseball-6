## 기능요구사항
- ✅컴퓨터 난수 생성
  - ✅1~9까지의 임의의 서로 다른 3개의 수
- ✅사용자 숫자 입력
  - ✅1~9까지의 임의의 서로 다른 3개의 수 
  - ✅IllegalArgumentException 에러처리 
- ✅사용자 숫자에 대해 출력
  - ✅전체 볼or스트라이크의 개수
  - ✅스트라이크의 개수
  - ✅스트라이크와 볼의 개수 확인하기
- ✅게임이 끝난 경우 재시작(1)/종료(2)
---
### 프로그램 구조
- ✅Application: 게임의 시작,종료 제어
- ✅BaseBallGame: 게임 시작 컴퓨터 난수, 사용자 입력값 제어
- ✅Core: 볼, 스트라이크 점수 제어
- ✅Utils: 입력, 에러처리
- Score: 볼, 스트라이크 점수 객체

## 프로그래밍 요구사항
- ✅JDK 17 버전에서 실행
- ✅프로그램 실행의 시작점 Application의 main()
- ✅Java 코드 컨벤션 가이드 준수
- ✅ApplicationTest 의 테스트 실행
- ✅camp.nextstep.edu.missionutils.Randoms 난수 라이브러리 사용
- ✅camp.nextstep.edu.missionutils.Console 입력 라이브러리 사용

## 과제진행 요구사항
- ✅java-baseball-6 저장소를 Fork & Clone해 시작
- ✅docs/README.md에 구현할 기능 목록을 정리