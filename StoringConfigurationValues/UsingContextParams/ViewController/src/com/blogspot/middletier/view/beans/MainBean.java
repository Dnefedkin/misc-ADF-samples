package com.blogspot.middletier.view.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.ServletContext;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

public class MainBean {
    private RichPanelGroupLayout panel;

    public MainBean() {
    }


    
    public void onClick(ActionEvent actionEvent) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) fctx.getExternalContext().getContext();
        String myIntParam = servletContext.getInitParameter("myIntParam");
        try {
            int val = Integer.decode(myIntParam);
            fctx.addMessage(panel.getClientId(fctx), 
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Integer value", "myIntParam context parameter = "+val));            
        } catch(NumberFormatException ex) {
            fctx.addMessage(panel.getClientId(fctx), 
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Non-integer value", "myIntParam = "+myIntParam+". Please enter Integer value for myIntParam context parameter!"));
        }
    }

    public void setPanel(RichPanelGroupLayout panel) {
        this.panel = panel;
    }

    public RichPanelGroupLayout getPanel() {
        return panel;
    }
}
