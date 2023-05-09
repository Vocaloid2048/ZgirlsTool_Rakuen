package voc.net.tools.zgirls_tool.util;

/**
 * Package voc.net.tools.zgirls_tool.util was
 * Created by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2020 Xectorda 版權所有
 */
public class Troops {
    public String Name;
    public int Id;
    public long total;
    public long in_sch;
    public long out_sch;

    public Troops() {

    }

    public Troops(String Name, int Id, long total, long in_sch, long out_sch ) {
        this.Name = Name;
        this.Id = Id;
        this.total = total;
        this.in_sch = in_sch;
        this.out_sch = out_sch;

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getIn_sch() {
        return in_sch;
    }

    public void setIn_sch(long in_sch) {
        this.in_sch = in_sch;
    }

    public long getOut_sch() {
        return out_sch;
    }

    public void setOut_sch(long out_sch) {
        this.out_sch = out_sch;
    }

}

