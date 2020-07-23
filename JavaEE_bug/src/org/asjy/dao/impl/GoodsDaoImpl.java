package org.asjy.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.asjy.Bean.Goods;
import org.asjy.dao.GoodsDao;
import org.asjy.util.JDBCUtil;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GoodsDaoImpl implements GoodsDao{
	
	/**
	 * 添加商品
	 */

	@Override
	public int insert(Goods goods) {
		java.sql.Connection connection= JDBCUtil.getMySelfConnection();
		PreparedStatement pstm = null;
		
		try {
			String sql ="insert into goods(id,goods_name,goods_price) VALUE(?,?,?)";
			pstm=(PreparedStatement) connection.prepareStatement(sql);
			pstm.setInt(1, goods.getId());
			pstm.setString(2, goods.getGoodsName());
			pstm.setDouble(3, goods.getGoodsPricae());
			int ret = pstm.executeUpdate();
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.myselfClose(connection, pstm, null);
		}
	}
	
	/**
	 * 商品全部查询
	 */

	@Override
	public List<Goods> getGoods(Goods goods) {
		List<Goods> goodsList =new ArrayList<>();
		java.sql.Connection connection= null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		
		try {
			connection=JDBCUtil.getMySelfConnection();
			String sql="select id,goods_name,goods_price from goods";
			
			String condition ="";
			
			if(goods.getGoodsName() != null && !"".equals(goods.getGoodsName())) {
				condition = " where goods_name like'%"+goods.getGoodsName()+"%'";
			}
			sql += condition;
			sql += " limit "+(goods.getPageSize()*(goods.getPageNum()-1))+","+goods.getPageSize(); 
			System.out.println(sql);
			
			pstm=(PreparedStatement) connection.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				Goods good=new Goods(rs.getInt("id"), rs.getString("goods_name"), rs.getDouble("goods_price"));
			    goodsList.add(good);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.myselfClose(connection, pstm, rs);
		}
		return goodsList;
	}
	
	/**
	 * 根据ID查询商品
	 */

	@Override
	public Goods getGoodById(int id) {
		List<Goods> goodsList =new ArrayList<>();
		java.sql.Connection connection= null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		
		try {
			connection=JDBCUtil.getMySelfConnection();
			String sql="select id,goods_name,goods_price from goods where id = ?";
			pstm=(PreparedStatement) connection.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()) {
				Goods goods=new Goods(rs.getInt("id"), rs.getString("goods_name"), rs.getDouble("goods_price"));
				return goods;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.myselfClose(connection, pstm, rs);
		}
		return null;
	}

	/**
	 * 删除商品
	 */
	
	@Override
	public void deleteGood(int id) throws Exception {
		java.sql.Connection connection= JDBCUtil.getMySelfConnection();
		PreparedStatement pstm = null;
		try {
			String sql ="delete from goods where id = ?";
			pstm=(PreparedStatement) connection.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (Exception ex) {
			throw ex;
		}finally {
			JDBCUtil.myselfClose(connection, pstm, null);
		}
	}
	
	/**
	 * 修改商品
	 */

	@Override
	public int upDate(Goods goods) {
		java.sql.Connection connection= JDBCUtil.getMySelfConnection();
		PreparedStatement pstm = null;
		
		try {
			String sql ="update goods set goods_name = ?,goods_price = ? where id = ?";
			pstm=(PreparedStatement) connection.prepareStatement(sql);
			pstm.setString(1, goods.getGoodsName());
			pstm.setDouble(2, goods.getGoodsPricae());
			pstm.setInt(3, goods.getId());
			int ret = pstm.executeUpdate();
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.myselfClose(connection, pstm, null);
		}
	}
	
	/**
	 * 查询商品数量
	 */

	@Override
	public int getGoodsCount() {
		java.sql.Connection connection= null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		
		try {
			connection=JDBCUtil.getMySelfConnection();
			String sql="select count(*) from goods";
			pstm=(PreparedStatement) connection.prepareStatement(sql);
			rs=pstm.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.myselfClose(connection, pstm, rs);
		}
		return 0;
	}
}
