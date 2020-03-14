package com.cht.springboot_mybaties.influxdb;

import org.influxdb.InfluxDB;

public class InfluxDBConnection {
	private String userName;    //用户名
	private String password;    //密码
	private String openUrl;     //连接地址
	private String influxDbName;
	private String retentionPolicy; // 默认为autogen，保留策略
	private InfluxDB influxDB;

	public InfluxDBConnection(String userName, String password, String openUrl, String influxDbName,
			String retentionPolicy) {
		super();
		this.userName = userName;
		this.password = password;
		this.openUrl = openUrl;
		this.influxDbName = influxDbName;
		this.retentionPolicy = retentionPolicy==null?"autogen":retentionPolicy;
		createInfluxDbBuilder();
	}

	private void createInfluxDbBuilder() {
         if(influxDB==null) {		
        	 
         }
	}

}
