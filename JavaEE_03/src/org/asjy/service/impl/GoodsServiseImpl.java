package org.asjy.service.impl;

import java.util.List;

import org.asjy.Bean.Goods;
import org.asjy.dao.GoodsDao;
import org.asjy.dao.impl.GoodsDaoImpl;
import org.asjy.service.GoodsService;

public class GoodsServiseImpl implements GoodsService {

	private GoodsDao dao=new GoodsDaoImpl(); 
	
	@Override
	public int addGoods(Goods goods) {
		
		return dao.insert(goods);
	}
	
	@Override
	public List<Goods> searchGoods(Goods good) {
		
		return dao.getGoods(good);
	}

	@Override
	public Goods getGoodsById(int id)  throws Exception {
		Goods goods =dao.getGoodById(id);
		if(goods == null) {
			Exception ex =new Exception("该商品没找到");
			throw ex;
		}
		return goods;
	}

	@Override
	public void deleteGood(int id) throws Exception {
		dao.deleteGood(id);
	}

	@Override
	public int update(Goods goods) {
		return dao.upDate(goods);
	}
}
