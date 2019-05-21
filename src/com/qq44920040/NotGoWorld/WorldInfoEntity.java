package com.qq44920040.NotGoWorld;

import java.util.List;

class WorldInfoEntity {

    WorldInfoEntity(List<String> worldlist,String Msg) {
        this.worldlist = worldlist;
        this.Msg = Msg;
    }

    public List<String> getWorldlist() {
        return worldlist;
    }


    public String getMsg() {
        return Msg;
    }

    private List<String> worldlist;
    private String Msg;

}
