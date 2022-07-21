package project;

import java.util.List;

public class Fleet {
    String fleetName;
    int version = 2;
    int totalPoints;
    String factionKey = "Stock/Alliance";
    List <Ship> ships;

    public Fleet(String fleetName) {
        this.fleetName = fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public String getFleetName() {
        return fleetName;
    }

    public int getVersion() {
        return version;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public String getFactionKey() {
        return factionKey;
    }

    public List<Ship> getShips() {
        return ships;
    }

    String returnFleetString(){
        return "<Fleet\n" +
                "<Name>"+ fleetName +"</Name>\n" +
                "<Version>"+version+"</Version>\n" +
                "  <TotalPoints>"+totalPoints+"</TotalPoints>\n" +
                "  <FactionKey>"+factionKey+"</FactionKey>\n" +
                "  <Ships>\n" + ships.toString() +
                "  </Ships>\n" +
                "</Fleet>";
    }
}
