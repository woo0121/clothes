/* @charset "UTF-8";
 *
 */
const projectPath="${pageContext.request.contextPath}"
// 로그인 버튼 클릭 이벤트 핸들러
  document.getElementById("login-button").addEventListener("click", function() {
    // 로그인 버튼 클릭 시 로그인 페이지로 이동
    window.location.href = "/TeamProject2/member/auth/Login.jsp";
  });
  
 