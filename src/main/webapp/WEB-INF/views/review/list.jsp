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
    <link rel="stylesheet" href="/assets/css/review_list.css">
    <script src="assets/js/review.js"></script>
</head>
<body>
    <main>
        <h1><i class="fas fa-users"></i>   리뷰 관리</h1>
        <!-- <button id="review_add_btn"><i class="fas fa-plus-circle"></i>리뷰 추가</button> -->
        <div class="content_area">
            <div class="menu_area">
                <div class="search_box">
                    <select id="search_type">
                        <option value="book_name">도서명</option>
                        <option value="title">리뷰제목</option>
                    </select>
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
                            <th>도서명</th>
                            <th>제목</th>
                            <th>리뷰</th>
                            <th>별점</th>
                            <th>상태</th>
                            <th>등록일</th>
                            <th>수정일</th>
                            <th>검토</th>
                            <th>삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.list.size() == 0}">
                            <tr>
                                <td id="nodata" colspan="10">데이터가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="b">
                            <tr>
                                <td>${b.br_seq}</td>
                                <td>${b.book_name}</td>
                                <td>${b.br_title}</td>
                                <td>${b.br_text}</td>
                                <td class="book_status">
                                    <c:if test="${b.br_star ==1}">
                                        <span>★</span>
                                    </c:if>
                                    <c:if test="${b.br_star ==2}">
                                        <span>★★</span>
                                    </c:if>
                                    <c:if test="${b.br_star ==3}">
                                        <span>★★★</span>
                                    </c:if>
                                    <c:if test="${b.br_star ==4}">
                                        <span>★★★★</span>
                                    </c:if>
                                    <c:if test="${b.br_star ==5}">
                                        <span>★★★★★</span>
                                    </c:if>
                                </td>
                                <td class="review_status">
                                    <c:if test="${b.br_status ==1}">
                                        <span style="background-color: rgb(17, 226, 27);">정상</span>
                                    </c:if>
                                    <c:if test="${b.br_status ==2}">
                                        <span style="background-color: rgb(255,23,23);">삭제예정</span>
                                    </c:if>
                                    <c:if test="${b.br_status ==3}">
                                        <span style="background-color: rgb(251,186,64);">숨김처리</span>
                                    </c:if>
                                </td>
                                <td><fmt:formatDate value="${b.br_reg_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td><fmt:formatDate value="${b.br_mod_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td>
                                    <button class="modify_btn" data-seq="${b.br_seq}"><i class="fas fa-pencil-alt"></i></button>
                                </td>
                                <td>
                                    <button class="delete_btn" data-seq="${b.br_seq}"><i class="fas fa-minus-circle"></i></button>
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
                        <a href="/review?offset=${(i-1)*10}&type=${type}&keyword=${keyword}">${i}</a>
                    </c:forEach>
                </div>
                <button id="next"><i class="fas fa-chevron-right"></i></button>
            </div>
        </div>
    </main>
    <div class="popup_wrap">
        <div class="popup" id="review_add">
            <div class="top_area">
                <div class="ico"><i class="fas fa-users"></i></div>
                <h2>리뷰 추가</h2>
                <p>리뷰 정보를 입력해주세요</p>
            </div>
            <div class="content_area">
                <input type="text" id="review_book_name" placeholder="도서 명">
                <button id="search_book">도서 검색</button>
                <br>
                <input type="text" id="review_title" placeholder="제목">
                <input type="text" id="review_text" placeholder="리뷰를 작성해주세요">
                <select id="review_star">
                    <option value="1">(1.0) ★</option>
                    <option value="2">(2.0) ★★</option>
                    <option value="3">(3.0) ★★★</option>
                    <option value="4">(4.0) ★★★★</option>
                    <option value="5">(5.0) ★★★★★</option>
                </select>
                <select id="review_status">
                    <option value="1">정상</option>
                    <option value="2">삭제예정</option>
                    <option value="3">숨김처리</option>
                </select>
            </div>
            <div class="btn_area">
                <button id="add_review">등록하기</button>
                <button id="modify_review">수정하기</button>
                <button id="cancel_review">취소하기</button>
            </div>
        </div>
    </div>
    <div class="book_search">
        <div class="book_search_box">
            <input type="text" id="book_keyword" placeholder="예) 나의 라임오렌지 나무, 나의, 나무">
            <button id="book_search_btn"><i class="fas fa-search"></i></button>
        </div>
        <div class="search_result">
            <ul>
            </ul>
        </div>
        <div class="book_search_buttons">
            <button id="book_search_close">닫기</button>
        </div>
    </div>
</body>
</html>