package app.skripsi.aspinkepumas.model.login;

import com.google.gson.annotations.SerializedName;

public class DataLogin {

	@SerializedName("nim")
	private String nim;

	@SerializedName("password")
	private String password;

	@SerializedName("nama_mhs")
	private String nama;

	@SerializedName("id_mhs")
	private String idmahasiswa;

	@SerializedName("email")
	private String email;



	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}


	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setId(String idmahasiswa){
		this.idmahasiswa = idmahasiswa;
	}


	public String getId(){
		return idmahasiswa;
	}

	public void setEmai(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}




//	public void doLogin(String nim,  String password, int status){
//		this.setNim(nim);
//		this.setRole(status);
//		this.setPassword(password);
////		this.setId(id);
//	}
}