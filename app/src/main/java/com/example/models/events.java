package com.example.models;

public class events {
//
//    	Event Name
//	Event Time
//	Event Information
//	Event Venue
//	Extra Columns Implemented by you

    private int eventid;
    private String userId;
    private String eventName;
    private String eventTime;
    private String eventInfo;
    private String eventVenue;
    private String eventOrganiser;

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventOrganiser() {
        return eventOrganiser;
    }

    public void setEventOrganiser(String eventOrganiser) {
        this.eventOrganiser = eventOrganiser;
    }

    public events(int eventid, String userId, String eventName, String eventTime, String eventInfo, String eventVenue, String eventOrganiser) {
        this.eventid = eventid;
        this.userId = userId;
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventInfo = eventInfo;
        this.eventVenue = eventVenue;
        this.eventOrganiser = eventOrganiser;
    }
}
