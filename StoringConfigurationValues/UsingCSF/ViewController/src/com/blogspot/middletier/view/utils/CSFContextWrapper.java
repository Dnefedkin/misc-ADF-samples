package com.blogspot.middletier.view.utils;

import java.util.Map;

public class CSFContextWrapper {
    public CSFContextWrapper() {
        super();
    }
    
    public String getGenericSettingAsString(String credMap, String credKey) throws CSFException {
        Object res =  CSFContext.getInstance().getGenericSetting(credMap, credKey);
        return res.toString();
    }
    
    public Map<String, Object> getGenericSettingAsMap (String credMap, String credKey) throws CSFException {
        Object res =  CSFContext.getInstance().getGenericSetting(credMap, credKey);
        return  (Map<String, Object>)res;
    }

        
        
}

