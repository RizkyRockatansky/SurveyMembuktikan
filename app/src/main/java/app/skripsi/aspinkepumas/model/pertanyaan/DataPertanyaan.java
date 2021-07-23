package app.skripsi.aspinkepumas.model.pertanyaan;

import com.google.gson.annotations.SerializedName;

public class DataPertanyaan {

    @SerializedName("id_pertanyaan")
    private String id_pertanyaan;


    @SerializedName("nama_pertanyaan")
    private String nama_pertanyaan;

    @SerializedName("id_kategori")
    private String id_kategori;

    @SerializedName("nama_kategori")
    private String nama_kategori;


    public String getId_pertanyaan() {
        return id_pertanyaan;
    }

    public String getNama_pertanyaan() {
        return nama_pertanyaan;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    @Override
    public String toString() {
        return "DataPertanyaan{" +
                "id_pertanyaan='" + id_pertanyaan + '\'' +
                ", nama_pertanyaan='" + nama_pertanyaan + '\'' +
                ", id_kategori='" + id_kategori + '\'' +
                ", nama_kategori='" + nama_kategori + '\'' +
                '}';
    }



}
