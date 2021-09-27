package message;



import org.apache.tomcat.jni.FileInfo;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private List<Message> messages = null;
    private List<FileInfo> fileInfos = null;
    private Error error = null;
    private String errStatus = "";

    public Response() {
        this.messages = new ArrayList<Message>();
    }

    public Response(List<FileInfo> fileInfos) {
        this.fileInfos = fileInfos;
    }

    public Response(String errStatus, Error err) {
        this.errStatus = errStatus;
        this.error = err;
    }

    public void addFileInfo(FileInfo file) {
        this.fileInfos.add(file);
    }

    public void addMessage(Message fail) {
    }
}