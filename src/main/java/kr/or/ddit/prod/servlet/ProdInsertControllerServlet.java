package kr.or.ddit.prod.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.others.advice.OthersControllerAdvice;
import kr.or.ddit.others.dao.OthersDAO;
import kr.or.ddit.others.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.utils.PopulateUtills;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodInsert.do")
public class ProdInsertControllerServlet extends HttpServlet{
	
	private ProdService service = new ProdServiceImpl();
	private OthersControllerAdvice advice = new OthersControllerAdvice();
	// view layer로 연결하기 위한 컨트롤러
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		advice.addLprodList(req);
		advice.addBuyerList(req);
		
		String logicalViewName = "prod/prodForm";
		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
	}
	
	// form 을 통해 전송된 데이터에 대한 처리를 위한 컨트롤러
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		advice.addLprodList(req);
		advice.addBuyerList(req);
		//인코딩
		//데이터 받기
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		PopulateUtills.populate(prod, parameterMap);
		
		Map<String, String> errors = new LinkedHashMap<String, String>();
		req.setAttribute("errors", errors);
		//검증 - 데이터베이스의 스키마에 따라 검증
		boolean validate = ValidateUtils.validate(prod, errors,InsertGroup.class);
		
		String logicalViewName = null;
		if (errors.isEmpty()) {
//			3. 가입 로직 호출
			ServiceResult result = service.createProd(prod);
//			4. 로직의 실행 결과에 따른 뷰 선택
			switch (result) {
			case OK:
				logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId(); // Post-Redirect-Get
				break;
			default :
				logicalViewName = "prod/prodForm";
			}
		} else {
			logicalViewName = "prod/prodForm";
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
