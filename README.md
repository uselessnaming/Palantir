# Palantir
Project with Family

### __Commit Convention__
#### type
+ add : 새로운 기능 추가
+ update : 기능 수정 (방향성 전환)
+ fix : 오류 수정
+ gradle : 환경 설정 변경
+ refactor : 코드 리팩토링
+ docs : 관련 문서 변경

---

### __Issue__

#### 유형
+ [#1] : event에 대한 오류
+ [#2] : gradle 및 환경에 대한 오류
+ [#3] : 예외 처리 오류
+ [#4] : UI 관련 오류

#### 문제
+ [#1] AndroidLarge35()에서 TextButton을 Click하면 DatePickerDialog가 띄워져야 하지만 오류로 인해 event 적용이 안됌
  > Dialog 안에 조건문 작성을 함께 해서 중복으로 인해 오류 발생 : 조건문을 밖으로 빼서 해결
+ [#4] CustomCalendarDialog에서 SpinnerButton을 Click하면 TimePicker가 생성되어야 하지만 오류로 인해 안 나옴. 하지만 Event 자체는 이상 없음
  > TimePikcer를 Dialog로 감싸서 띄워 해결
+ [#4] DatePicker를 통해 Calendar 변동이 적용은 되는데 속도가 느림. 속도 개선 필요
+ [#4] AndroidLarge35()에 연결된 DropdownItem의 내부 Item들이 왼쪽 정렬되어 있는 것을 수정해야 함

#### 할 일
+ AndroidLarge35()의 Dropdown Menu 연동
+ Calendar들 무조건 42일로 맞추지 말고 유동적으로 필요한 일만 가지고 Calendar 구성
+ 

---
