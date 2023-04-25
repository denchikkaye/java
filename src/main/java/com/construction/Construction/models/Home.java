package com.construction.Construction.models;

import javax.persistence.*;

@Entity
@Table(name = "home")
public class Home {
    @Id
    private Long id;
    private int plank;
    private int timber;
    private int insulation;
    private int vaporBarrier;
    private int windows;
    private int door;
    private int paint;
    private int roof;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlank() {
        return plank;
    }

    public void setPlank(int plank) {
        this.plank = plank;
    }

    public int getTimber() {
        return timber;
    }

    public void setTimber(int timber) {
        this.timber = timber;
    }

    public int getInsulation() {
        return insulation;
    }

    public void setInsulation(int insulation) {
        this.insulation = insulation;
    }

    public int getVaporBarrier() {
        return vaporBarrier;
    }

    public void setVaporBarrier(int vaporBarrier) {
        this.vaporBarrier = vaporBarrier;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getPaint() {
        return paint;
    }

    public void setPaint(int paint) {
        this.paint = paint;
    }

    public int getRoof() {
        return roof;
    }

    public void setRoof(int roof) {
        this.roof = roof;
    }
}
