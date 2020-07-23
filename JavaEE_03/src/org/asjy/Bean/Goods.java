package org.asjy.Bean;

public class Goods {
	
	private Integer id;
	
	private String goodsName;
	
	private Double goodsPricae;
	
	private Integer pageSize = 2 ;
	
	private Integer pageNum = 1;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Double getGoodsPricae() {
		return goodsPricae;
	}
	public void setGoodsPricae(Double goodsPricae) {
		this.goodsPricae = goodsPricae;
	}
	public Goods(Integer id, String goodsName, Double goodsPricae) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.goodsPricae = goodsPricae;
	}
	public Goods() {	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	

}
