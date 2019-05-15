package com.apress.prospring5.ch3;

public class FtpArtworkSender implements ArtworkSender{
    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {
        //ftp logic here
    }

    @Override
    public String getFriendName() {
        return "File Transfer Protocal";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }
}
