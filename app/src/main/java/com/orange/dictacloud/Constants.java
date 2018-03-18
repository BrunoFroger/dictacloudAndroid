package com.orange.dictacloud;

/**
 * Created by obfe6300 on 21/02/2018.
 */

public class Constants {

    // ACCESS SERVER VALUES
    public final static String INTERNAL_SERVER ="http://srvweb/dictacloud/";
    public final static String EXTERNAL_SERVER ="http://livebox-3840.dtdns.net:8001/dictacloud/";

    // MEDIA TYPE VALUES
    public final static String MEDIA_PHOTO = "photo";
    public final static String MEDIA_VIDEO = "video";
    public final static String MEDIA_AUDIO = "audio";

    // Preferences keys
    public final static String PSEUDO = "Pseudo";
    public final static String EMAIL = "Email";
    public final static String ACCESS_SERVER = "AccessServer";
    public final static String MEDIA_TYPE = "MediaType";
    public final static String LOGIN_DATE = "LoginDate";
    public final static String TAUX_COMPRESSION = "CrompressionRate";

    // constantes
    public final static int TAUX_COMPRESSION_DEFAULT = 10;

    // Requetes vers serveur
    public final static String SUBSCRIBE="subsribe";
    public final static String UNSUBSCRIBE="unsubsribe";
    public final static String REGISTER="register";
    public final static String UNREGISTER="unregister";

}
