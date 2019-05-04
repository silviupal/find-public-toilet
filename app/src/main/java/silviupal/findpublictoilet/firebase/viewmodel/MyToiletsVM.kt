package silviupal.findpublictoilet.firebase.viewmodel

import androidx.lifecycle.ViewModel
import silviupal.findpublictoilet.firebase.ToiletModel

/**
 * Created by Silviu Pal on 4/30/2019.
 */
class MyToiletsVM : ViewModel() {

    var toilets: List<ToiletModel>? = null

    https: //medium.com/globallogic-latinoamerica-mobile/viewmodel-firebase-database-3cc708044b5d

    /*private MutableLiveData<List<Article>> articles;
    public LiveData<List<Article>> getArticles() {
        if (articles == null) {
            articles = new MutableLiveData<List<Article>>();
            loadArticles();
        }
        return articles;
    }

    private void loadArticles() {
        // do async operation to fetch articles
    }*/

}