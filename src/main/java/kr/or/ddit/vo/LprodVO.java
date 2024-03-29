package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="lprodId")
public class LprodVO {
	private Integer lprodId;
	private String lprodGu;
	private String lprodNm;
}
