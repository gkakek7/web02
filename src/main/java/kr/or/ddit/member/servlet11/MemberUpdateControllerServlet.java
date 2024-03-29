package kr.or.ddit.member.servlet11;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.utils.PopulateUtills;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/member/memberUpdate.do")
public class MemberUpdateControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	// 현재 로그인한 사용자의 기본정보를 초기값으로 갖고 있는 수정 양식의 제공
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO authMember = (MemberVO)req.getSession().getAttribute("authMember");
		MemberVO member = service.retrieveMember(authMember.getMemId());
		req.setAttribute("member", member);
		String logicalViewName="member/memberEdit";
		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
	}
	// POST 파라미터로 수정 절차 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 특수문자 디코딩 설정
//		2. 17개의 파라미터를 받고 -> Commant Object로 캡슐화(MemberVO) Commend Object
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
//		member.setMemId(req.getParameter("memId"));
//		member.setMemPass(req.getParameter("memPass"));
		Map<String, String[]> parameterMap = req.getParameterMap();
		PopulateUtills.populate(member, parameterMap);
		MemberVO authMember=(MemberVO)req.getSession().getAttribute("authMember");
		member.setMemId(authMember.getMemId());
		// 2-1. 검증 작업 : 통과, 불통
		Map<String, String> errors = new LinkedHashMap<String, String>();
		req.setAttribute("errors", errors);
		boolean valid = ValidateUtils.validate(member, errors,UpdateGroup.class);
		
		String logicalViewName = null;
		if (errors.isEmpty()) {
//			3. 수정 로직 호출
			ServiceResult result = service.modifyMember(member);
//			4. 로직의 실행 결과에 따른 뷰 선택
			String message = null;
			switch (result) {
			case INVALIDPASSWORD:
				logicalViewName="member/memberEdit";
				message="인증 실패";
				break;
			case OK:
				logicalViewName="redirect:/mypage";
				break;
			default:
				logicalViewName="member/memberEdit";
				message="서버 오류";
				break;
			}
			req.setAttribute("message", message);
		} else {
			logicalViewName = "member/memberEdit";
		}

//		5. 해당 뷰로 이동.
		if (logicalViewName.startsWith("redirect:")) {
			String redirectViewName = req.getContextPath() + logicalViewName.substring("redirect:".length());
			resp.sendRedirect(redirectViewName);
		} else {
			req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
		}
	}
	
	
}
