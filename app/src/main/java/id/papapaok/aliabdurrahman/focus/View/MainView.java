package id.papapaok.aliabdurrahman.focus.View;

import java.util.List;

import id.papapaok.aliabdurrahman.focus.Base.BaseView;
import id.papapaok.aliabdurrahman.focus.Model.ArticlesItem;

/**
 * Created by AliAbdurrahman on 11/5/18.
 */

public interface MainView extends BaseView {

    void onError(String msg);
    void onSucces(List<ArticlesItem> data);

}
