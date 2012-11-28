package com.blogspot.middletier.view.utils;

import java.util.*;


public class CSFContextWrapper {
    public CSFContextWrapper() {
        super();
    }
    
    public String getGenericSettingAsString(String credMap, String credKey) throws CSFException {
        Object res =  CSFContext.getInstance().getGenericSetting(credMap, credKey);
        return res.toString();
    }
    

    
    public List<Pair> getGenericSettingAsMap (String credMap, String credKey) throws CSFException {
        List<Pair> result = new ArrayList<Pair>();
        Object callRes=  CSFContext.getInstance().getGenericSetting(credMap, credKey);
        Map<String, Object> settings =  (Map<String, Object>)callRes;              
        for (Map.Entry<String, Object> setting: settings.entrySet()) {
            // returned value is char[], so combining the string from this char array
            result.add(new Pair(setting.getKey(), new String((char[])setting.getValue()) ));
        }
        return  result;
    }
    
    public List<Pair> getPasswordSetting(String credMap, String credKey) throws CSFException {
        List<Pair> result = new ArrayList<Pair>();
        Map<String, String> passSettings = CSFContext.getInstance().getPasswordSetting(credMap, credKey);
        for (Map.Entry<String,String> setting: passSettings.entrySet()) {
            result.add(new Pair(setting.getKey(), setting.getValue()));
        }
        return result;
    }

        
        
}

