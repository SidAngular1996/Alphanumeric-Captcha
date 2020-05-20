package com.icegate.IceGate.vo;

import java.util.List;
import java.util.stream.Collectors;
import com.icegate.IceGate.entity.UserEntity;

public class Mapper {

	//Used newer approach instead
//	public static UserVO mapUserEntityToVO(UserEntity userEntity) {
//		UserVO userVo = new UserVO();
//		userVo.setUserId(userEntity.getId());
//		userVo.setFirst_name(userEntity.getFirstName());
//		userVo.setCompany(userEntity.getCompany());
//		userVo.setContact(userEntity.getContact());
//		userVo.setCountry(userEntity.getCountry().getCountryName());
//		userVo.setLast_name(userEntity.getLastName());
//		userVo.setLoginId(userEntity.getLoginId());
//		userVo.setCity(userEntity.getCity().getCityName());
//		userVo.setUpdatedDate(userEntity.getUpdatedDate());
//		userVo.setCreatedDate(userEntity.getCreatedDate());
//		return userVo;
//	}
	
	public static List<UserVO> mapListEntityToList_vo(List<UserEntity> list){
		return list.stream().map(UserVO :: new).collect(Collectors.toList());
	}
}
