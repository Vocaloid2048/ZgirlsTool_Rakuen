package voc.net.tools.zgirls_tool.util;

public class Information {

    public String Name;
    public String Type;
    public String Date;
    public String Link;
    public String Author;

    public Information() {

    }

    public Information(String name, String type, String date, String link, String author) {
        this.Name = name;
        this.Type = type;
        this.Date = date;
        this.Link = link;
        this.Author = author;

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }


}

