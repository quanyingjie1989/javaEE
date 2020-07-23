package org.asjy.service;

import java.util.List;

import org.asjy.Bean.Goods;

public interface GoodsService {
	
	int addGoods(Goods goods);
	
	List<Goods> searchGoods(Goods good);
	
	Goods getGoodsById(int id) throws Exception;
	
	void deleteGood(int id) throws Exception;

	int update(Goods goods);

}
