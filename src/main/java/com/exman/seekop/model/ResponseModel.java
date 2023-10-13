package com.exman.seekop.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseModel<T> {
	private String statuscode;
	private String statusmessage;
	private String timestamp;
	private Integer status;
	private T resultset;

	public ResponseModel(String statuscode, String statusmessage, Integer status, String timestamp, T resultset) {
		super();
		this.statuscode = statuscode;
		this.statusmessage = statusmessage;
		this.status = status;
		this.timestamp = timestamp;
		this.resultset = resultset;
	}
}
