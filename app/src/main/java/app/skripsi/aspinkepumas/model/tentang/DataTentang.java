package app.skripsi.aspinkepumas.model.tentang;

import com.google.gson.annotations.SerializedName;

public class DataTentang {


    @SerializedName("id_tentang")
    private String id_tentang;

//
//    @SerializedName("judul")
//    private String judul;

    @SerializedName("deskripsi")
    private String deskripsi;


    public String getId_tentang() {
        return id_tentang;
    }

//    public String getJudul() {
//        return judul;
//    }

    public String getDeskripsi() {
        return deskripsi;
    }

    @Override
    public String toString() {
        return "DataTentang{" +
                "id_tentang='" + id_tentang + '\'' +
//                ", judul='" + judul + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                '}';
    }

}
