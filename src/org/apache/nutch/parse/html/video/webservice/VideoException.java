package org.apache.nutch.parse.html.video.webservice;

public class VideoException extends Exception {
    String detail;
    
    public VideoException (String message, String detail) {
        super (message);
        this.detail = detail;
    }
    
    public String getDetail () {
        return detail;
    }
}
