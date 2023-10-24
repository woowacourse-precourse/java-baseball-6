# 미션 - 숫자 야구

## 🚀 프로그램 구조별 기능 요구 사항

Application Class 
- 게임 처음 시작 기능 (V)

Number Class
- 컴퓨터가 임의로 숫자 3자리를 생성하는 기능 (V)
- 숫자를 입력해주세요 문구 출력하고 사용자가 입력하는 부분 (V)
- 유효한 입력인지 판별 (V)
    - 3자리수 / 문자열 아닌 숫자 /  중복 여부

BaseBallGame Class 
- 힌트 제공 : 볼 / 스트라이크 체크 기능 (V)
    - 자리는 틀리고 숫자만 맞는 경우 : 볼 (V)
    - 자리와 숫자 둘 다 맞는 경우 : 스트라이크 (V)
    - 자리와 숫자 모두 틀린 경우 : 낫싱 (V)
- 게임 종료 및 재시작 기능 (V)
    - 사용자가 1을 눌렀을 때, 게임을 새로 시작하는 기능 (V)
    - 사용자가 2를 눌렀을 때, 게임을 새로 시작하는 기능 (V)

테스트 코드 부분 
- 사용자가 3자리를 입력하는 기능 (V)
    - 3자리가 아니면 예외처리 (V)
    - 숫자가 아니면 예외처리 (V)
    - 중복 숫자 발생 시 예외처리

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 (V)
- 프로그램 실행의 시작점 Application의 main() (V)
- Java 코드 컨벤션 가이드 준수 (V)
- ApplicationTest 의 테스트 실행 (V)
- camp.nextstep.edu.missionutils.Randoms 난수 라이브러리 사용 (V)
- camp.nextstep.edu.missionutils.Console 입력 라이브러리 사용 (V)

### 프로그램 구조

- Application: 게임 처음 시작 (V)
- BaseBallGame: 볼, 스트라이크 점수 확인 (V)
- SetNumber: 게임 시작 컴퓨터 난수, 사용자 입력값 제어 (V)

## ✏️ 과제 진행 요구 사항

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
