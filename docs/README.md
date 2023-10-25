# 숫자 야구

## 😸 구현해야할 함수
- `createRandomNumber()`
    - 랜덤 숫자 생성
- `getNumber()`
    - 사용자 숫자 입력
- `isBall()`
    - 볼 판별 함수
    - 낫싱 기능을 포함.
- `isStrike()`
    - 스트라이크 판별 함수
    - 낫싱 기능을 포함.
 - `correctOrNot()`
    - 정답 여부 판별
    - 정답인지 판단한 후 오답이면 `getNumber()`로 돌아감.
 - `exception()`
    - 예외 처리 함수
    - IllegalArgumentException 오류 생성

## 😻 프로그래밍 요구 사항

- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


## 😺 JAVA 코드 컨벤션 가이드
- 참고 링크 (번역본)
  https://newwisdom.tistory.com/96
- Google Java Style Guide와 다른 부분들
    - 블럭 들여쓰기: +4 스페이스
    - 열 제한: 120
    - 들여쓰기 지속은 최소 +8 스페이스