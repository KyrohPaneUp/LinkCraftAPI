package de.kyrohpaneup.linkcraftapi.data.player;

import de.kyrohpaneup.linkcraftapi.data.enums.Rank;
import de.kyrohpaneup.linkcraftapi.data.map.MapData;
import de.kyrohpaneup.linkcraftapi.data.map.MapTypeData;
import de.kyrohpaneup.linkcraftapi.data.rank.Bonus;
import de.kyrohpaneup.linkcraftapi.data.rank.Maze;
import de.kyrohpaneup.linkcraftapi.data.rank.Wolf;
import de.kyrohpaneup.linkcraftapi.data.tag.TagData;
import de.kyrohpaneup.linkcraftapi.data.tag.TagRarityData;

import java.util.ArrayList;
import java.util.List;

public class LCPlayer {

    private String name = "Steve";
    private Rank rank = Rank.I;
    private Bonus bonus = Bonus.b1;
    private Wolf wolf = Wolf.wolf_i;
    private Maze maze = Maze.I;
    private String hours = "0h";
    private int jumps = 0;
    private int pp = 0;
    private String joinDate = "None";
    private List<TagData> tagData = new ArrayList<>();
    private List<TagRarityData> tagRarityData = new ArrayList<>();
    private List<MapData> mapData = new ArrayList<>();
    private List<MapTypeData> mapTypeData = new ArrayList<>();

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getJumps() {
        return jumps;
    }

    public void setJumps(int jumps) {
        this.jumps = jumps;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public Wolf getWolf() {
        return wolf;
    }

    public void setWolf(Wolf wolf) {
        this.wolf = wolf;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TagData> getTagData() {
        return tagData;
    }

    public void setTagData(List<TagData> tagData) {
        this.tagData = tagData;
    }

    public List<TagRarityData> getTagRarityData() {
        return tagRarityData;
    }

    public void setTagRarityData(List<TagRarityData> tagRarityData) {
        this.tagRarityData = tagRarityData;
    }

    public List<MapData> getMapData() {
        return mapData;
    }

    public void setMapData(List<MapData> mapData) {
        this.mapData = mapData;
    }

    public List<MapTypeData> getMapTypeData() {
        return mapTypeData;
    }

    public void setMapTypeData(List<MapTypeData> mapTypeData) {
        this.mapTypeData = mapTypeData;
    }

}
