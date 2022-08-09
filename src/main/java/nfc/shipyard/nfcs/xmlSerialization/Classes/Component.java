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

    public Component(String componentName, int componentCost, int powerBalance, SocketSize componentSize) {
        this.componentName = componentName;
        this.componentCost = componentCost;
        this.powerBalance = powerBalance;
        this.componentSize = componentSize;
    }

    public Component(String componentName, int componentCost, int powerBalance, int crewBalance, SocketSize componentSize) {
        this.componentName = componentName;
        this.componentCost = componentCost;
        this.powerBalance = powerBalance;
        this.crewBalance = crewBalance;
        this.componentSize = componentSize;
    }

    public List<Component> getComponents() {
        List<Component> components = new ArrayList<>();
        components.add(new Component("Remove",
                0, 0, new SocketSize(0, 0, 0)));

        //Communications
        components.add(new Component("CR10 Antenna",
                5, -250, new SocketSize(2, 1, 2)));
        components.add(new Component("CR70 Antenna",
                15, -600, new SocketSize(2, 1, 2)));

        //EWar
        components.add(new Component("E15 ‘Masquerade’ Signature Booster",
                20, -600, new SocketSize(3, 1, 3)));
        components.add(new Component("E55 ‘Spotlight’ Illuminator",
                20, -750, new SocketSize(2, 1, 2)));
        components.add(new Component("E57 ‘Floodlight’ Illuminator",
                30, -1500, new SocketSize(2, 1, 2)));
        components.add(new Component("E70 ‘Interruption’ Jammer",
                75, -750, new SocketSize(3, 1, 3)));
        components.add(new Component("E71 ‘Hangup’ Jammer",
                45, -500, new SocketSize(2, 1, 2)));
        components.add(new Component("E90 ‘Blanket’ Jammer",
                50, -100, new SocketSize(2, 1, 2)));

        //Weapons
        //Compartments
        //Command
        components.add(new Component("Auxiliary Steering",
                10, 0, -5, new SocketSize(3, 1, 3)));
        components.add(new Component("Basic CIC",
                10, 0, -20, new SocketSize(4, 1, 6)));
        components.add(new Component("Citadel CIC",
                75, 0, -40, new SocketSize(6, 1, 8)));
        components.add(new Component("Reinforced CIC",
                25, 0, -20, new SocketSize(4, 1, 6)));
        //Crew
        components.add(new Component("Berthing",
                0, 0, 0, new SocketSize(1,1,1)));
        //Modules
        //Powerplant
        components.add(new Component("FR3300 Micro Reactor",
                10,2250,-5, new SocketSize(3,3,3)));
        components.add(new Component("FR3300 Micro Reactor",
                10,4200,-10, new SocketSize(5,5,5)));
        //Propulsion
        components.add(new Component("FM200 Drive",
                10, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM200R Drive",
                20, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM230 'Whiplash' Drive",
                20, 650, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM240 'Dragonfly' Drive",
                20, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM280 'Raider' Drive",
                20, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM30X 'Dragonfly' Drive",
                20, 500, -10, new SocketSize(5, 3, 5)));
        components.add(new Component("FM500 Drive",
                15, 1000, -10, new SocketSize(10, 8, 10)));
        //remaining size 2 drives

        return components;
    }
}