package app.easylink.retrofit_api_marvel.dagger;

import android.app.Application;

import app.easylink.retrofit_api_marvel.dagger.module.ApiModule;
import app.easylink.retrofit_api_marvel.dagger.module.AppModule;
import app.easylink.retrofit_api_marvel.util.Constants;

// this class will build the API components
public class MyApplication extends Application {
    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerApiComponent.builder().appModule(new AppModule(this))
                .apiModule(new ApiModule(Constants.url)).build();
    }
    public ApiComponent getNetComponent() {
        return apiComponent;
    }
}
