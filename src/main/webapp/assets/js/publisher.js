$(function(){
    $(".main_menu a:nth-child(7)").addClass("active");
    $("#add_department").click(function(){
        $(".popup_wrap").addClass("open");
        $("#add_dep").css("display", "inline-block");
        $("#modify_dep").css("display", "none");
        $(".popup .top_area h2").html("출판사 추가");
        $(".popup .top_area p").html("출판사 정보를 입력해주세요");
    })
    $("#add_dep").click(function(){
        if(confirm("출판사를 등록하시겠습니까?") == false) return;

        let publisher_name = $("#publisher_name").val();
        let publisher_status = $("#publisher_status option:selected").val();

        let data = {
            pi_name : publisher_name,
            pi_status : publisher_status 
        }

        $.ajax({
            type:"post",
            url:"/publisher/add",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r) {
                alert(r.message);
                if(r.status)
                    location.reload();
            }
        })
    })
    $("#cancel_dep").click(function(){
        if(confirm("취소하시겠습니까?\n(입력된 정보는 저장되지 않습니다.)") == false) return;

        $("#dep_name").val("");
        $("#dep_score").val("");
        $("#dep_status").val("1").prop("selected", true);

        $(".popup_wrap").removeClass("open");
    })

    $(".delete_btn").click(function(){
        if(confirm("출판사를 삭제하시겠습니까?\n(이 동작은 되돌릴 수 없습니다.)") == false) return;

        let seq = $(this).attr("data-seq");
        $.ajax({
            type:"delete",
            url:"/publisher/delete?seq="+seq,
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })

    let modify_data_seq = 0;

    $(".modify_btn").click(function(){

        modify_data_seq = $(this).attr("data-seq");

        $(".popup_wrap").addClass("open");
        $("#add_dep").css("display", "none");
        $("#modify_dep").css("display", "inline-block");
        $(".popup .top_area h2").html("출판사 수정");
        $(".popup .top_area p").html("수정할 내용을 입력해주세요");

        $.ajax({
            type:"get",
            url:"/publisher/get?seq="+$(this).attr("data-seq"),
            success:function(r){
                console.log(r);

                $("#publisher_name").val(r.data.pi_name);
                $("#publisher_status").val(r.data.pi_status).prop("selected", true);
            }
        })
    })
    $("#modify_dep").click(function(){
        if(confirm("수정하시겠습니까?") == false) return;
        
        let publisher_name = $("#publisher_name").val();
        let publisher_status = $("#publisher_status option:selected").val();

        let data = {
            pi_name : publisher_name,
            pi_status : publisher_status 
        }
        $.ajax({
            type:"patch",
            url:"/publisher/update",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})
