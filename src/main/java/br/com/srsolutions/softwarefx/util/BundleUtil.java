package br.com.srsolutions.softwarefx.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleUtil {
  
  private static final String bundlePath = "bundles/messages";
  private static final Locale locale = Locale.getDefault();
  private static ResourceBundle instance;
  
  private BundleUtil() {
  }
  
  public static ResourceBundle getBundle() {
    if( instance == null ){
      instance = ResourceBundle.getBundle(bundlePath, locale);
    }
    return instance;
  }
  
  public static String getString(String key){
    if( instance == null ){
      instance = ResourceBundle.getBundle(bundlePath, locale);
    }
    return instance.getString(key);
  }
}
