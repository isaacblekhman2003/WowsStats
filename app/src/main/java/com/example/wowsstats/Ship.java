package com.example.wowsstats;

import java.util.List;

public class Ship {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getConcealment() {
        return concealment;
    }

    public void setConcealment(String concealment) {
        this.concealment = concealment;
    }

    public String getTorpedo() {
        return torpedo;
    }

    public void setTorpedo(String torpedo) {
        this.torpedo = torpedo;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
    public String name;

    public String nation;
    public String type;
    public String gun;
    public String speed;
    public String hp;
    public String concealment;
    public String torpedo;
    public String tier;

    public List<Ship> ddSort(Ship[] ships){
        List<Ship> sort;
        sort = null;
        for(int i = 0; i> ships.length; i++){
            if(ships[i].getType() == "Destroyer"){
                sort.add(ships[i]);

            }


        }
        return sort;
    }


}
