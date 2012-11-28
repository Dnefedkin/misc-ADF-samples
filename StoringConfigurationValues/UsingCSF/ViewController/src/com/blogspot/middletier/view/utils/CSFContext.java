package com.blogspot.middletier.view.utils;

import java.util.HashMap;
import java.util.Map;

import javatests.Foo;

import oracle.security.jps.JpsException;
import oracle.security.jps.service.JpsServiceLocator;
import oracle.security.jps.service.credstore.Credential;
import oracle.security.jps.service.credstore.CredentialStore;
import oracle.security.jps.service.credstore.GenericCredential;
import oracle.security.jps.service.credstore.PasswordCredential;

public class CSFContext {
    private static CSFContext singleInstance;
    private CredentialStore store;
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";
                  
    
    private CSFContext() throws CSFException {
        try {
            store = JpsServiceLocator.getServiceLocator().lookup(CredentialStore.class);
        } catch (JpsException  ex) {
            throw new CSFException(ex);
        }
    }
    
    public static CSFContext getInstance() throws CSFException{
        if (singleInstance == null) {
            singleInstance = new CSFContext();
        }
        return singleInstance;
    }
    
    private Credential getCredential(String credMap, String credKey) throws CSFException {
        try {
            Credential cred = store.getCredential(credMap, credKey);      
            return cred;
        } catch(Exception ex) {
            throw new CSFException(ex);
        }
    }
    
    public Object getGenericSetting(String credMap, String credKey) throws CSFException {
        Credential cred = getCredential(credMap, credKey);
        if (cred instanceof GenericCredential) {
            return ((GenericCredential)cred).getCredential();
        } else {
            throw new CSFException(credKey + " is not a generic setting");
        }
    }
    
    
    public Map<String, String> getPasswordSetting(String credMap, String credKey) throws CSFException {
        Credential cred = getCredential(credMap, credKey);
        if (cred instanceof PasswordCredential) {
            PasswordCredential pc =  (PasswordCredential)cred;
            Map<String, String> result = new HashMap<String, String>();
            result.put(USERNAME, pc.getName());
            result.put(PASSWORD, new String(pc.getPassword())); 
            return result;
        } else {
            throw new CSFException(credKey + " is not a password setting");
        }
    }
    
         
         
    
}
