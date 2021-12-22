$(function(){
    $(".main_menu a:nth-child(5)").addClass("active");
    $("#search_book").click(function(){
        $(".book_search").css("display", "block");
    })
    $("#book_search_close").click(function(){
        $(".book_search").css("display","");
    })
    $("#book_keyword").keyup(function(e){
        if(e.keyCode == 13) $("#book_search_btn").trigger("click");
    }) 
    $("#book_search_btn").click(function(){
        $.ajax({
            url:"/book/keyword?keyword="+$("#book_keyword").val(),
            type:"get",
            success:function(r){
                console.log(r);
                $(".search_result ul").html("");
                for(let i=0; i<r.list.length; i++) {
                    let str_status = "";
                    if(r.list[i].bi_status == 1) str_status = "판매중"
                    if(r.list[i].bi_status == 2) str_status = "품절"
                    if(r.list[i].bi_status == 3) str_status = "절판"
                    if(r.list[i].bi_status == 4) str_status = "판매예정"

                    let tag = 
                    '<li>'+
                        '<a href="#" data-book-seq="'+r.list[i].bi_seq+'">'+r.list[i].bi_name+'</a>'+
                        '<span class="status'+r.list[i].bi_status+'">'+str_status+'</span>'+
                    '</li>';
                    $(".search_result ul").append(tag);
                }
                $(".search_result ul a").click(function(e){
                    e.preventDefault(); 
                    let seq = $(this).attr("data-book-seq");
                    let name = $(this).html();
                    alert(seq+"/"+name);
                $("#review_book_name").attr("data-book-seq", seq);
                $("#review_book_name").val(name);
                $(".search_result ul").html("");
                $("#dep_keywod").val("");
                $(".book_search").css("display", "");
                })           
            }
        })
    })
    $("#add_review").click(function(){
        if(confirm("도서를 추가하시겠습니까?") == false) return;

        let review_book_name = $("#review_book_name").attr("data-book-seq");
        let review_title = $("#review_title").val();
        let review_text = $("#review_text").val();
        let review_star = $("#review_star option:selected").val();
        let review_status = $("#review_status option:selected").val();

        if(review_book_name == undefined){
            alert("도서명을 입력해주세요");
            return;
        }
        if(review_title == ''){
            alert("제목을 입력해주세요");
            return;
        }
        if(review_text == ''){
            alert("리뷰 내용을 입력해주세요");
            return;
        }
        
        let data= {
            br_bi_seq : review_book_name,
            br_title : review_title,
            br_text : review_text,
            br_star : review_star,
            br_status : review_status
        }
        console.log(data);
        $.ajax({
            url:"/review/add",
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(e) {
                alert(e.message);
                if(e.status)
                    location.reload();
            }
        })
    })
    $("#review_add_btn").click(function(){
        $(".popup_wrap").css("display", "block")
        $("#add_review").css("display", "inline-block");
        $("#modify_review").css("display", "none");
        $("#cancel_review").css("display", "inline-block");
        $("#review_status").css("display", "none");
        $(".popup .top_area h2").html("리뷰 추가");
        $(".popup .top_area p").html("리뷰 정보를 입력해주세요");
    })
    $("#cancel_review").click(function(){
        if(confirm("취소하시겠습니까?\n(입력된 내용은 저장되지 않습니다. )")==false) return;

        $("#review_book_name").attr("data-book-seq", "");
        $("#review_book_name").val("");
        $("#review_title").val("");
        $("#review_text").val("");
        $("#review_star").val("1").prop("selected", true);
        $("#review_status").val("1").prop("selected", true);

        $(".popup_wrap").css("display","")
        $(".popup_wrap").removeClass("open");
    })
    $("#search_btn").click(function(){
        let type = $("#search_type option:selected").val()
        let keyword = $("#keyword").val()

        location.href = "/review?type="+type+"&keyword="+keyword;
    })
    $("#keyword").keydown(function(e){
        console.log(e.keyCode)
        if(e.keyCode == 13)
            $("#search_btn").trigger("click");
    })
    $(".delete_btn").click(function(){
        if(confirm("리뷰를 삭제하시겠습니까?\n(이 동작은 되돌릴 수 없습니다.)") == false) return;

        let seq = $(this).attr("data-seq");
        $.ajax({
            type:"delete",
            url:"/review/delete?seq="+seq,
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
    let modify_seq = 0;
    $(".modify_btn").click(function(){
        let seq=$(this).attr("data-seq");
        modify_seq = seq;
        $.ajax({
            url:"/review/get?seq="+seq,
            type:"get",
            success:function(r){
                $(".popup_wrap").addClass("open");
                $("#add_review").css("display", "none");
                $("#modify_review").css("display", "inline-block");
                $("#cancel_review").css("display", "inline-block");
                $("#review_status").css("display", "inline-block");
                $("#review_star").css("display", "none");
                $(".popup .top_area h2").html("리뷰 검토");
                $(".popup .top_area p").html("리뷰 상태를 점검해주세요");

                $("#review_book_name").attr("data-book-seq", r.br_bi_seq);
                $("#review_book_name").val(r.book_name).prop("disabled",true);
                $("#review_title").val(r.br_title).prop("disabled",true);
                $("#review_text").val(r.br_text).prop("disabled",true);
                $("#review_star").val(r.br_star).prop("selected", true);
                $("#review_status").val(r.br_status).prop("selected", true);
        
            }
        })
    })
    $("#modify_review").click(function(){
        if(confirm("수정하시겠습니까?") == false) return;
        let data = {
                br_seq : modify_seq,
                // br_bi_seq : $("#review_book_name").attr("data-book-seq"),
                // br_title : $("#review_title").val(),
                // br_text : $("#review_text").val(),
                // br_star : $("#review_star option:selected").val(),
                br_status : $("#review_status option:selected").val()
            }
            $.ajax({
                url:"/review/modify",
                type:"patch",
                data:JSON.stringify(data),
                contentType:"application/json",
                success:function(r){
                    alert(r.message);
                    if(r.status)
                        location.reload();
                }
            })
        })
})