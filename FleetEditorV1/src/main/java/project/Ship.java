package project;

import com.mifmif.common.regex.Generex;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    String shipKey;
    String shipName;
    String[] validShipNames = {
            "Stock/Sprinter Corvette",
            "Stock/Raines Frigate",
            "Stock/Keystone Destroyer",
            "Stock/Vauxhall Light Cruiser",
            "Stock/Axford Heavy Cruiser",
            "Stock/Solomon Battleship",
    };
    int shipCost;
    int shipNumber;
    int symbolOption;
    String shipHullType;
    List<HullSocket> socketMap = new ArrayList<>();
    String[] validSocketKeys = {
            "98N-YI_1WUOs--qPYlt-7g", //CIC
            "bRgUlaoQJ0S7M91zMpdAdA", //reactor
            "Jmtnwo0KQki5QyEPPlBHrA", //drive
            "V42tXibIR0e4u6riIHYZOw", //radar
    };
    List<WeaponGroup> weaponGroups = new ArrayList<>();

    public Ship(String shipName, String shipHullType) {
        this.shipName = shipName;
        this.shipHullType = shipHullType;
        this.shipKey = generateShipKey();
    }

    static String generateShipKey() {
        Generex generex = new Generex("([0-9]|[a-f])");
        StringBuilder randomShipKey = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            randomShipKey.append(generex.random());
        }
        randomShipKey.append("-");
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 4; i++) {
                randomShipKey.append(generex.random());
            }
            randomShipKey.append("-");
        }
        for (int i = 0; i < 12; i++) {
            randomShipKey.append(generex.random());
        }
        return randomShipKey.toString();
    }

    @Override
    public String toString() {
        return "<Ship>\n" +
                "  <SaveID xsi:nil=\"true\" />\n" +
                "  <Key>" + shipKey + "</Key>\n" +
                "  <Name>" + shipName + "</Name>\n" +
                "  <Cost>" + shipCost + "</Cost>\n" +
                "  <Number>" + shipNumber + "</Number>\n" +
                "  <SymbolOption>0</SymbolOption>\n" +
                "  <HullType>" + shipHullType + "</HullType>" +
                "  <SocketMap>\n" +
                socketMap.toString() +
                "  </SocketMap>\n" +
                "  <WeaponGroups />\n" +
                "</Ship>";
    }

    public String getShipKey() {
        return shipKey;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getShipCost() {
        return shipCost;
    }

    public int getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(int shipNumber) {
        this.shipNumber = shipNumber;
    }

    public int getSymbolOption() {
        return symbolOption;
    }

    public String getShipHullType() {
        return shipHullType;
    }

    public List<HullSocket> getSocketMap() {
        return socketMap;
    }

    public List<WeaponGroup> getWeaponGroups() {
        return weaponGroups;
    }
}
