package com.icegate.IceGate.serviceIMPL;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icegate.IceGate.entity.UserEntity;
import com.icegate.IceGate.repository.UserRepository;
import com.icegate.IceGate.response.GenericResponse;
import com.icegate.IceGate.service.UserService;
import com.icegate.IceGate.vo.Mapper;
import com.icegate.IceGate.vo.UserVO;

@Service("userService")
public class UserServiceIMPL implements UserService {

	@Autowired
	private AmqpTemplate rabbitTemp;

//	@Autowired
//	private CaptchaValidator captchaService;

	@Autowired
	private UserRepository user_repo;

	@Value("${icegate.user.exchange}")
	private String exchange;

	@Value("${icegate.user.routingkey}")
	private String routingkey;

	@Override
	public GenericResponse getUserDetails(Long userId) {
		UserEntity user = user_repo.findById(userId).get();
		this.send(user);
//		Optional<UserEntity> user = user_repo.findById(userId);
		return null != user ? new GenericResponse(true, "user found", 200, new UserVO(user))
				: new GenericResponse(false, "user not found", 404, null);
	}

	@Override
	public GenericResponse getUserList() {
		List<UserEntity> userList = user_repo.findAll();
		return null != userList && userList.size() != 0
				? new GenericResponse(true, "user found", 200, Mapper.mapListEntityToList_vo(userList))
				: new GenericResponse(false, "user not found", 404, null);
	}

	public void send(UserEntity user) {
		rabbitTemp.convertAndSend(exchange, routingkey, user);
		System.out.println("Send msg = " + user);

	}

	@Override
	public GenericResponse registerNewUserAccount(UserVO user) throws Exception {
		Boolean isValidCaptcha = true;
//				captchaService.validateCaptcha(user.getCaptchaResponse());
		GenericResponse genericResponse = null;
		try {
			if (isValidCaptcha) {
				UserEntity userEntity = new UserEntity();
				userEntity.setLoginId(user.getLoginId());
				userEntity.setPassword(user.getPassword());
				userEntity.setCompany(user.getCompany());
				userEntity.setContact(user.getContact());
				userEntity.setFirstName(user.getFirst_name());
				userEntity.setLastName(user.getLast_name());
				userEntity.setCreatedDate(LocalDateTime.now());
				user_repo.save(userEntity);
				genericResponse = new GenericResponse(true, "user added", 200, user);
			} else if (!isValidCaptcha) {
				throw new Exception("Captcha is not valid");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			genericResponse = new GenericResponse(false, e.getMessage(), 200, user);
		}
		return genericResponse;
	}
	
	
	@Override
	public GenericResponse registerNewUserAccountViaBotDetect(UserVO user) throws Exception {
		GenericResponse genericResponse = null;
		try {
				UserEntity userEntity = new UserEntity();
				userEntity.setLoginId(user.getLoginId());
				userEntity.setPassword(user.getPassword());
				userEntity.setCompany(user.getCompany());
				userEntity.setContact(user.getContact());
				userEntity.setFirstName(user.getFirst_name());
				userEntity.setLastName(user.getLast_name());
				userEntity.setCreatedDate(LocalDateTime.now());
				user_repo.save(userEntity);
				genericResponse = new GenericResponse(true, "user added", 200, user);
		}
		catch (Exception e) {
			e.printStackTrace();
			genericResponse = new GenericResponse(false, e.getMessage(), 400, user);
		}
		return genericResponse;
	}

}
