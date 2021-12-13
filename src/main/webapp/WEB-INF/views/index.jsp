<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%@include file="/WEB-INF/includes/header.jsp"%>
    <link rel="stylesheet" href="/assets/css/index.css">
    <script>
        $(function(){
            $(".main_menu a:nth-child(1)").addClass("active")
        })
    </script>   
</head>
<body>
    <%@include file="/WEB-INF/includes/header.jsp"%>
    <main>
        <h1>교보문고 관리 대시보드</h1>
        <div class="content_area">
            <div class="member_info">
                <h2><i class="fas fa-users"></i>회원 정보</h2>
                <p>총 등록 회원 : <span>${cnt.member[0]}명</span></p>
                <p>활동 회원 : <span>${cnt.member[1]}명</span></p>
                <p>탈퇴 회원 : <span>${cnt.member[2]}명</span></p>
                <p><i class="far fa-clock"></i>업데이트 날짜 : <span>2021-12-10 12:00:00</span></p>
            </div>
            <div class="book_info">
                <h2><i class="fas fa-book"></i>도서 정보</h2>
                <p>제품 총 재고 : <span>${cnt.book[0]}권</span></p>
                <p>판매 진행 제품 : <span>${cnt.book[1]}권</span></p>
                <p>판매 예정 제품 : <span>${cnt.book[2]}권</span></p>
                <p>판매 불가 제품 : <span>${cnt.book[3]}권</span></p>
                <p><i class="far fa-clock"></i>업데이트 날짜 : <span>2021-12-10 12:00:00</span></p>
            </div>
            <div class="order_info">
                <h2><i class="fas fa-clipboard-list"></i>주문 정보</h2>
                <p>총 주문 수 : <span>${cnt.order[0]}건</span></p>
                <p>완료 주문 수 : <span>${cnt.order[1]}건</span></p>
                <p>진행 주문 수: <span>${cnt.order[2]}건</span></p>
                <p>취소 주문 수: <span>${cnt.order[3]}건</span></p>
                <p><i class="far fa-clock"></i>업데이트 날짜 : <span>2021-12-10 12:00:00</span></p>
            </div>
            <div class="review_info">
                <h2><i class="far fa-pen-square"></i>리뷰 정보</h2>
                <p>총 등록 리뷰 : <span>${cnt.review[0]}개</span></p>
                <p>현재 등록 리뷰 수 : <span>${cnt.review[1]}개</span></p>
                <p>삭제된 리뷰 수 : <span>${cnt.review[2]}개</span></p>
                <p><i class="far fa-clock"></i>업데이트 날짜 : <span>2021-12-10 12:00:00</span></p>
            </div>
        </div>
    </main>
</body>
</html>