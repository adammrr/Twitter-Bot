package com.adamrobson.handlers;

public class WeatherHandler {

    private KeyHandler keyHandler;
    private DownloadHandler downloadHandler;

    private String url = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/xml/";
    private String query = "?res=3hourly&key=";

    public WeatherHandler(KeyHandler keyHandler){
        this.keyHandler = keyHandler;
        query += keyHandler.getMetOfficeKey();
        downloadHandler = new DownloadHandler();
    }

    public void updateLocationData(String locationId){
        downloadHandler.downloadFileFromURL(url + locationId + query,locationId + ".xml");
    }

}
