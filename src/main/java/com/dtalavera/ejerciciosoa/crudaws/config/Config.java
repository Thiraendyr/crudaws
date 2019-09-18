package com.dtalavera.ejerciciosoa.crudaws.config;

import java.util.ResourceBundle;

//Clase que contiene las urls y autentificaciones almacenadas en el properties
public class Config {
	private static final ResourceBundle PROPERTIES = ResourceBundle.getBundle("application");

    public static String getComilla(){
        return PROPERTIES.getString("comilla");
    }

    public static String getSlash(){
        return PROPERTIES.getString("slash");
    }

    public static String getPuntos(){
        return PROPERTIES.getString("dos_puntos");
    }

    public static String getBasic(){
        return PROPERTIES.getString("basic");
    }

    public static String getAccept(){
        return PROPERTIES.getString("accept");
    }

    public static String getApplicationJson(){
        return PROPERTIES.getString("json");
    }

    public static String getContent(){
        return PROPERTIES.getString("content_type");
    }

}
