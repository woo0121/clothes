var emailChecked = false; // 이 변수는 이메일 확인의 상태를 추적합니다.

var emailChecked = false; // 이 변수는 이메일 확인의 상태를 추적합니다.

function validateAndSubmitForm() {
  var emailInput = document.getElementById("email");

  // 이메일 입력이 비어 있는지 확인합니다.
  if (emailInput.value.trim() === "") {
    alert("이메일을 입력해주세요.");
    emailInput.focus();
    return false;
  }

  if (
    validatePassword() &&
    validatePasswordMatch() &&
    validatePhoneNumber() &&
    validateEmail() &&
    mergeAddressFields() &&
    emailChecked // 이메일 확인 상태 확인
  ) {
    return true;
  }

  return false;
}

// submitFormWithAxios 함수를 동일하게 유지합니다.

function emailcodecheck() {
  var emailcode = document.getElementById("emailcode").value;
  
  $.ajax({
    url: "./emailcodevalid",
    type: "post",
    data: { emailcode: emailcode },
    async: false,
    success: function (data) {
      if (data.resultList == 1) {
        alert("성공했습니다");
        emailChecked = true; // 이메일 확인 완료
      } else {
        alert("인증코드가 맞지 않습니다");
        document.getElementById("emailcode").value = "";
        document.getElementById("emailcode").addEventListener("focus", function () {
          // focus 이벤트가 발생했을 때 수행할 작업을 여기에 작성하세요.
        });

        emailChecked = false; // 이메일 확인 실패
      }
    },
    error: function () {
      alert("error");
      emailChecked = false; // 이메일 확인 실패
    },
  });
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
	var email2 = document.getElementsByName("email")[0].value;
	alert(email2);

	$(function() {
		$.ajax({
			url: "./emailchecker", // ./ 현재경로표시
			type: "post",
			data: { email: email2 },
			success: function(data) {


				var inputText = document.createElement("input");
				inputText.type = "text";
				inputText.id = "emailcode";
				var inputButton = document.createElement("input");
				inputButton.type = "button";
				inputButton.value = "입력 버튼";
				inputButton.onclick = emailcodecheck;

				var emailElement = document.getElementsByName("email")[0];
				emailElement.insertAdjacentElement("afterend", inputButton);
				emailElement.insertAdjacentElement("afterend", inputText);
				alert("success");
			},
			error: function() {
				alert("error");
			},
		});
	});
}

function emailcodecheck() {
	var emailcode = document.getElementById("emailcode").value;

	$(function() {
		$.ajax({
			url: "./emailcodevalid", // ./ 현재경로표시
			type: "post",
			data: { emailcode: emailcode },
			async: false,
			success: function(data) {
				// 결과값에 직접 접근하는 대신 파싱된 JSON 객체의 필드를 사용
				alert(data.resultList);
				if (data.resultList == 1) {
					alert("성공했습니다");
				} else {
					alert("인증코드가 맞지 않습니다");
					document.getElementById("emailcode").value = '';
					document.getElementById("emailcode").addEventListener("focus", function() {
						// focus 이벤트가 발생했을 때 수행할 작업을 여기에 작성하세요.
						
					});


				}
			},
			error: function() {
				alert("error");
			},
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


