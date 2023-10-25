# 숫자 야구 게임

## 구현할 기능 목록

### 입력 값 검증 구현

- [x] 입력 값 검증
    - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생
    - [x] 올바른 입력 값 받았을 때, 아무런 Exception이 발생되지 않아야 함 


### 게임 콘솔 구현

- [x] 게임 콘솔
    - [x] 플레이 할 게임 선택

- [x] 게임 시작
    - [x] 게임 초기화
    - [x] 플레이 할 게임 시작

- [x] 게임 종료 후 재시작 여부 입력
    - [x] 입력 값이 "1" 또는 "2"가 아닌 값이 나올 경우 `IllegalArgumentException`을 발생


### 야구 게임 구현

- [x] 랜덤 숫자 설정
    - [x] 1부터 9까지 랜덤한 숫자 3개 선택하기
        - [x] 각각 서로 다른 수 뽑기
        - [x] 1 부터 9 이내로 뽑기

- [x] 숫자 입력
    - [x] 숫자 입력
        - [x] 3개의 서로 다른 숫자 입력
    - [x] 예외 조건
        - [x] 3자리의 숫자를 입력받지 못했을 경우 `IllegalArgumentException`을 발생
        - [x] 숫자 중 중복이 있을 경우 `IllegalArgumentException`을 발생

- [x] 숫자 비교
    - [x] 상대방(컴퓨터) 숫자와 플레이어 숫자 비교
        - [x] 위치와 숫자가 일치하면, `스트라이크 카운트` 추가
        - [x] 위치가 다르지만 갖고 있는 숫자가 일치하면, `볼 카운트` 추가

- [x] 결과 통보
    - [x] 비교 결과 알려주기
        - [x] `볼 카운트`와 `스트라이크 카운트`가 0일 경우 `낫싱` 
        - [x] 입력한 수에 대한 결과를 `볼`, `스트라이크` 개수로 표시
            - [x] 볼 출력 후 스트라이크 출력
 
- [x] 게임 종료
    - [x] 3스트라이크 일 경우 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력 후 종료

- [x] 게임 시작 문구 출력
    - [x] 재시작 시 출력 x


### 프로그래밍 요구 사항 확인

- [x] JDK 17 버전에서 실행 가능해야 한다
- [x] JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [x] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
    - [x] 블럭 들여쓰기: +4 스페이스
    - [x] 열 제한 : 120
    - [x] 들여쓰기 지속은 *최소* +8 스페이스
- [x] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- [x] 라이브러리 사용
    - [x] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

