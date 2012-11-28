package com.blogspot.middletier.view.beans;

import javax.faces.event.ActionEvent;
import com.blogspot.middletier.view.utils.*;

public class MainBean {
    private String keyMapName = "com.blogspot.middletier.usingCSF";
    
    public MainBean() {
    }

    public void doClick(ActionEvent actionEvent) {
        try {
            CSFContext ctx = CSFContext.getInstance(); 
            Object textSetting = ctx.getGenericSetting(keyMapName, "textSetting");
            System.out.println("textSetting = "+textSetting);
            
        } catch (CSFException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
}
