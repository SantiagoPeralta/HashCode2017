package com.company.dto;

public class VideoInformation {
    private int index;
    private int size;

    public VideoInformation(int index, int size) {
        this.index = index;
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }
}
