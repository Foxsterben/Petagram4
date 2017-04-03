package com.ss_baez.petagram4.restApi;

/**
 * Created by SS_Baez on 28/03/2017.
 */

public class ConstantesRestApi {


    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "4275789769.24bc04a.de1e77dbfa764d438359bf6d5dcfd2cd";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    public static final String KEY_GET_RECENT_MEDIA_USER1 = "users/4302183848/media/recent/";
    public static final String KEY_GET_RECENT_MEDIA_USER2 = "users/4230859422/media/recent/";
    public static final String KEY_GET_RECENT_MEDIA_USER3 = "users/428015863/media/recent/";

    public static final String URL_GET_RECENT_MEDIA_USER1 = KEY_GET_RECENT_MEDIA_USER1 + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_USER2 = KEY_GET_RECENT_MEDIA_USER2 + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_USER3 = KEY_GET_RECENT_MEDIA_USER3 + KEY_ACCESS_TOKEN + ACCESS_TOKEN;




}
