package app.easylink.retrofit_api_marvel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import app.easylink.retrofit_api_marvel.dagger.MyApplication;
import app.easylink.retrofit_api_marvel.model.Marvel;
import app.easylink.retrofit_api_marvel.network.ClientApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Inject
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.list1);
        ((MyApplication) getApplication()).getNetComponent().inject(this);

        ClientApi clientApi = retrofit.create(ClientApi.class);
        Call<List<Marvel>> mValue =clientApi.getHeroes();


        mValue.enqueue(new Callback<List<Marvel>>() {
            @Override
            public void onResponse(Call<List<Marvel>> call, Response<List<Marvel>> response) {
                Toast.makeText(getApplicationContext(), response.body().get(0).getBio(),Toast.LENGTH_LONG).show();
                List<Marvel> mylist2 = response.body();
                String[] s = new String[mylist2.size()];
                for(int i = 0; i<mylist2.size(); i++){
                    s[i] = mylist2.get(i).getBio();
                }
               // listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android));
                //displaying the string array into listview
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, s));

            }

            @Override
            public void onFailure(Call<List<Marvel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fail",Toast.LENGTH_LONG).show();
            }
        });


    }
}