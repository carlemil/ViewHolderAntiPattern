package se.kjellstrand.viewholderantipattern;

import android.app.Application;

/**
 * Created by Carl-Emil Kjellstrand on 10/25/13.
 */
public class DemoApplication extends Application {
   
    private static DemoApplication sInstance;

    public static DemoApplication get() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

	}
}
