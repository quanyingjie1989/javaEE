package org.asjy.user.service;

import org.asjy.user.bean.XxUser;

public interface XxUserService {
	
	XxUser login(String username,String password) throws Exception;

}
