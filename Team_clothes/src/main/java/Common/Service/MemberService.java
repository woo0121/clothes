package Common.Service;


import javax.mail.MessagingException;

import Common.Dao.MemberDao;
import Common.Dto.EmailCodeDto;
import Common.Dto.MemberDto;
import Common.util.EmailSecret;
import Common.util.EmailSender;

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

	public int emailchecker(EmailCodeDto Dto) {
	    MemberDao Dao = new MemberDao();
	    int eDao = Dao.email(Dto);
	    
	    if(eDao == 0) {
	    	EmailSecret es1 = new EmailSecret();
			String subject = "성공적으로 보냄";
			String code = es1.generateRandomCode(5);
			String messageText = "이메일 코드는 : "  + code;
			
			String from = "naraba6070@gmail.com"; // 보낸사람 이메일
			String password = "dvreggprmxjuqetz"; // 비밀번호

			try {
			    EmailSender emailSender = new EmailSender(from, password);
			    emailSender.sendEmail(Dto.getEmail(), subject, messageText);
			    Dto.setEmailcode(code);
			    dao.emailcode(Dto);
			    
			} catch (MessagingException e) {
			    e.printStackTrace(); // 추가로 콘솔에 출력하여 오류 메시지 확인
			} catch (Exception e) {
			    e.printStackTrace(); // 추가로 콘솔에 출력하여 오류 메시지 확인
			}	    	
	    }
		return eDao;
	}
	
	
	public int emailcodevaild(EmailCodeDto Dto) {
		return dao.emailvalid(Dto);
		
	}
}




