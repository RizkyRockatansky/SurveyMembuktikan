package app.skripsi.aspinkepumas.model.pertanyaan;

import com.google.gson.annotations.SerializedName;

public class DataPertanyaan {

    @SerializedName("id_kuis")
    private String id_kuis;


    @SerializedName("pertanyaan")
    private String pertanyaan;

    @SerializedName("id_kategori")
    private String id_kategori;

    @SerializedName("nama_kategori")
    private String nama_kategori;

    @SerializedName("kode_kuis")
    private String kode_kuis;

    public String getId_pertanyaan() {
        return id_kuis;
    }

    public String getNama_pertanyaan() {
        return pertanyaan;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public String getKodeKuis() {
        return kode_kuis;
    }

    @Override
    public String toString() {
        return "DataPertanyaan{" +
                "id_kuis='" + id_kuis + '\'' +
                ", pertanyaan='" + pertanyaan + '\'' +
                ", id_kategori='" + id_kategori + '\'' +
                ", nama_kategori='" + nama_kategori + '\'' +
                ", kode_kuis='" + kode_kuis + '\'' +

                '}';
    }



}
