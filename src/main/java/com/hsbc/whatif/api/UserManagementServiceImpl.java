package com.hsbc.whatif.api.usermanagement.impl;

import com.hsbc.whatif.api.*;
import com.hsbc.whatif.api.usermanagement.*;
import com.hsbc.whatif.dao.*;
import com.hsbc.whatif.entities.*;
import com.hsbc.whatif.user.entity.*;
import java.util.*;

public class UserManagementServiceImpl implements UserManagementService {
	
	private UserDao userDao;
	private String id;
	
	public UserManagementServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserSessionResponse initUserSession() throws Exception {
		UserSessionResponse response = new UserSessionResponse();
		UserSession userSession = new UserSession();
		// String userId = request.getAddAccountId();
		List<String> siteList = new ArrayList<String>();
		// if(request != null) {
		// 	User user = userDao.findByName(userId);
		// 	if(user != null) {
		// 		userSession.setSite(user.getSite());
		// 		userSession.setUserId(user.getUserId().toString());
		// 		userSession.setSystemDate(new String("10-05-2011"));
		// 		siteList.add(user.getSite());
		// 		response.setUserSession(userSession);
		// 		response.setSiteList(siteList);
		// 	}
		// }
		// else {
		// 	throw new NullPointerException();
		// }
		return response;
	}

	@Override
	public UserPreferenceResponse saveUserPreferences(UserPreferenceRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPreferenceResponse getDefaultUserPreferences(UserPreferenceRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserManagementResponse addUserAuthorizedSites(UserManagementRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserManagementResponse deleteUserAuthorizedSites(UserManagementRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public UserInfoByMonitoringSiteResponse getUserInfoByMonitoringSite(UserInfoByMonitoringSiteRequest request) {
		String monitoringSite = request.getMonitoringSite().trim();
		UserInfoByMonitoringSiteResponse response = new UserInfoByMonitoringSiteResponse();
		List<UserInfoEntity> userInfoList = new ArrayList<UserInfoEntity>();
		UserInfoEntity userInfoEntity = null;
		if(request != null) {
			List<User> listOfUser = userDao.findBySite(monitoringSite);
			if(listOfUser != null) {
				Iterator<User> it = listOfUser.iterator();
				while(it.hasNext()) {
					User user = it.next();
					userInfoEntity = new UserInfoEntity();
					userInfoEntity.setUserId(user.getUserName());
					userInfoEntity.setUserName(user.getUserName());
					userInfoList.add(userInfoEntity);
				}
				response.setUserInfoList(userInfoList);
			}
			else {
				response.setErrorData(getErrorData());
			}
		}
		else {
			throw new NullPointerException();
		}
		return response;
	}
	
	private ErrorData getErrorData() {
		ErrorData errorData = new ErrorData();
		errorData.setErrorCode(ErrorConstantCode.ERROR_CODE_DEAL_013);
		errorData.setErrorMessage(ErrorConstantCode.ERROR_MSG_DEAL_013);
		return errorData;
	}
}