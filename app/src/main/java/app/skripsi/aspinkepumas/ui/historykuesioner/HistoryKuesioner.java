package app.skripsi.aspinkepumas.ui.historykuesioner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.adapter.AdapterHistori;
import app.skripsi.aspinkepumas.adapter.HistoryView;
import app.skripsi.aspinkepumas.api.ApiClient;
import app.skripsi.aspinkepumas.api.ApiInterface;
import app.skripsi.aspinkepumas.model.histori.HistoriData;
import app.skripsi.aspinkepumas.model.tentang.DataTentang;
import app.skripsi.aspinkepumas.session.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryKuesioner extends AppCompatActivity implements HistoryView {
    ApiInterface apiInterface;
    SessionManager sessionManager;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    HistoryPresenter presenter;
    AdapterHistori adapter;
    String id_mhs;

    List<HistoriData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_kuesioner);


        recyclerView = findViewById(R.id.rcv_historii);
        swipeRefresh = findViewById(R.id.swipe_histori);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


        sessionManager = new SessionManager(HistoryKuesioner.this);
        id_mhs = sessionManager.getUserDetail().get(SessionManager.ID);

        presenter = new HistoryPresenter(this);
        presenter.getHistori(id_mhs);



        swipeRefresh.setOnRefreshListener(
                () -> presenter.getHistori(id_mhs)
        );

    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<HistoriData> historiDatas) {
        adapter = new AdapterHistori(this, historiDatas);
        adapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        data = historiDatas;
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}