package app.skripsi.aspinkepumas.adapter;

import java.util.List;

import app.skripsi.aspinkepumas.model.histori.HistoriData;

public interface HistoryView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<HistoriData> historiDatas);
    void onErrorLoading(String message);}
