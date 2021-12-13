$(function(){
    $(".main_menu a:nth-child(2)").addClass("active");
    $("#add_book").click(function(){
        $(".popup_wrap").addClass("open");
    })
    $("#add_bk").click(function(){
        if(confirm("도서를 등록하시겠습니까?") == false) return;

        let book_name = $("#book_name").val();
        let book_category = $("#book_category option:selected").val();
        let book_publisher = $("#book_publisher").val();
        let book_author = $("#book_author").val();
        let book_stock = $("#book_stock").val();
        let book_price = $("#book_price").val();
        let book_pub_date = $("#book_pub_date").val();
        let book_status = $("#book_status option:selected").val();

        let data = {
            bi_name : book_name,
            bi_sc_seq : book_category,
            bi_publisher : book_publisher,
            bi_author : book_author,
            bi_stock : book_stock,
            bi_price : book_price,
            bi_pub_date : book_pub_date,
            bi_status : book_status 
            
        }

        $.ajax({
            type:"post",
            url:"/book/add",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r) {
                alert(r.message);
                if(r.status)
                    location.reload();
            }
        })
    })
    $("#cancel_bk").click(function(){
        if(confirm("취소하시겠습니까?\n(입력된 정보는 저장되지 않습니다.)") == false) return;

        $("#book_name").val("");
        $("#book_category").val("1").prop("selected", true);
        $("#book_publisher").val("");
        $("#book_author").val("");
        $("#book_stock").val("");
        $("#book_price").val("");
        $("#book_pub_date").val("");
        $("#book_status").val("1").prop("selected", true);

        $(".popup_wrap").removeClass("open");
    })

    $(".delete_btn").click(function(){
        if(confirm("도서를 삭제하시겠습니까?\n(이 동작은 되돌릴 수 없습니다.)") == false) return;

        let seq = $(this).attr("data-seq");
        $.ajax({
            type:"delete",
            url:"/book/delete?seq="+seq,
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})