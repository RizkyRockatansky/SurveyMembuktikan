package app.skripsi.aspinkepumas.model.login;

import com.google.gson.annotations.SerializedName;

public class DataLogin {

	@SerializedName("nim")
	private String nim;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_pengguna")
	private String id_pengguna;

	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setId(String id){
		this.id_pengguna = id_pengguna;
	}

	public String getId(){
		return id_pengguna;
	}
}