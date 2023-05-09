package voc.net.tools.zgirls_tool.util;

/**
 * Package voc.net.tools.zgirls_tool.util was
 * Created by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2020 Xectorda 版權所有
 */
public class Tech {
    public String Name;
    public int Id;
    public long lvl;
    public int buffId;
    public long buff;

    public Tech() {

    }

    public Tech(String Name, int Id, long lvl,int buffId,long buff) {
        this.Name = Name;
        this.Id = Id;
        this.lvl = lvl;
        this.buffId = buffId;
        this.buff = buff;

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

    public long getLvl() {
        return lvl;
    }

    public void setLvl(long lvl) {
        this.lvl = lvl;
    }

    public long getBuff() {
        return buff;
    }

    public void setBuff(long buff) {
        this.buff = buff;
    }
    public int getBuffId() {
        return buffId;
    }

    public void setBuffId(int buffId) {
        this.buffId = buffId;
    }

}

