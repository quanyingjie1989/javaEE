package org.asjy.user.service.impl;

import java.io.DataOutput;

import org.asjy.user.bean.XxUser;
import org.asjy.user.dao.XxUserDao;
import org.asjy.user.dao.impl.XxUserDaoImpl;
import org.asjy.user.service.XxUserService;

public class XxUserServiceImpl implements XxUserService {
	
	XxUserDao dao =new XxUserDaoImpl();

	@Override
	public XxUser login(String username, String password) throws Exception {
		XxUser user=dao.getXxuserByUsername(username);
		
		if (user == null) {
			throw new Exception("该用户不存在");
		}
		
		if (password.equals(user.getPassword())) {
			return user;
		}else {
			throw new Exception("密码错误");
		}
	}

}
