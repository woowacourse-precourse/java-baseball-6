# changelog.md

모든 주요 계획및 변경 사항 은 이 문서에 기록됩니다.

## **10.22**

- ### 추가
    - readme.md : 문서 readme.md 파일을 추가했습니다.
    - todo.md : 계획 상황을 작성한 문서 todo.md 파일을 추가했습니다.
    - changelog.md : 변동 사항을 기록하는 문서 changelog.md 파일을 추가 했습니다.
- ### 수정

- ### 진행중
    - readme.md 의 전체적인 뼈대 작성중

- ### 향후 구현 예정
    - 숫자야구 기본 기능 구현

## **10.23**

- ### 추가
    - java 컨벤션 세팅
    - readme.md : 문서 구현할 기능 세부 정리.
    - 기능(feature) 패키지 생성
    - feature 패키지 내부 기능 클래스 생성
        - confirmNumbers
        - confirmRules
        - RandomNumberMaker

## **10.24**

- ### 추가
    - RandomNumberMaker() 추가
    - RandomNumberMaker.maker() 테스트 추가
    - makeUserNumber 메소드 추가 (Application class내부)
    - makeUserNumber 메소드 테스트 추가
- ### 취소
    - 입출력 기능은 라이브러리가 제공되고 여러군데 쓰이고 특별한 과정이 필요 없으므로 클래스를 통한 구현이 필요 없다고 판단
- ### 진행중
    - ConfirmNumber 관련 기능 제작중

## 10.25

### 추가

- Confirm 기능을 Confirm클래스 내부에 작성
    - accordNumber 메소드 추가 (일치 숫자 갯수 반환(볼))
    - checkPositionMatch 메소드 추가 (자리 일치 갯수 반환)
    - referee 메소드 추가 (결과 문자열 반환)
- Confirm 클래스 완성
- 3스트라이크 찾을때까지 반복 (while문추가)
- application의 main함수에 완성도 올리기
- 경기 재시작 또는 종료
    - application 의 main함수에서 while 반복문과 starttoggle 변수활용해서 구현
- 에러처리
  - checkValidity() 추가 : 올바른 값인지 판별후 아니면 오류생성
  - isNumeric() 추가 : 문자열이 숫자인지 판별

### 취소

- 비슷한 Confirm기능을 담당한 클래스들 삭제

### 진행중


  
    
