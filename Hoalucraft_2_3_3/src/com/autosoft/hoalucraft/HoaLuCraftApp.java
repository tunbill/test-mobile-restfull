package com.autosoft.hoalucraft;

import java.util.Locale;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public class HoaLuCraftApp extends Application {
	public static final String		LANG_EN			= "en";
	public static final String		LANG_VI			= "vi";

	public static final String		EN_CURRENCY		= "$";
	public static final String		VI_CURRENCY		= "VND";

	private static HoaLuCraftApp	instance;
	private String					language;

	// public static final String ROOT_SERVICES =
	// "http://10.0.2.2/hoalucraft/service";
	// public static final String ROOT_IMAGES =
	// "http://10.0.2.2/hoalucraft/img/images";

	public static final String		ROOT_SERVICES	= "http://192.168.1.128/hoalucraft/service";
	public static final String		ROOT_IMAGES		= "http://192.168.1.128/hoalucraft/img/images";

	// public static final String ROOT_SERVICES =
	// "http://hoalucraft.esy.es/service";
	// public static final String ROOT_IMAGES =
	// "http://hoalucraft.esy.es/img/images";

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		language = LANG_EN;
	}

	public static HoaLuCraftApp getInstance() {
		return instance;
	}

	public static Context getContext() {
		return instance.getApplicationContext();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		if (language != null && language.equalsIgnoreCase(LANG_VI)) {
			this.language = LANG_VI;
		} else {
			this.language = LANG_EN;
		}
	}

	public static void configLanguageAndLocate(Activity activity) {

		Configuration configuration = new Configuration();
		Locale locale = new Locale(HoaLuCraftApp.getInstance().language);
		if (locale != null && configuration != null) {
			configuration.locale = locale;
			activity.getBaseContext().getResources().updateConfiguration(configuration, activity.getBaseContext().getResources().getDisplayMetrics());

			// Intent refresh = new Intent(view.getActivity(),
			// MainActivity.class);
			// view.getActivity().startActivity(refresh);
		}
	}
}
