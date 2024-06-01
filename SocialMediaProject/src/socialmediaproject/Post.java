package socialmediaproject;

import java.time.LocalDateTime;
import java.util.Date;

public class Post {
    
    //Gönderi ile ilgili bilgiler
    private String content;
    private User author;
    private LocalDateTime date;
            
    //constructor
    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.date = LocalDateTime.now();
    }
    
    
    //İçeriği almak için
    public String getContent()
    {
        return content;
    }
    
    //Atılan zamanı yazdırmak için
    public LocalDateTime getPostDate(){
        return date;
    }
    
    //Yazarı almak için
    public User getAuthor(){
        return author;
    }
}
