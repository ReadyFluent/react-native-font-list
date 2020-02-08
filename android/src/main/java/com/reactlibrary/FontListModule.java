package com.reactlibrary;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeArray;

import java.io.File;

public class FontListModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public FontListModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "FontList";
    }

    @ReactMethod
    public void get(Callback callback) {
        String path = "/system/fonts";
        File file = new File(path);
        File[] fontFiles = file.listFiles();

        WritableNativeArray fontFamilyNames = new WritableNativeArray();
        fontFamilyNames.pushString("casual");
        fontFamilyNames.pushString("cursive");
        fontFamilyNames.pushString("monospace");
        fontFamilyNames.pushString("sans-serif");
        fontFamilyNames.pushString("sans-serif-black");
        fontFamilyNames.pushString("sans-serif-condensed");
        fontFamilyNames.pushString("sans-serif-condensed-light");
        fontFamilyNames.pushString("sans-serif-light");
        fontFamilyNames.pushString("sans-serif-medium");
        fontFamilyNames.pushString("sans-serif-smallcaps");
        fontFamilyNames.pushString("sans-serif-thin");
        fontFamilyNames.pushString("serif");
        fontFamilyNames.pushString("serif-monospace");

        WritableNativeArray fontNames = new WritableNativeArray();

        for (File fontFile : fontFiles) {
            fontNames.pushString(fontFile.getName());
        }

        callback.invoke(fontFamilyNames, fontNames);
    }
}
