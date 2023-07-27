        function validateAndSubmitForm() {
            if (validatePassword() && validatePasswordMatch() && validatePhoneNumber() && validateEmail() && mergeAddressFields()) {
                return true;
            }
            return false;

        }
        function validatePassword() {
            var pwd = document.getElementsByName('pwd')[0].value;
            var regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()-+=`~_])[a-zA-Z\d!@#$%^&*()-+=`~_]{8,12}$/;
            if (!regex.test(pwd)) {
                alert('비밀번호는 영문자, 숫자, 특수문자가 각각 1개 이상 포함되어야하며, 최소 8자 이상 최대 12자 이하여야 합니다.');
                return false;
            }
            return true;
        }
        function validatePasswordMatch() {
            var pwd = document.getElementsByName('pwd')[0].value;
            var re_pwd = document.getElementsByName('re_pwd')[0].value;

            if (pwd !== re_pwd) {
                alert('비밀번호와 재입력한 비밀번호가 일치하지 않습니다.');
                return false;
            }
            return true;
        }
        function validatePhoneNumber() {
            var phone = document.getElementsByName('phone')[0].value;
            var regex = /^01(?:0|1|[6-9])[-]\d{3,4}[-]\d{4}$/;

            if (!regex.test(phone)) {
                alert('올바른 핸드폰 번호를 입력해주세요.');
                return false;
            }
            return true;
        }
        function validateEmail() {
            var email = document.getElementsByName('email')[0].value;
            var regex = /^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(-[A-Za-z0-9]+)*(\.[A-Za-z]{2,})(\,[A-Za-z0-9]+(-[A-Za-z0-9]+)*(\.[A-Za-z]{2,}))*/;

            if (!regex.test(email)) {
                alert('올바른 이메일 형식을 입력해주세요.');
                return false;
            }
            return true;
        }

       

function submitFormWithAxios() {
			var email2 = document.getElementsByName('email')[0].value;
			alert(email2)
            $(function () {

                    $.ajax({
                        url: "./emailchecker",  // ./ 현재경로표시
                        type: "post",
                        data: { email : email2}, 
                        success: function (data) { // Ajax 목적 : data를 얻기 위함
                                   alert('success');
                            //      alert(data);
                            //      alert(JSON.stringify(data));// 날린 데이터 확인

                       
                            alert(data.list[0].number); // 날린 데이터 확인
                            alert(data.list[0].name);
                            // for문과 foreach문 사용해서 데이터 전체를 뽑을 수 있다.      

                        },
                        errer: function () {
                            alert('errer');
                        }
                    });
         
            });
        }



        function mergeAddressFields() {
            var postcode = document.getElementById('sample6_postcode').value;
            var address = document.getElementById('sample6_address').value;
            var detailAddress = document.getElementById('sample6_detailAddress').value;
            var extraAddress = document.getElementById('sample6_extraAddress').value;

            if (postcode === '' || address === '' || detailAddress === '') {
                alert('주소 정보를 모두 입력해 주세요.');
                return false;
            }

            var fullAddress = postcode + ' ' + address + ' ' + detailAddress + ' ' + extraAddress;
            document.getElementById('merged_addr').value = fullAddress;
            return true;
        }
 
  
 	