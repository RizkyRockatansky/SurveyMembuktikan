package app.skripsi.aspinkepumas.ui.historykuesioner;

import java.util.List;

import androidx.annotation.NonNull;
import app.skripsi.aspinkepumas.adapter.HistoryView;
import app.skripsi.aspinkepumas.api.ApiClient;
import app.skripsi.aspinkepumas.api.ApiInterface;
import app.skripsi.aspinkepumas.model.histori.HistoriData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryPresenter {

    private HistoryView view;

    public HistoryPresenter(HistoryView view) {
        this.view = view;
    }

    public void getHistori(String id_mhs) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<HistoriData>> call = apiInterface.HistoriResponse(id_mhs);
        call.enqueue(new Callback<List<HistoriData>>() {
            @Override
            public void onResponse(@NonNull Call<List<HistoriData>> call, @NonNull Response<List<HistoriData>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<HistoriData>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
