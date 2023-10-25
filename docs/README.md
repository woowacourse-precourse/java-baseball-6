# 1. 구현 목록

## 1.1. Application.java
- && 연산자 : 처음 조건이 참일 경우, 이후 조건도 검증 수행

``` java
/* 이중 조건문을 단일 조건문으로 리팩토링 */
// 이중 조건문
if (resultArr[0] == 3 ) {
    if(input.finishGame(randomNumList) == 2) break;
}
// 단일 조건문
if (resultArr[0] == 3 && input.finishGame(randomNumList) == 2) break;
```

## 1.2 GameException.java
- checkAnswer() : 게임 중 input 값의 예외 검증 
  1. 3자리수가 아닌 경우
  2. 문자나 중복 숫자가 들어간 경우
- checkFinishAnswer() : 게임 종료 후 input 값의 예외 검증
  - 1 혹은 2가 아닌 경우

## 1.3 Print.java
- startGame() : 게임시작문구 출력
- resultGame() : 게임결과문구 출력
- doGame() :  게임 중 문구 출력
- finishGame() : 게임 종료 문구 출력

## 1.4 Input.java
- doGame() : 게임 중 사용자가 입력한 값 받기
- finishGame() : 게임 종료 혹은 재시작 여부 값 받기

## 1.5 Computer.java
- makeRandomList() : 서로다른 랜덤한 숫자 3자리를 list에 넣기
- makeRandomNum() : 랜덤한 숫자 가져오기

## 1.6 GameResult.java
- countResult() : 스트라이크와 볼 여부를 계산

# 2. 문제 해결
## 2.1. 구현 code가 app에서는 잘 동작 했지만 게임종료_후_재시작() test에서 실패
- 원인 : pickUniqueNumbersInRange() 메서드를 잘못 사용
- 해결 : pickNumberInRange()를 이용한 로직 구현 후 test 통과

## 2.2. 기능 요구사항에서 엄격한 예외처리가 필요했는데 test 코드만 통과한 예외처리 수행
- 원인 : 요구사항을 자세히 보지 않음
- 해결 : 조건에 따른 모든 예외사항을 만들고 GameException이라는 예외 Class를 두어 예외 상황을 하나의 class에서 관리

## 2.3. "nnn" 입력 시, 예외 통과
- 원인 : 중복된 숫자가 2개일 경우만 생각하여 잘못된 조건식 작성
- 해결 : 중복된 숫자 여부 상관 없이 항상 3자리 수 이도록 조건식 수정

## 2.4. String.toCharArray() -> String.charAt()
- 원인 : 필요없는 코드 생성
- 해결 : char[]를 만들지 않고 String에서 index를 이용한 char를 받아오는 방식 이용 

# 3. 추가 공부
## 3.1. missionutils 자체 API를 gradle에 어떻게 넣었는지
### 일반 과정
1. 라이브러리 빌드
2. 오픈소스 호스팅 - github
3. 버전 관리
4. Gradle 또는 Maven 설정 - 의존성 추가
5. 배포 - 온라인 저장소에 게시 및 배포 ex) Maven Central Repository, JCenter, JitPack 사용
6. 접근 권한 설정 
### 내부 프로젝트 경우
1. 라이브러리 빌드
2. 로컬 저장소에 설치 - 로컬 maven 또는 Gradle 저장소
   - maven  : `mvn install` -> Maven 저장소에 설치
   - Gradle : `gradle install` -> Gradle 저장소에 설치
3. 내부 프로젝트에 의존성 추가 - build.gradle 혹은 pom.xml에 해당 라이브러리 의존성 추가

## 3.2. [ ./gradlew clean test ] test
- 정의 : Gradle을 사용하여 프로젝트를 정리(clean)하고 테스트(test)를 실행하는 명령어
  - ./gradlew : Gradle Wrapper 스크립트 실행, 로컬 시스템에 Gradle을 설치하지 않고 프로젝트에 필요한 Gradle 버전 사용
  - clean : Gradle 빌드 시 이전 빌드 결과물을 정리하는 단계
  - test : 프로젝트 테스트 실행
    1. default는 프로젝트 내의 모든 테스트 실행
    2. build.gradle에 의해 테스트 범위 지정
       ```bash 
           # build.gradle
           test { useJUnitPlatform() }
       ```
    3. 직접 명령어로 테스트 범위 지정  
       `./gradlew test --tests com.example.MyTest` : 특정 test 직접 실행 

