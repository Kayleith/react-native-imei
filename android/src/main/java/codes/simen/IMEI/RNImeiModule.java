package codes.simen.IMEI;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.HashMap;
import java.util.Map;

public class RNImeiModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;

    public RNImeiModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "IMEI";
    }

    @Override
    public String getImei() {
        TelephonyManager tm = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tm.getDeviceId();

        if (imei.isEmpty()) {
            throw new RuntimeException("Failed to read IMEI (imei is empty!)");
        }
        
        return imei;
    }

}
