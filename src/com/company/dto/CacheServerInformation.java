package com.company.dto;

import java.util.ArrayList;

public class CacheServerInformation {
    private int serverId;
    private ArrayList<VideoInformation> videos;

    public CacheServerInformation(int serverId, ArrayList<VideoInformation> videos) {
        this.serverId = serverId;
        this.videos = videos;
    }

    public int getServerId() {
        return serverId;
    }

    public ArrayList<VideoInformation> getVideos() {
        return videos;
    }
}
