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
    <link rel="stylesheet" href="/assets/css/publisher_list.css">
    <script src="/assets/js/publisher.js"></script>    
</head>
<body>
    <main>
        <h1><i class="fas fa-school"></i> 출판사 관리</h1>
        <button id="add_department"><i class="fas fa-plus-circle"></i>출판사 추가</button>
        <div class="content_area">
            <div class="menu_area">
                <div class="search_box">
                    <select id="search_type">
                        <option value="name">출판사명</option>
                    </select>
                    <input type="text" id="keyword" placeholder="검색어 입력" value="${data.keyword}">
                    <button id="search_btn"><i class="fas fa-search"></i></button>
                </div>    
                <!-- <button id="reset_btn">초기화</button> -->
            </div>
            <div class="table_area">
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>출판사명</th>
                            <th>상태</th>
                            <th>등록일</th>
                            <th>수정일</th>
                            <th>조작</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.total == 0}">
                            <tr>
                                <td id="nodata" colspan="6">데이터가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="p">
                            <tr>
                                <td>${p.pi_seq}</td>
                                <td>${p.pi_name}</td>
                                <td>${p.pi_status}</td>
                                <td><fmt:formatDate value="${p.pi_reg_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td><fmt:formatDate value="${p.pi_mod_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td>
                                    <button class="modify_btn" data-seq="${p.pi_seq}"><i class="fas fa-pencil-alt"></i></button>
                                    <button class="delete_btn" data-seq="${p.pi_seq}"><i class="fas fa-minus-circle"></i></button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="pager_area">
                <!-- <button id="prev"><i class="fas fa-chevron-left"></i></button>
                <div class="pagers">
                    <c:forEach begin="1" end="${data.pageCnt}" var="i">
                        <a href="/publisher?offset=${(i-1)*10}&keyword=${data.keyword}">${i}</a>
                    </c:forEach>
                </div>
                <button id="next"><i class="fas fa-chevron-right"></i></button> -->
            </div>
        </div>
    </main>
    <div class="popup_wrap">
        <div class="popup" id="department_add">
            <div class="top_area">
                <div class="ico"><i class="fas fa-school"></i></div>
                <h2>출판사 추가</h2>
                <p>출판사 정보를 입력해주세요</p>
            </div>
            <div class="content_area">
                <input type="text" id="dep_name" placeholder="출판사 명"><br>
                <select id="dep_status">
                    <option value="1">운영중</option>
                    <option value="2">보류</option>
                    <option value="3">폐지예정</option>
                </select>
            </div>
            <div class="btn_area">
                <button id="add_dep">등록하기</button>
                <button id="modify_dep">수정하기</button>
                <button id="cancel_dep">취소하기</button>
            </div>
        </div>
    </div>
</body>
</html>