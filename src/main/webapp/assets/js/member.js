$(function(){
    $(".main_menu a:nth-child(3)").addClass("active");
    $("#add_member").click(function(){
        $(".popup_wrap").addClass("open");
        $("#add_mem").css("display", "inline-block");
        $("#modify_mem").css("display", "none");
        $(".popup .top_area h2").html("회원 추가");
        $(".popup .top_area p").html("회원 정보를 입력해주세요");
    })
    $("#add_mem").click(function(){
        let member_id = $("#member_id").val();
        let member_name = $("#member_name").val();
        let member_pwd = $("#member_pwd").val();
        let member_phone = $("#member_phone").val();
        let member_birth = $("#member_birth").val();
        let member_email = $("#member_email").val();
        let member_status = $("#member_status option:selected").val();
        let member_pwd_confirm = $("#member_pwd_confirm").val();

        if(member_id == undefined){
            alert("ID를 입력해주세요");
            return;
        }
        if(member_name == undefined){
            alert("이름을 입력해주세요");
            return;
        }
        if(member_pwd == ''){
            alert("비밀번호를 입력해주세요");
            return;
        }
        if(member_pwd != member_pwd_confirm){
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
            return;
        }

        let data= {
            mi_id: member_id,
            mi_name: member_name,
            mi_pwd :member_pwd,
            mi_phone_num :member_phone,
            mi_birth :member_birth,
            mi_email :member_email,
            mi_status :member_status
        }
        console.log(data);
        $.ajax({
            url:"/member/add",
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
    $("#cancel_mem").click(function(){
        if(confirm("취소하시겠습니까?\n(입력된 내용은 저장되지 않습니다. )")==false) return;

        $("#member_id").val("");
        $("#member_name").val("");
        $("#member_pwd").val("");
        $("#member_pwd_confirm").val("");
        $("#member_phone").val("");
        $("#member_birth").val("");
        $("#member_email").val("");
        $("#member_status").val("1").prop("selected", true);

        $(".popup_wrap").css("display","")
    })
})

