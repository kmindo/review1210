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
    <link rel="stylesheet" href="/assets/css/employee_list.css">
    <script src="assets/js/employee.js"></script>
</head>
<body>
    <main>
        <h1><i class="fas fa-user-cog"></i>   직원 관리</h1>
        <button id="add_employee"><i class="fas fa-plus-circle"></i>직원 추가</button>
        <div class="content_area">
            <div class="menu_area">
                <div class="search_box">
                    <select id="search_type">
                        <option value="employeeID">직원ID</option>
                        <option value="name">이름</option>
                    </select>
                    
                    <input type="text" id="keyword" placeholder="검색어를 입력하세요" value="${data.keyword}">
                    <button id="search_btn"><i class="fas fa-search"></i></button>
                </div>
            </div>
            <div class="table_area">
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <!-- <th>소속</th> -->
                            <th>직원ID</th>
                            <th>이름</th>
                            <th>전화번호</th>
                            <th>생년월일</th>
                            <th>이메일</th>
                            <th>상태</th>
                            <th>등록일</th>
                            <th>수정일</th>
                            <th>수정</th>
                            <th>삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.list.size() == 0}">
                            <tr>
                                <td id="nodata" colspan="11">데이터가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="e">
                            <tr>
                                <td>${e.ei_seq}</td>
                                <td>${e.ei_number}</td>
                                <td>${e.ei_name}</td>
                                <td>${e.ei_phone_num}</td>                              
                                <td>${e.ei_birth}</td>
                                <td>${e.ei_email}</td>
                                <td class="employee_status">
                                    <c:if test="${e.ei_status ==1}">
                                        <span style="background-color: rgb(17, 226, 27);">재직</span>
                                    </c:if>
                                    <c:if test="${e.ei_status ==2}">
                                        <span style="background-color: rgb(225,110,26);">휴가</span>
                                    </c:if>
                                    <c:if test="${e.ei_status ==3}">
                                        <span style="background-color: rgb(251,186,64);">휴직</span>
                                    </c:if>
                                </td>
                                <td><fmt:formatDate value="${e.ei_reg_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td><fmt:formatDate value="${e.ei_mod_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td>
                                    <button class="modify_btn" data-seq="${e.ei_seq}"><i class="fas fa-pencil-alt"></i></button>
                                </td>
                                <td>
                                    <button class="delete_btn" data-seq="${e.ei_seq}"><i class="fas fa-minus-circle"></i></button>
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
                        <a href="/employee??offset=${(i-1)*10}&type=${type}&keyword=${keyword}">${i}</a>
                    </c:forEach>
                </div>
                <button id="next"><i class="fas fa-chevron-right"></i></button>
            </div>
        </div>
    </main>
    <div class="popup_wrap">
        <div class="popup" id="employee_add">
            <div class="top_area">
                <div class="ico"><i class="fas fa-users"></i></div>
                <h2>직원 추가</h2>
                <p>직원 정보를 입력해주세요</p>
            </div>
            <div class="content_area">
                <input type="text" id="employee_number" placeholder="직원번호">
                <input type="text" id="employee_name" placeholder="직원 명">
                <input type="password" id="employee_pwd" placeholder="비밀번호">
                <input type="password" id="employee_pwd_confirm" placeholder="비밀번호 확인">
                <input type="text" id="employee_phone" placeholder="전화번호 (01012345678)">
                <input type="text" id="employee_birth" placeholder="생년월일 (YYMMDD)">
                <input type="text" id="employee_email" placeholder="이메일 (mail@mail.com)">
                <select id="employee_status">
                    <option value="1">재직</option>
                    <option value="2">휴가</option>
                    <option value="3">휴직</option>
                </select>
            </div>
            <div class="btn_area">
                <button id="add_popup">등록하기</button>
                <button id="modify_popup">수정하기</button>
                <button id="cancel_popup">취소하기</button>
            </div>
        </div>
    </div>
</body>
</html>