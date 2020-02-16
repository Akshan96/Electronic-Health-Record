package com.ehr.service;

import com.ehr.model.LoginHistory;
import com.ehr.repository.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginHistoryService {

	private LoginHistoryRepository loginHistoryRepository;

	@Autowired
	public LoginHistoryService(LoginHistoryRepository loginHistoryRepository) {
		this.loginHistoryRepository = loginHistoryRepository;
	}

	public void saveLoginHistory(LoginHistory loginHistory) {
		loginHistoryRepository.save(loginHistory);
	}

}
