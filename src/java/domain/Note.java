
package domain;

import java.io.Serializable;


public class Note implements Serializable{
    private String title;
    
    private String content;
    
    public Note() {
        this.title = "";
        this.content = "";
    }
    
    public Note(String title, String content) {
        this.title = title;
        this.content = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