## 3.3 assertSimpleTest(), assertRandomNumberInRangeTest()
- 직접 정의한 NsTest, Assertion, Moc 이라는 것을 이용해서 만든 test인데 아직 이해가 힘듬

- 현재까지 이해한 부분
1. 게임종료_후_재시작()
   - run() -> setIn() : input에 사용될 값을 미리 만들어두고 app에서 요구할 때마다 하나씩 사용
   - output이 1번 출력 값이 나올 때마다 나타나는 값.
   - 랜덤한 숫자 임의 설정은 value, values를 이용하는 듯
2. 예외 test()
    - 임의의 test 수행 진짜 random 값
    - runException(String str) -> System.setIn()으로 4자리수를 input 하도록 수행

- System.setIn() : System.in을 재지정하는데 사용. 테스트 환경에서 사용자의 입력을 모의(mock)하거나 시뮬레이션 할 경우 사용  
- mockito??

## 3.4 git 공부
1. git commit 컨벤션
   - 커밋 메시지는 제목, 본문, 꼬리말 3가지 파트로 나뉘고 각 파트는 빈줄을 두어서 구분
    ``` bash
    type(옵션): [#issueNumber - ]Subject  // -> 제목 : 최대 50글자, 마침표 X, 영문 표기시 동사원형, 첫char 대문자
    (한 줄 띄기)
    body(옵션) //  -> 본문 : 어떻게 X, 무엇을 왜 O , 75자 남기지 말 것
    (한 줄 띄기)
    footer(옵션) // -> 꼬리말 : issue tracker ID를 명시하고 싶은 경우 작성
    ```
   1. 타입
      - 태그와 제목으로 구성, 태그는 영어로 쓰되 첫문자는 대문자로 작성, : 뒤에만 space 존재 ex) Feat: Subject  
      - 참고로 추가적 문맥 정보 제공을 위해 괄호내에 상세 내용 작성 ex) Feat(Navigation)
      - 종류 
        - Feat: 새로운 기능 추가
        - Fix: 버그를 고친 경우
        - Design: CSS 등 사용자 UI 디자인 변경
        - !BREAKING CHANGE: 커다란 API 변경의 경우
        - !HOTFIX: 급하게 치명적인 버그를 고쳐야하는 경우
        - Style: 코드 포맷 변경, 세미 콜론 누락, 코드 수정 없는 경우
        - Refactor: 프로덕션 코드 리팩토링
        - Comment: 필요한 주석 추가 및 변경
        - Docs: 문서를 수정한 경우
        - Test: 테스트 추가, 테스트 리팩토링(프로덕션 코드 변경 X)
        - Chore: 빌드 테스트 업데이트, 패키지 매니저를 설정하는 경우(프로덕션 코드 변경 X)
        - Rename: 파일 혹은 폴더명을 수정하거나 옮기는 작업만 한 경우
        - Remove: 파일을 삭제하는 작업만 수행한 경우
      - 사용
        - 기능 : Feat, Fix, Design
        - 개선 : Style, Refactor, Comment
        - 그외 : Docs, Test, Chore, Rename, Remove
   2. 제목
      - 처음은 동사원형, 총 글자 수 50자 이내, 특수문자 삽입 X (. ! ?)
      - 개조식 구문 작성
        - 영어 : Fix, Add, Change 명령어로 시작 ex) Feat : "Add get data api 함수"
        - 한글 : 고침, 추가, 변경 명령어로 시작 ex) Feat : "추가 get data api 함수"
   3. 본문
      - 한 줄 당 72자 내로 작성
      - 본문 내용은 양에 구애받지 않고 최대한 상세히 작성
      - 무엇을 변경했는지, 왜 변경했는지 설명 > 어떻게 변경했는지
   4. 꼬리말
      - optional, 이슈 트래커 ID 작성
      - "유형: #이슈 번호" 형식
      - 여러개 이슈 번호 작성 시 쉼표로 구분
      - 이슈 트래커 유형
        - Fixes: 이슈 수정중(미해결)
        - Resolves: 이슈를 해결했을 때 사용
        - Ref: 참고할 이슈가 있을 때
        - Related to: 해당 커밋에 관련된 이슈번호(미해결)

- 참고 문서 : https://overcome-the-limits.tistory.com/entry/%ED%98%91%EC%97%85-%ED%98%91%EC%97%85%EC%9D%84-%EC%9C%84%ED%95%9C-%EA%B8%B0%EB%B3%B8%EC%A0%81%EC%9D%B8-git-%EC%BB%A4%EB%B0%8B%EC%BB%A8%EB%B2%A4%EC%85%98-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0

