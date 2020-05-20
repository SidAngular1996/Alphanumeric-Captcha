package com.icegate.IceGate.service;

import com.icegate.IceGate.entity.UserEntity;
import com.icegate.IceGate.response.GenericResponse;
import com.icegate.IceGate.vo.UserVO;

public interface UserService {
	public GenericResponse getUserDetails(Long userId);

	public GenericResponse getUserList();
	
	public void send(UserEntity user);

	public GenericResponse registerNewUserAccount(UserVO user) throws Exception;

	GenericResponse registerNewUserAccountViaBotDetect(UserVO user) throws Exception;
}
