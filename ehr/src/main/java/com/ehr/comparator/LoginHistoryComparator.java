package com.ehr.comparator;

import java.util.Comparator;

import com.ehr.model.LoginHistory;

/**
 * @author Priyank Gajera
 *
 */
public class LoginHistoryComparator implements Comparator<LoginHistory> {

	@Override
	public int compare(LoginHistory o1, LoginHistory o2) {
		return o1.getLoginTime().compareTo(o2.getLoginTime());
	}
}
