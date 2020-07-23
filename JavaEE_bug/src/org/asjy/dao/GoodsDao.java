package org.asjy.dao;

import java.util.List;

import org.asjy.Bean.Goods;

public interface GoodsDao  {
	
	/**
	 * �����Ʒ
	 * @param goods
	 * @return -1 ʧ�ܣ�=0 �ɹ�
	 */

	int insert(Goods goods);
	
	List<Goods>getGoods(Goods goods);
	
	Goods getGoodById(int id);
	
	int upDate(Goods goods);
	
	void deleteGood(int id) throws Exception;
	
	int getGoodsCount();

}
