import java.sql.Time;
import java.util.Date;

public class Reminder {
    private String content;
    private Date date;
    private Time time;

    public Reminder(String content, Date date, Time time) {
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}