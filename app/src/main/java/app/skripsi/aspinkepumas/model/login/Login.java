package app.skripsi.aspinkepumas.model.login;

import com.google.gson.annotations.SerializedName;

public class Login {

	@SerializedName("data")
	private DataLogin dataLogin;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDataLogin(DataLogin dataLogin){
		this.dataLogin = dataLogin;
	}

	public DataLogin getDataLogin(){
		return dataLogin;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}