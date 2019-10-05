package com.rnmmpowermanager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;

public class MultiManufacturerPowerManagerModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public MultiManufacturerPowerManagerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "MultiManufacturerPowerManager";
    }

    private static final Intent[] POWERMANAGER_INTENTS = {
      new Intent().setComponent(
          new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")),
      new Intent().setComponent(
          new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")),
      new Intent().setComponent(
          new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")),
      new Intent().setComponent(new ComponentName("com.coloros.safecenter",
          "com.coloros.safecenter.permission.startup.StartupAppListActivity")),
      new Intent().setComponent(
          new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")),
      new Intent()
          .setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")),
      new Intent()
          .setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")),
      new Intent()
          .setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")),
      new Intent().setComponent(new ComponentName("com.vivo.permissionmanager",
          "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")),
      new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.MainActivity")) };

    @ReactMethod
    public void startIntent(String pkg, String cls) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(pkg, cls);
        intent.setComponent(componentName);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        reactContext.startActivity(intent);
    }

    @ReactMethod
    public void isHasProtectManager(final Promise promise) {
        for (Intent intent : POWERMANAGER_INTENTS)
        if (reactContext.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            WritableMap map = new WritableNativeMap();
            map.putString("package", intent.getComponent().getPackageName());
            map.putString("class", intent.getComponent().getClassName());
            promise.resolve(map);
            return;

        }
        promise.resolve(false);
    }
}
