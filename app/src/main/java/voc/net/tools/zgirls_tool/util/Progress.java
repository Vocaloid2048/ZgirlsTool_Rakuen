package voc.net.tools.zgirls_tool.util;

public class Progress {
    private long TID;
    private long armyFinishTime;
    private long armyCount;

    public Progress() {
        super();
    }

    public Progress(long armyFinishTime, long armyCount ,long Id) {
        super();
        this.armyFinishTime = armyFinishTime;
        this.armyCount = armyCount;
        this.TID = Id;
    }

    public long getId() {
        return TID;
    }

    public void setId(long Id) {
        this.TID = Id;
    }

    public long getArmyFinishTime() {
        return armyFinishTime;
    }

    public void setArmyFinishTime(long armyFinishTime) {
        this.armyFinishTime = armyFinishTime;
    }

    public long getArmyCount() {
        return armyCount;
    }

    public void setArmyCount(long armyCount) {
        this.armyCount = armyCount;
    }
}