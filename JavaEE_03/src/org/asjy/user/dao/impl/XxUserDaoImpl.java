package org.asjy.user.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.asjy.Bean.Goods;
import org.asjy.user.bean.XxUser;
import org.asjy.user.dao.XxUserDao;
import org.asjy.util.JDBCUtil;

import com.mysql.jdbc.PreparedStatement;

public class XxUserDaoImpl implements XxUserDao{

	@Override
	public XxUser getXxuserByUsername(String username) {
		List<Goods> goodsList =new ArrayList<>();
		java.sql.Connection connection= null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		try {
			connection=JDBCUtil.getMySelfConnection();
			String sql="select id,username,password from xx_user where username = ?";
			pstm=(PreparedStatement) connection.prepareStatement(sql);
			pstm.setString(1, username);
			rs=pstm.executeQuery();
			if(rs.next()) {
				XxUser user=new XxUser(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.myselfClose(connection, pstm, rs);
		}
		return null;
	}
}
