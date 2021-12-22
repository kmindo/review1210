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
    <script src="assets/js/book.js"></script>
</head>
<body>
    <main>
        <h1><i class="fas fa-book"></i>   도서 관리</h1>
        <button id="add_book"><i class="fas fa-plus-circle"></i>도서 추가</button>
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
                            <th>카테고리</th>
                            <th>책이름</th>
                            <th>출판사</th>
                            <th>작가</th>
                            <th>재고</th>
                            <th>가격</th>
                            <th>출판일</th>
                            <th>상태</th>
                            <th>등록일</th>
                            <th>수정일</th>
                            <th>수정/삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.total == 0}">
                            <tr>
                                <td id="nodata" colspan="12">데이터가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="b">
                            <tr>
                                <td>${b.bi_seq}</td>
                                <td class="book_category">
                                    <c:if test="${b.bi_sc_seq==1}">
                                        <span>경제/경영</span>
                                    </c:if>
                                    <c:if test="${b.bi_sc_seq==2}">
                                        <span>과학</span>
                                    </c:if>
                                    <c:if test="${b.bi_sc_seq==3}">
                                        <span>만화</span>
                                    </c:if>
                                    <c:if test="${b.bi_sc_seq==4}">
                                        <span>소설</span>
                                    </c:if>
                                    <c:if test="${b.bi_sc_seq==5}">
                                        <span>시/에세이</span>
                                    </c:if>
                                    <c:if test="${b.bi_sc_seq==6}">
                                        <span>역사/문화</span>
                                    </c:if>
                                    <c:if test="${b.bi_sc_seq==7}">
                                        <span>예술/대중문화</span>
                                    </c:if>
                                    <c:if test="${b.bi_sc_seq==8}">
                                        <span>요리</span>
                                    </c:if>
                                    <c:if test="${b.bi_sc_seq==9}">
                                        <span>인문</span>
                                    </c:if>
                                </td>
                                <td>${b.bi_name}</td>
                                <td>${b.bi_publisher}</td>
                                <td>${b.bi_author}</td>
                                <td>${b.bi_stock}</td>
                                <td>${b.bi_price}</td>
                                <td>${b.bi_pub_date}</td>
                                <td class="book_status">
                                    <c:if test="${b.bi_status ==1}">
                                        <span style="background-color: rgb(17, 226, 27);">판매중</span>
                                    </c:if>
                                    <c:if test="${b.bi_status ==2}">
                                        <span style="background-color: rgb(225,110,26);">품절</span>
                                    </c:if>
                                    <c:if test="${b.bi_status ==3}">
                                        <span style="background-color: rgb(251,186,64);">절판</span>
                                    </c:if>
                                </td>
                                <td><fmt:formatDate value="${b.bi_reg_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td><fmt:formatDate value="${b.bi_mod_dt}" pattern="yyyy년 MM월 dd일(EE) HH:mm:ss"/></td>
                                <td>
                                    <button class="modify_btn" data-seq="${b.bi_seq}"><i class="fas fa-pencil-alt"></i></button>
                                    <button class="delete_btn" data-seq="${b.bi_seq}"><i class="fas fa-minus-circle"></i></button>
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
                        <a href="/book?offset=${(i-1)*10}&keyword=${data.keyword}">${i}</a>
                    </c:forEach>
                </div>
                <button id="next"><i class="fas fa-chevron-right"></i></button>
            </div>
        </div>
    </main>
    <div class="popup_wrap">
        <div class="popup" id="book_add">
            <div class="top_area">
                <div class="ico"><i class="fas fa-book"></i></div>
                <h2>도서 추가</h2>
                <p>도서 정보를 입력해주세요</p>
            </div>
            <div class="content_area">
                <input type="text" id="book_name" placeholder="도서명"><br>
                <select id="book_category"><br>
                    <option value="1">경제/경영</option>
                    <option value="2">과학</option>
                    <option value="3">만화</option>
                    <option value="4">소설</option>
                    <option value="5">시/에세이</option>
                    <option value="6">역사/문화</option>
                    <option value="7">예술/대중문화</option>
                    <option value="8">요리</option>
                    <option value="9">인문</option>
                <input type="text" id="book_publisher" placeholder="출판사">
                <button id="search_pub">검색</button>
                <br>
                <input type="text" id="book_author" placeholder="작가"><br>
                <input type="number" id="book_stock" placeholder="재고"><br>
                <input type="number" id="book_price" placeholder="가격"><br>
                <input type="text" id="book_pub_date" placeholder="출판일"><br>
                <select id="book_status">
                    <option value="1">판매중</option>
                    <option value="2">품절</option>
                    <option value="3">절판</option>
                </select>
            </div>
            <div class="btn_area">
                <button id="add_bk">등록하기</button>
                <button id="modify_bk">수정하기</button>
                <button id="cancel_bk">취소하기</button>
            </div>
        </div>
    </div>

    <div class="department_search">
        <div class="dep_search_box">
            <input type="text" id="dep_keyword" placeholder="예) 민음사, 민음, 민">
            <button id="dep_search_btn"><i class = "fas fa-search"></i></button>
        </div>
        <div class="search_result">
            <ul>
            </ul>
        </div>
        <div class="dep_search_buttons">
            <button id="dep_search_close">닫기</button>
        </div>
    </div>
</body>
</html>