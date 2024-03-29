package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리(CRUD) Persistence Layer
 *
 */
public interface ProdDAO {
	public int insertProd(ProdVO prod);
	
	/**
	 * totalRecord/totalPage 를 결정하기 위한 쿼리
	 * @param paging
	 * @return
	 */
	public int selectTotalRecord(PaginationInfo paging);	
	/**
	 * 페이징 처리 결과 데이터 목록 조회
	 * @param paging
	 * @return
	 */
	public List<ProdVO> selectProdList(PaginationInfo paging); //다건 조회
	
	public ProdVO selectProd(String prodId); //단건 조회
	public int updateProd(ProdVO prod);
}
