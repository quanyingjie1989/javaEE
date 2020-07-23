package org.asjy.dao;

import java.util.List;

import org.asjy.Bean.Goods;

public interface GoodsDao  {
	
	/**
	 * 添加商品
	 * @param goods
	 * @return -1 失败，=0 成功
	 */

	int insert(Goods goods);
	
	List<Goods>getGoods(Goods goods);
	
	Goods getGoodById(int id);
	
	int upDate(Goods goods);
	
	void deleteGood(int id) throws Exception;
	
	int getGoodsCount();

}
