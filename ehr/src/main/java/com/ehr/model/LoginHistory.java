package com.ehr.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "login_history")
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_history_id")
    private int loginHistoryId;
    @Column(name = "login_ip")
    private String loginIP;
    @Column(name = "user_agent")
    private String userAgent;
    @Column(name = "login_time")
    private Date loginTime;
    
    public int getLoginHistoryId() {
		return loginHistoryId;
	}

	public void setLoginHistoryId(int loginHistoryId) {
		this.loginHistoryId = loginHistoryId;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;
    
    //public LoginHistory() {}
    
    public LoginHistory(Date loginTime, String loginIP, String userAgent) {
    	this.loginTime= loginTime;
    	this.loginIP= loginIP;
    	this.userAgent= userAgent;
    }

    
    
}
