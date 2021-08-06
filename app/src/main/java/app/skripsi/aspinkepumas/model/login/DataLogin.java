package app.skripsi.aspinkepumas.model.login;

import com.google.gson.annotations.SerializedName;

public class DataLogin {

	@SerializedName("nim")
	private String nim;

	@SerializedName("password")
	private String password;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_mahasiswa")
	private String id_mahasiswa;

	@SerializedName("email")
	private String email;

	@SerializedName("role")
	private int  role;

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

	public void setId(String id){
		this.id_mahasiswa = id_mahasiswa;
	}


	public String getId(){
		return id_mahasiswa;
	}

	public void setEmai(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}


	public void setRole(int role){
		this.role = role;
	}

	public int getRole(){
		return role;
	}

//	public void doLogin(String nim,  String password, int status){
//		this.setNim(nim);
//		this.setRole(status);
//		this.setPassword(password);
////		this.setId(id);
//	}
}