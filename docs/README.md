# ⚾&nbsp;&nbsp;Precourse-Week1 Mission **[숫자 야구]**

## 💌&nbsp;&nbsp;목차

- [💌&nbsp;&nbsp;목차](#목차)
- [📦&nbsp;&nbsp;패키지 구조](#패키지-구조)
- [✨&nbsp;&nbsp;기능 구현 목록](#기능-구현-목록)

---

## 📦&nbsp;&nbsp;패키지 구조

<div align="center">
<table>
    <tr>
        <th align="center">Package</th>
        <th align="center">Class</th>
        <th align="center">Description</th>
    </tr>
    <tr>
        <td><b>📃&nbsp;&nbsp;config</b></td>
        <td>GlobalConfig</td>
        <td>전역으로 작용하는 설정<br/>(숫자 길이 제약, 뽑을 숫자 범위) Enum 파일</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td><b>🕹&nbsp;&nbsp;controller</b></td>
        <td>Game</td>
        <td>게임 로직을 메인으로 동작하는 컨트롤러 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="3"><b>💻&nbsp;&nbsp;domain</b></td>
        <td>Number</td>
        <td>사용자에게 입력받는 숫자와, 컴퓨터가 생성하는 숫자 클래스
        </td>
    </tr>
    <tr>
        <td>Result</td>
        <td>Ball Count와 Strike Count에 대한 결과 클래스</td>
    </tr>
    <tr>
        <td>ResultType</td>
        <td>볼, 스트라이크, 볼&스트라이크 상황에 대한 <br/>출력 방법이 정의된 Enum 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td><b>✅&nbsp;&nbsp;validator</b></td>
        <td>NumberValidator</td>
        <td>사용자가 입력하는 숫자에 대한 제약조건 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="3"><b>💬&nbsp;&nbsp;view</b></td>
        <td>InputView</td>
        <td>사용자 요청을 받기 위한 Input View 클래스</td>
    </tr>
    <tr>
        <td>OutputView</td>
        <td>사용자에게 다양한 응답을 출력하기 위한 Output View 클래스</td>
    </tr>
    <tr>
        <td>PrintMessage</td>
        <td>사용자에게 응답할 정적 메세지를 담은 열거형 Enum 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td colspan="3"><center><b>Image</b></center></td>
    </tr>
    <tr>
        <td colspan="3"><img src="https://github.com/woowacourse-precourse/java-baseball-6/assets/112257466/9cf30277-2b69-4781-a80e-dfa9325598d7" width="99%"></td>
    </tr>

</table>
</div>

---

## ✨&nbsp;&nbsp;기능 구현 목록

- ✅1~9 사이의 서로 값이 다른 3자리의 정수를 랜덤으로 생성한다.
    - ✅서로 중복되지 않는 숫자 3개
- ✅게임 시작 문구 출력
    - `숫자 야구 게임을 시작합니다.`
- ✅사용자에게 `1-9 사이의 서로 값이 다른 3자리의 정수`를 입력 받고 저장한다.
    - ✅입력받은 input이 비어있을 경우(isEmpty)
    - ✅입력받은 input이 3자리가 아닐 경우 예외처리
    - ✅입력받은 input이 숫자가 아닌 문자가 포함될 경우 예외처리
    - ✅입력받은 input에 중복된 숫자가 있을 경우 예외처리
- ✅사용자 input과 랜덤 생성 정수를 비교해 출력할 힌트를 계산한다.
    - ✅다른 자리 같은 숫자의 갯수 n개 : `n볼`
    - ✅같은 자리 같은 숫자 n개: `n스트라이크`
    - ✅스트라이크와 볼이 같이 존재할 때 : `n볼 n스트라이크`
    - ✅같은 숫자가 1개도 없으면 : `낫싱`
- ✅게임 클리어 여부 판단
    - ✅3스트라이크 상황 메시지 출력:
        - `3개의 숫자를 모두 맞히셨습니다! 게임 종료`
        - `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
        - ✅사용자에게 게임 재시작 여부를 입력받고, 입력값에 따라 프로그램 반복 실행 여부를 결정한다.
    - ✅3스트라이크가 아니라면, 다시 사용자에게 입력을 숫자를 받고, 힌트를 출력한다.
