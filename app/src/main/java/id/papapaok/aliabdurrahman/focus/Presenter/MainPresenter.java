package id.papapaok.aliabdurrahman.focus.Presenter;

import java.util.List;

import id.papapaok.aliabdurrahman.focus.Base.BasePresenter;
import id.papapaok.aliabdurrahman.focus.Model.ArticlesItem;
import id.papapaok.aliabdurrahman.focus.Model.ResponseGetFocus;
import id.papapaok.aliabdurrahman.focus.Network.ConfigRetrofit;
import id.papapaok.aliabdurrahman.focus.View.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AliAbdurrahman on 11/5/18.
 */

public class MainPresenter implements BasePresenter<MainView> {

    MainView mainView;
    private String key = "4625d046da30459a80a62d89415b77be";
    private String sources = "focus";

    public void getData() {
        call().enqueue(new Callback<ResponseGetFocus>() {
            @Override
            public void onResponse(Call<ResponseGetFocus> call, Response<ResponseGetFocus> response) {
                if (response.isSuccessful()) {
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSucces(articlesItems);
                } else {
                    mainView.onError(response.body().getStatus());
                }
            }

            @Override
            public void onFailure(Call<ResponseGetFocus> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    private Call<ResponseGetFocus> call() {
        return ConfigRetrofit.getInstance().getFocusData(sources, key);
    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDettach() {
        mainView = null;
    }
}
