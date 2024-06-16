>## 프로젝트 소개 📝
>ㅇㅇㅇㅇ

>## 팀원👨‍👧‍👦
<table>
  <tr>
   <th>
    김민수
   </th>
    <th>
    이현종
   </th>
    <th>
    이희지
   </th>
    <th>
    강승배
   </th>
  </tr>
  <tr>
    <td align="center">
        <img src="https://avatars.githubusercontent.com/u/164992153?v=4" width=150px alt="김민수"> 
        <br/>
    </td>
    <td align="center">
        <img src="https://avatars.githubusercontent.com/u/164991787?v=4" width=150px alt="이현종"> 
        <br/>
    </td>
    <td align="center">
        <img src="https://avatars.githubusercontent.com/u/73567158?v=4" width=150px alt="이희지"> 
        <br/>
    </td>
    <td align="center">
        <img src="https://avatars.githubusercontent.com/u/164992129?v=4" width=150px alt="강승배"> 
        <br/>
    </td>
  </tr>
  <tr>
    <td align="center" class="민수">
        <a href="https://github.com/KMS9637"><img alt="github-link" height="25" src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/></a>
   </td>
    <td align="center" class="현종">
        <a href="https://github.com/latefor0815"><img alt="github-link" height="25" src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/></a>
   </td>
    <td align="center" class="희지">
        <a href="https://github.com/heeji-lee"><img alt="github-link" height="25" src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/></a>
   </td>
    <td align="center" class="승배">
        <a href="https://github.com/KANGSEUNBAE"><img alt="github-link" height="25" src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/></a>
   </td>
  </tr>
</table>

>## 기술 스택 💻
>[![stackticon](https://firebasestorage.googleapis.com/v0/b/stackticon-81399.appspot.com/o/images%2F1717586944525?alt=media&token=14630c28-7be0-426f-bfcf-75740abf6495)](https://github.com/msdio/stackticon)

>## ERD 구조
>📌[ERD Cloud에서 직접 보기](https://www.erdcloud.com/d/ZXXWMfPSA8GJccibG)
>
>![image](https://github.com/heeji-lee/Cafe/assets/73567158/b9a840b7-3af8-4b0a-bfc1-41bba1ea62e8)</br>

># 주요 기능
>## 요약
><table>
  <tr>
   <th>
    공통
   </th>
   <th>
    사용자
   </th>
   </tr>
  <tr>
   <td align="left" width="300px" class="공통">
    - 회원가입, 로그인</br>
    - 카테고리 별 메뉴 조회</br>
    - 매장 찾기</br>
    - 공지사항 조회
   </td>
   <td align="left" width="300px" class="사용자">
    - 회원정보 수정</br>
    - 찜하기</br>
    - 리뷰 작성
   </td>
  </tr>
</table>

## [ 공통 기능 ]

### 회원가입, 로그인
- 사용자는 아이디, 비밀번호, 성별, 전화번호, 생일을 이용하여 회원가입할 수 있습니다.
- 회원가입 시 사용한 아이디와 비밀번호를 이용하여 로그인할 수 있습니다.
### 카테고리 별 메뉴 조회
- 커피/에이드/티 카테고리 별 메뉴 목록을 조회할 수 있습니다.
- 상세 정보를 조회할 수 있습니다. 상세 정보에는 메뉴 이름과 정보 또는 가격이 있습니다.
### 매장 찾기
- 매장명 또는 주소로 매장 상세 정보를 찾을 수 있습니다.
### 공지사항 조회
- 공지사항 목록 및 상세 내용을 조회할 수 있습니다.

## [ 사용자 기능 ]

### 회원정보 수정
- 사용자는 회원가입 시 사용된 정보를 조회 및 수정할 수 있습니다.
### 찜하기
- 사용자는 구매하고 싶은 상품을 저장할 수 있습니다.
### 리뷰 작성
- 사용자는 구매한 상품에 대한 리뷰를 작성할 수 있습니다.

# API 명세

| Domain      | URL                                                                        | Http Method                 | description       | 접근 권한 |
|:------------|:---------------------------------------------------------------------------|:----------------------------|:------------------|:------|
| **Auth**    | /user/join                                                                 | `POST`                      | 사용자 회원가입    | -     |
|             | /user/login                                                                | `GET`                       | 사용자 로그인      | -     |
|             | /user/myInfo                                                               | `GET`                       | 사용자 정보 조회   | USER  |
|             | /user/modify                                                               | `GET/POST`                  | 사용자 정보 수정   | USER  |
|             | /user/delete                                                               | `POST`                      | 사용자 회원탈퇴    | USER  |
|             | /user/logout                                                               | `POST`                      | 사용자 로그아웃    | USER  |
| **Cafe**    | /cafe                                                                      | `GET`                       | 메인 페이지        | -     |
|             | /cafe/menu                                                                 | `GET`                       | 메뉴 목록 조회     | -     |
|             | /cafe/menu/view                                                            | `GET`                       | 메뉴 상세 조회     | -     |
|             | /cafe/like                                                                 | `GET`                       | 찜한 메뉴 조회     | USER  |
|             | /cafe/review                                                               | `POST`                      | 메뉴 리뷰 작성     | USER  |
|             | /cafe/store                                                                | `GET`                       | 매장 정보 조회     | -     |
|             | /cafe/notice                                                               | `GET`                       | 공지사항  조회     | -     |

## 데모
|회원가입|로그인|회원정보|
|:--------:|:-------:|:-------:|
|![image]()|![image]()|![image]()|
|**메뉴**|**찜**|**리뷰**|
|![image]()|![image]()|![image]()|
|**매장 찾기**|**공지사항**|
|![image]()|![image]()|
