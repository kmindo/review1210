$(function(){
    $(".main_menu a:nth-child(4)").addClass("active");
    $("#add_popup").click(function(){
        let employee_number = $("#employee_number").val();
        let employee_name = $("#employee_name").val();
        let employee_pwd = $("#employee_pwd").val();
        let employee_phone = $("#employee_phone").val();
        let employee_birth = $("#employee_birth").val();
        let employee_email = $("#employee_email").val();
        let employee_status = $("#employee_status").val();

        let employee_pwd_confirm = $("#employee_pwd_confirm").val();
        if(employee_pwd == ''){
            alert("비밀번호를 입력해주세요");
            return;
        }
        if(employee_pwd != employee_pwd_confirm){
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
            return;
        }
    
        let data= {
            ei_number : employee_number,
            ei_name :employee_name,
            ei_pwd : employee_pwd,
            ei_phone_num :employee_phone,
            ei_birth :employee_birth,
            ei_email : employee_email,
            ei_status : employee_status
        }
        $.ajax({
            url:"/employee/add",
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
    $("#add_employee").click(function(){
        $(".popup_wrap").css("display", "block")
        $("#modify_popup").css("display", "none");
        $("#add_popup").css("display", "inline-block");
        $("#cancel_popup").css("display", "inline-block");
        $(".popup .top_area h2").html("직원 추가");
        $(".popup .top_area p").html("직원 정보를 입력해주세요");
    })
    $("#cancel_popup").click(function(){
        if(confirm("취소하시겠습니까?\n(입력된 내용은 저장되지 않습니다. )")==false) return;

        $("#employee_number").val("");
        $("#employee_name").val("");
        $("#employee_pwd").val("");
        $("#employee_phone").val("");
        $("#employee_birth").val("");
        $("#employee_email").val("");
        $("#employee_status").val("1").prop("selected", true);

        $(".popup_wrap").css("display","")
    })

    $(".delete_btn").click(function(){
        if(!confirm("삭제하시겠습니까?")) return
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/employee/delete?seq="+seq,
            type:"delete",
            success:function(r){
                alert(r.message)
                if(r.status) 
                    location.reload();
            }
        })
    })

    let modify_seq = 0;
    $(".modify_btn").click(function(){
        let seq = $(this).attr("data-seq");
        modify_seq = seq;
        $.ajax({
            url:"/employee/get?seq="+seq,
            type:"get",
            success:function(r){
                $(".popup_wrap").css("display", "block");
                $("#add_popup").css("display", "none");
                $("#modify_popup").css("display", "inline-block");
                $("#cancel_popup").css("display", "inline-block");
                $(".popup .top_area h2").html("직원 수정");
                $(".popup .top_area p").html("수정할 정보를 입력하세요");

                $("#employee_number").val(r.ei_number);
                $("#employee_name").val(r.ei_name);
                $("#employee_pwd").val("*********").prop("disabled", true);
                $("#employee_pwd_confirm").val("*********").prop("disabled", true);
                $("#employee_phone").val(r.ei_phone_num);
                $("#employee_birth").val(r.ei_birth);
                $("#employee_email").val(r.ei_email);
                $("#employee_status").val(r.ei_status).prop("selected", true);
            }
        })
    })
    $("#modify_popup").click(function(){
        if(confirm("수정하시겠습니까?") == false) return;
        let data = {
            ei_seq:modify_seq,
            ei_number : $("#employee_number").val(),
            ei_name : $("#employee_name").val(),
            ei_phone_num : $("#employee_phone").val(),
            ei_birth : $("#employee_birth").val(),
            ei_email : $("#employee_email").val(),
            ei_status : $("#employee_status option:selected").val()
            }
            $.ajax({
                url:"/employee/modify",
                type:"patch",
                data:JSON.stringify(data),
                contentType:"application/json",
                success:function(r){
                    console.log(r);
                    alert(r.message);
                    if(r.status)
                        location.reload();
                }
            })
        })
        $("#search_btn").click(function(){
            let type = $("#search_type option:selected").val()
            let keyword = $("#keyword").val()
    
            location.href = "/employee?type="+type+"&keyword="+keyword;
        })
        $("#keyword").keydown(function(e){
            console.log(e.keyCode)
            if(e.keyCode == 13)
                $("#search_btn").trigger("click");
        })
    })
    
    