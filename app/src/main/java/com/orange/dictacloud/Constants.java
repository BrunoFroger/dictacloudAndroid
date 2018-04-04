package com.orange.dictacloud;

/**
 * Created by obfe6300 on 21/02/2018.
 */

public class Constants {


    // ACCESS SERVER VALUES
    public final static String ACCESS_TYPE_INTERNAL = "Internal";
    public final static String ACCESS_TYPE_EXTERNAL = "External";
    public final static String INTERNAL_SERVER = "srvweb";
    public final static String EXTERNAL_SERVER = "livebox-3840.dtdns.net:8001";
    public final static String INTERNAL_PHOTO_SERVER = "http://" + INTERNAL_SERVER + "/dictacloud/";
    public final static String EXTERNAL_PHOTO_SERVER = "http://" + EXTERNAL_SERVER + "/dictacloud/";
    public final static String INTERNAL_AUDIO_SERVER = "http://" + INTERNAL_SERVER + "/dictacloud/";
    public final static String EXTERNAL_AUDIO_SERVER = "http://" + EXTERNAL_SERVER + "/dictacloud/";
    public final static String INTERNAL_VIDEO_SERVER = "http://" + INTERNAL_SERVER + "/dictacloud/videoRecord/";
    public final static String EXTERNAL_VIDEO_SERVER = "http://" + EXTERNAL_SERVER + "/dictacloud/videoRecord/";

    // TREATMENT TYPE
    public final static String TREATMENT_MAIL = "treatmentMail";
    public final static String TREATMENT_STORE = "treatmentStore";
    public final static String TREATMENT_CLOUD = "treatmentCloud";

    // MEDIA TYPE VALUES
    public final static String MEDIA_PHOTO = "photo";
    public final static String MEDIA_VIDEO = "video";
    public final static String MEDIA_AUDIO = "audio";

    // Preferences keys
    public final static String INITIALIZED = "Initialized";
    public final static String ACCESS_TYPE = "accesType";
    public final static String TREATMENT_TYPE = "treatmentType";
    public final static String PSEUDO = "Pseudo";
    public final static String EMAIL = "Email";
    public final static String ACCESS_PHOTO_SERVER = "AccessPhotoServer";
    public final static String ACCESS_AUDIO_SERVER = "AccessAudioServer";
    public final static String ACCESS_VIDEO_SERVER = "AccessVideoServer";
    public final static String MEDIA_TYPE = "MediaType";
    public final static String LOGIN_DATE = "LoginDate";
    public final static String TAUX_COMPRESSION = "CrompressionRate";

    // constantes
    public final static int TAUX_COMPRESSION_DEFAULT = 10;

    // Requetes vers serveur
    public final static String SUBSCRIBE = "subsribe";
    public final static String UNSUBSCRIBE = "unsubsribe";
    public final static String REGISTER = "register";
    public final static String UNREGISTER = "unregister";
    public final static String LISTE = "liste";
    public final static String SENDFILEBYEMAIL = "SendFileByEmail";
    public final static String REMOVEFILEONSERVER = "RemoveFileOnServer";

}
