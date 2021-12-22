<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%@include file="/WEB-INF/includes/header.jsp"%>
    <link rel="stylesheet" href="/assets/css/book_list.css">
    <link rel="stylesheet" href="/assets/css/member_list.css">
    <script src="assets/js/member.js"></script>
</head>
<body>
    <main>
        <h1><i class="fas fa-users"></i>   회원 관리</h1>
        <button id="add_member"><i class="fas fa-plus-circle"></i>회원 추가</button>
        <div class="content_area">
            <div class="menu_area">
                <div class="search_box">
                    <input type="text" id="keyword" placeholder="검색어를 입력하세요" value="${data.keyword}">
                    <button id="search_btn"><i class="fas fa-search"></i></button>
                </div>
                <button id="reset_btn">초기화</button>
            </div>
            <div class="table_area">
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>회원ID</th>
                            <th>이름</th>
                            <th>전화번호</th>
                            <th>생년월일</th>
                            <th>이메일</th>
                            <th>상태</th>
                            <th>등록일</th>
                            <th>수정일</th>
                            <th>수정/삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.total == 0}">
                            <tr>
                                <td id="nodata" colspan="6">데이터가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="d">
                            <tr>
                                <td>${m.mi_seq}</td>
                                <td>${m.mi_id}</td>
                                <td>${m.mi_name}</td>
                                <td>${m.mi_pwd}</td>
                                <td>${m.mi_phone_num}</td>                              
                                <td>${m.mi_birth}</td>
                                <td>${m.mi_email}</td>
                                <td>${m.mi_status}</td>
                                <td><fmt:formatDate value="${m.mi_reg_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td><fmt:formatDate value="${m.mi_mod_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td>
                                    <button class="modify_btn" data-seq="${m.mi_seq}"><i class="fas fa-pencil-alt"></i></button>
                                    <button class="delete_btn" data-seq="${m.mi_seq}"><i class="fas fa-minus-circle"></i></button>
                                </td>
                            </tr>
                        </c:forEach>                            
                    </tbody>
                </table>
            </div>
            <div class="pager_area">
                <button id="prev"><i class="fas fa-chevron-left"></i></button>
                <div class="pagers">
                    <c:forEach begin="1" end="${data.pageCnt}" var="i">
                        <a href="/member?offset=${(i-1)*10}&keyword=${data.keyword}">${i}</a>
                    </c:forEach>
                </div>
                <button id="next"><i class="fas fa-chevron-right"></i></button>
            </div>
        </div>
    </main>
    <div class="popup_wrap">
        <div class="popup" id="member_add">
            <div class="top_area">
                <div class="ico"><i class="fas fa-users"></i></div>
                <h2>회원 추가</h2>
                <p>회원 정보를 입력해주세요</p>
            </div>
            <div class="content_area">
                <input type="text" id="member_id" placeholder="ID">
                <input type="text" id="member_name" placeholder="회원 명">
                <input type="password" id="member_pwd" placeholder="비밀번호">
                <input type="password" id="member_pwd_confirm" placeholder="비밀번호 확인">
                <input type="text" id="member_phone" placeholder="전화번호 (01012345678)">
                <input type="text" id="member_birth" placeholder="생년월일 (YYMMDD)">
                <input type="text" id="member_email" placeholder="이메일 (mail@mail.com)">
                <select id="member_status">
                    <option value="1">정상</option>
                    <option value="2">정지</option>
                    <option value="3">탈퇴</option>
                </select>
            </div>
            <div class="btn_area">
                <button id="add_mem">등록하기</button>
                <button id="modify_mem">수정하기</button>
                <button id="cancel_mem">취소하기</button>
            </div>
        </div>
    </div>
</body>
</html>