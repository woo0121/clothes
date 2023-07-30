package Common.Service;


import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Common.Dao.MemberDao;
import Common.Dto.MemberDto;

public class MemberService {

	
	//세션정보저장
	
	
	private MemberDao dao;

	
	
	//싱글톤ㄸ
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance==null)
			instance = new MemberService();
		return instance;
	}
	//
	public MemberService() {
		dao=MemberDao.getInstance();
		
	}
	
	//회원 가입하기
	public boolean memberJoin(MemberDto dto) throws Exception {
		int result = dao.insert(dto);
		if(result>0)
			return true;
		return false;
	}
	
	public int emailchecker(String email) {
	    MemberDao Dao = new MemberDao();
	    int eDao = Dao.email(email);
	    if (eDao == 0) {
//	    	23123
	    }
		return eDao;
	}	
}
	    	
	    	
	    
//	        String host = "http://localhost:8080/AuthGoogle/";
//	        String from = "qmflcl072165@gmail.com";
//	        String to = email;
//	        String code = SHA256.getEncrypt(to, "cos");
//
//	        String subject = "회원가입을 위한 이메일 인증 메일입니다.";
//	        String content = "다음 링크에 접속하여 이메일 인증을 진행해주세요. "
//	                + "<a href='" + host + "gmailCheckAction.jsp?code=" + code
//	                + "'>이메일 인증하기</a>";
//
//	        Properties p = new Properties();
//	        p.put("mail.smtp.user", from);
//	        p.put("mail.smtp.host", "smtp.gmail.com");
//	        p.put("mail.smtp.port", "465");
//	        p.put("mail.smtp.starttls.enable", "true");
//	        p.put("mail.smtp.auth", "true");
//	        p.put("mail.smtp.debug", "true");
//	        p.put("mail.smtp.socketFactory.port", "465");
//	        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//	        p.put("mail.smtp.socketFactory.fallback", "false");
//	        p.put("mail.smtp.ssl.enable", "true"); // 추가된 코드
//	        p.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // 추가된 코드
//	        
//	        try {
//	            Authenticator auth = new Gmail();
//	            Session ses = Session.getInstance(p, auth);
//	            ses.setDebug(true);
//	            MimeMessage msg = new MimeMessage(ses);
//	            msg.setSubject(subject);
//	            Address fromAddr = new InternetAddress(from);
//	            msg.setFrom(fromAddr);
//	            Address toAddr = new InternetAddress(to);
//	            msg.addRecipient(Message.RecipientType.TO, toAddr);
//	            msg.setContent(content, "text/html; charset=UTF8");
//	            Transport.send(msg);
//	        } catch (Exception e) {
//	            System.out.println("이메일 전송 실패: " + e.getMessage());
//	            return 0;
//	        }
//	    } else {
//	        return 0;
//	    }

