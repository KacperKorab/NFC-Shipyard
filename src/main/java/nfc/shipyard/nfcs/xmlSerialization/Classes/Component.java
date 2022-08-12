package nfc.shipyard.nfcs.xmlSerialization.Classes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Component {
    private String componentName;
    private int componentCost;
    private int powerBalance;
    private int crewBalance;
    private SocketSize componentSize;
    private int componentSocketType;
    // 1-Mounting, 2-Compartment, 3-Module


    public Component(String componentName, int componentSocketType, int componentCost, int powerBalance, int crewBalance, SocketSize componentSize) {
        this.componentName = componentName;
        this.componentCost = componentCost;
        this.powerBalance = powerBalance;
        this.crewBalance = crewBalance;
        this.componentSize = componentSize;
        this.componentSocketType = componentSocketType;
    }

    public static List<Component> getComponents() {
        List<Component> components = new ArrayList<>();
//        components.add(new Component("Remove", 0, 0,
//                0, 0, new SocketSize(0, 0, 0)));

        //Communications
        components.add(new Component("CR10 Antenna", 1,
                5, -250, 0, new SocketSize(2, 1, 2)));
        components.add(new Component("CR70 Antenna", 1,
                15, -600, 0, new SocketSize(2, 1, 2)));

        //EWar
        components.add(new Component("E15 ‘Masquerade’ Signature Booster", 1,
                20, -600, 0, new SocketSize(3, 1, 3)));
        components.add(new Component("E55 ‘Spotlight’ Illuminator", 1,
                20, -750, 0, new SocketSize(2, 1, 2)));
        components.add(new Component("E57 ‘Floodlight’ Illuminator", 1,
                30, -1500, 0, new SocketSize(2, 1, 2)));
        components.add(new Component("E70 ‘Interruption’ Jammer", 1,
                75, -750, 0, new SocketSize(3, 1, 3)));
        components.add(new Component("E71 ‘Hangup’ Jammer", 1,
                45, -500, 0,new SocketSize(2, 1, 2)));
        components.add(new Component("E90 ‘Blanket’ Jammer", 1,
                50, -100, 0,new SocketSize(2, 1, 2)));

        //Weapons
        //Compartments
        //Command
        components.add(new Component("Auxiliary Steering", 2,
                10, 0, -5, new SocketSize(3, 1, 3)));
        components.add(new Component("Basic CIC", 2,
                10, 0, -20, new SocketSize(4, 1, 6)));
        components.add(new Component("Citadel CIC", 2,
                75, 0, -40, new SocketSize(6, 1, 8)));
        components.add(new Component("Reinforced CIC", 2,
                25, 0, -20, new SocketSize(4, 1, 6)));
        //Crew
        components.add(new Component("Berthing", 2,
                0, 0, 0, new SocketSize(1,1,1)));
        //Modules
        //Powerplant
        components.add(new Component("FR3300 Micro Reactor", 3,
                10,2250,-5, new SocketSize(3,3,3)));
        components.add(new Component("FR3300 Micro Reactor", 3,
                10,4200,-10, new SocketSize(5,5,5)));
        //Propulsion
        components.add(new Component("FM200 Drive", 3,
                10, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM200R Drive", 3,
                20, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM230 'Whiplash' Drive", 3,
                20, 650, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM240 'Dragonfly' Drive", 3,
                20, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM280 'Raider' Drive", 3,
                20, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM30X 'Dragonfly' Drive", 3,
                20, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM500 Drive", 3,
                15, 1000, -10, new SocketSize(10, 8, 10)));
        //remaining size 2 drives

        return components;
    }
}