package voc.net.tools.zgirls_tool.util;

/**
 * Package voc.net.tools.zgirls_tool was
 * Created by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2020 Xectorda 版權所有
 */
public class Building {
    public String Name;
    public long Lvl;
    public long Glory;
    public int Type;

    public Building() {

    }

    public Building(String Name, long Lvl, long Glory , int Type) {
        this.Name = Name;
        this.Lvl = Lvl;
        this.Glory = Glory;
        this.Type = Type;

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public long getLvl() {
        return Lvl;
    }

    public void setLvl(long Lvl) {
        this.Lvl = Lvl;
    }

    public long getGlory() {
        return Glory;
    }

    public void setGlory(long Glory) {
        this.Glory = Glory;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }
}
