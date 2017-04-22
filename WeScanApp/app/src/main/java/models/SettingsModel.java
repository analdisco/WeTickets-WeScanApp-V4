package models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dmeij on 4/22/2017.
 */

public class SettingsModel {
    @SerializedName("weTicketsCode")
    String weTicketsCode = "";

    @SerializedName("language")
    String language = "en";

    @SerializedName("theme")
    String theme  = "dark";

    @SerializedName("allowLateTickets")
    boolean allowLateTickets = true;

    @SerializedName("allowNonExistingTickets")
    boolean allowNonExistingTickets = false;

    @SerializedName("isBarCodeScanner")
    boolean isBarCodeScanner = true;

    @SerializedName("enableAutoDim")
    boolean enableAutoDim = true;

    @SerializedName("autoDimTimeout")
    int autoDimTimeout = 10;

    @SerializedName("enableEntranceCheck")
    boolean enableEntranceCheck = true;

    @SerializedName("entrancesToCheck")
    String entrancesToCheck = "";

    @SerializedName("scanMode")
    String scanMode = "offline";

    @SerializedName("onlineEndpoint")
    String onlineEndpoint = "https://admin.wetickets.ws/wescantickets/";

    @SerializedName("localServerEndpoint")
    String localServerEndpoint = "192.168.1.1";

    @SerializedName("updateInterval")
    int updateInterval = 60;

    @SerializedName("reconnectInterval")
    int reconnectInterval = 10;

    @SerializedName("checkOnlineFirst")
    boolean scanCheckOnlineFirst = true;
}
