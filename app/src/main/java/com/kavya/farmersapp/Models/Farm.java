package com.kavya.farmersapp.Models;

public class Farm {

    public String farm_name,farm_pic, farm_owner,farm_locatoion,farm_type;

    public Farm(String farm_name, String farm_pic, String farm_owner, String farm_locatoion, String farm_type) {
        this.farm_name = farm_name;
        this.farm_pic = farm_pic;
        this.farm_owner = farm_owner;
        this.farm_locatoion = farm_locatoion;
        this.farm_type = farm_type;
    }

    public String getFarm_name() {
        return farm_name;
    }

    public void setFarm_name(String farm_name) {
        this.farm_name = farm_name;
    }

    public String getFarm_pic() {
        return farm_pic;
    }

    public void setFarm_pic(String farm_pic) {
        this.farm_pic = farm_pic;
    }

    public String getFarm_owner() {
        return farm_owner;
    }

    public void setFarm_owner(String farm_owner) {
        this.farm_owner = farm_owner;
    }

    public String getFarm_locatoion() {
        return farm_locatoion;
    }

    public void setFarm_locatoion(String farm_locatoion) {
        this.farm_locatoion = farm_locatoion;
    }

    public String getFarm_type() {
        return farm_type;
    }

    public void setFarm_type(String farm_type) {
        this.farm_type = farm_type;
    }
}
