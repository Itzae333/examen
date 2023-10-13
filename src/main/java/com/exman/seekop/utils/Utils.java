package com.exman.seekop.utils;

import com.exman.seekop.model.ResponseModel;

public class Utils {

	public static <T> ResponseModel<T> arrmarModelResponseExitoso(SuccessMessage mensaje, T model) {
		return new ResponseModel<>("200",mensaje.getMessage() , 200, "timestamp", model);
	}

	public static <T> ResponseModel<T> arrmarModelResponseError(ErrorMessage mensaje) {
		return new ResponseModel<>("404", mensaje.getMessage(), 404, "timestamp", null);
	}
}
