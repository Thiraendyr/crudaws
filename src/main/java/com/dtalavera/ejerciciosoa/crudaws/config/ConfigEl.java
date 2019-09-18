package com.dtalavera.ejerciciosoa.crudaws.config;

import java.util.ResourceBundle;

public class ConfigEl {
    private static final ResourceBundle PROPERTIES = ResourceBundle.getBundle("eloqua");

    public static String getUrl(){
        return PROPERTIES.getString("url");
    }

    public static String getUsr(){
        return PROPERTIES.getString("usr");
    }

    public static String getPwd(){
        return PROPERTIES.getString("pwd");
    }

    public static String getEndpt(){
        return PROPERTIES.getString("endptCnt");
    }

    public static String getQuery(){
        return PROPERTIES.getString("q");
    }

}
