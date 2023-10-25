# Git(브랜치, 커밋 컨벤션)

## 브랜치 역할

- 코드를 통째로 복사하고 독립적으로 개발을 진행할 수 있음.
- 새 기능이나 버그 수정 작업할 때 다른 팀의 구성원과 작업을 분리할 수 있음.

## 브랜치 명령어

- 브랜치 조회: git branch
- 브랜치 생성: git branch 브랜치이름
- 브랜치 이동: git switch 브랜치이름
- 브랜치 병합: git merge 브랜치명 (메인으로 이동 후)

---

## Commit Message 구조

- 각 파트는 아래와 같은 형태로 한 줄 들여쓰기로 구분함.

```java
type(옵션):[#issueNumber-]Subject    // 제목

        body(옵션)                           // 본문

        footer(옵션)                         // 꼬리말
```

- type: 어떤 의도로 커밋을 했는가?
- Subject: 코드 변경사항에 대한 짧은 요약
- body: 부연 설명이 필요한 경우, 본문 작성
- footer: issue tracker ID 를 명시하고 싶은 경우, 작성

## Commit Type

- 형태: 태그 + 제목
    - ex. 'feat: 컴퓨터 숫자 생성'
- 자주 사용하는 태그 종류
    - Feat : 새로운 기능을 추가하는 경우
    - Fix : 버그를 고친경우
    - Docs : 문서를 수정한 경우
    - Style : 코드 포맷 변경, 세미콜론 누락, 코드 수정이 없는경우
    - Refactor : 코드 리펙토링
    - Test : 테스트 코드. 리펙토링 테스트 코드를 추가했을 때
    - Chore : 빌드 업무 수정, 패키지 매니저 수정
    - Design : CSS 등 사용자가 UI 디자인을 변경했을 때
    - Rename : 파일명(or 폴더명) 을 수정한 경우
    - Remove : 코드(파일) 의 삭제가 있을 때. "Clean", "Eliminate" 를 사용하기도 함

- Subject: 과거형이 아닌 명령조

## Commit 명령어

- git status: 저장소 파일들의 상태 확인
- git add 파일명: 해당 파일 작업 사항을 stage에 추가
- git add .: 모든 파일 작업 사항을 stage에 추가
    - Git의 Repository 구조: 작업폴더(Working directory) > 인덱스(Staging Area) > 저장소(Head -Repository)
- git commit -m "메시지": 변경 사항을 Head에 적용
- git push 저장소명 브랜치명: 로컬 저장소에서 원격 저장소로 변경 사항 적용