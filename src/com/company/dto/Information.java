package com.company.dto;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Information {
    private int videosNumber;
    private int endpointsNumber;
    private int requestDescriptionsNumber;
    private int cacheServers;
    private int cacheServerCapacity;
    private ArrayList<VideoInformation> allVideos;

    public void setInfrastructureInformation(Object... params) {
        this.videosNumber = (Integer) params[0];
        this.endpointsNumber = (Integer) params[1];
        this.requestDescriptionsNumber = (Integer) params[2];
        this.cacheServers = (Integer) params[3];
        this.cacheServerCapacity = (Integer) params[4];
    }

    public void setVideosSizes(ArrayList<Integer> videoSizes){
        this.allVideos = new ArrayList<VideoInformation>();
        int numberOfVideos = videoSizes.size();
        for (int i = 0; i < numberOfVideos; i++){
            allVideos.add( new VideoInformation(i,videoSizes.get(i)));
        }
    }

    private CacheServerInformation[] getVideosByServer(){
        CacheServerInformation[] cacheServerInformation = new CacheServerInformation[cacheServers];
        ArrayList<VideoInformation> videoInformations;
        int accumulatedInformation;
        for(int i = 0; i < cacheServers; i++){
            videoInformations = new ArrayList<VideoInformation>();
            accumulatedInformation = 0;
            for(int j = 0; j < allVideos.size(); j++){
                if((accumulatedInformation + allVideos.get(j).getSize()) < cacheServerCapacity){
                    videoInformations.add(allVideos.get(j));
                    accumulatedInformation += allVideos.get(j).getSize();
                }
            }
            cacheServerInformation[i] = new CacheServerInformation(i,videoInformations);
        }
        return cacheServerInformation;
    }


    public String getResult(){
        CacheServerInformation[] serverInformation = getVideosByServer();
        String response = "";
        response += this.cacheServers+"\n";
        String serverInfoLine;
        for(int i = 0; i < serverInformation.length; i++){
            serverInfoLine = "";
            serverInfoLine += serverInformation[i].getServerId() + " " ;
            for (int j = 0; j < serverInformation[i].getVideos().size(); j++){
                serverInfoLine += serverInformation[i].getVideos().get(j).getIndex() + " ";
            }
            serverInfoLine = new StringBuilder(serverInfoLine).deleteCharAt(serverInfoLine.lastIndexOf(" ")).toString() + "\n";
            response += serverInfoLine;
        }
        return response;
    }


}
