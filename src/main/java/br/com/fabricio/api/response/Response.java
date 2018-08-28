package br.com.fabricio.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	private T data;
	private List<String> lsErros;
	
	public Response() {
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<String> getLsErros() {
		if(this.lsErros == null) {
			this.lsErros = new ArrayList<>();
		}
		return lsErros;
	}
	public void setLsErros(List<String> lsErros) {
		this.lsErros = lsErros;
	}
	
	

}
