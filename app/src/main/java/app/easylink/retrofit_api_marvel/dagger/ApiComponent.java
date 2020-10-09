package app.easylink.retrofit_api_marvel.dagger;

import javax.inject.Singleton;

import app.easylink.retrofit_api_marvel.MainActivity;
import app.easylink.retrofit_api_marvel.dagger.module.ApiModule;
import app.easylink.retrofit_api_marvel.dagger.module.AppModule;
import dagger.Component;

@Singleton
@Component (modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {

void inject(MainActivity mainActivity);

}
