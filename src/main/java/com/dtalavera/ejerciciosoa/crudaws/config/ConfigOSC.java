package com.dtalavera.ejerciciosoa.crudaws.config;

import java.util.ResourceBundle;

public class ConfigOSC {

    private static final ResourceBundle PROPERTIES = ResourceBundle.getBundle("oracleSalesCloud");

    public static String getUrl(){
        return PROPERTIES.getString("url");
    }

    public static String getUsr(){
        return PROPERTIES.getString("usr");
    }

    public static String getPwd(){
        return PROPERTIES.getString("pwd");
    }

    public static String getEndptCnt(){
        return PROPERTIES.getString("endptCnt");
    }

    public static String getEndptLead(){
        return PROPERTIES.getString("endptLead");
    }

    public static String getQueryCnt(){
        return PROPERTIES.getString("qCnt");
    }

    public static String getQueryLead(){
        return PROPERTIES.getString("qLead");
    }

}
