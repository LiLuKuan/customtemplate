package com.cmh.common;

import java.sql.Timestamp;

public class RspBody {
    private Boolean success;
    private long timestamp;
    private Object data;
    
    public RspBody(Boolean success, Object data) {
		Timestamp sqlTimestamp = new Timestamp(System.currentTimeMillis());
		Long getTimes = sqlTimestamp.getTime();
        this.success = success;
        this.data = data;
        this.timestamp = getTimes;
    }

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
