package org.crazyit.hrsystem.service;

import org.crazyit.hrsystem.domain.Adminater;
import org.crazyit.hrsystem.domain.Username;

public interface UsernameManager {
	public static final int LOGIN_FAIL = 0;
	public static final int LOGIN_User = 1;
	public static final int LOGIN_Adm = 2;
	int validLogin(Adminater adm);
	Username findUsernameByname(String name);
	Username findUsernameByphone(String phone);
	boolean saveUsername(Username username);
	boolean updatePassword(String phone,String password);
	boolean updatephone(String name,String oldphone,String newphone);
	boolean deleteUsername(Username username);
	boolean updateinfor(String name,String info);
}
