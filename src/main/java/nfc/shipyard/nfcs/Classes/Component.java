package nfc.shipyard.nfcs.Classes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@org.springframework.stereotype.Component
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

    public Component() {
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
                45, -500, 0, new SocketSize(2, 1, 2)));
        components.add(new Component("E90 ‘Blanket’ Jammer", 1,
                50, -100, 0, new SocketSize(2, 1, 2)));

        //Sensors
        components.add(new Component("ES22 ‘Pinard’ Electronic Support Module", 1,
                30, -200, 0, new SocketSize(3, 1, 3)));
        components.add(new Component("RF101 ‘Bullseye’ Radar", 1,
                40, -300, 0, new SocketSize(2, 1, 2)));

        //Weapons
        //Beam
        components.add(new Component("Mk610 Beam Turret", 1,
                100, -3500, -20, new SocketSize(8, 5, 8)));

        //Missile
        components.add(new Component("MLS-2 Launcher", 1,
                20, -50, -10, new SocketSize(2, 2, 3)));
        components.add(new Component("MLS-3 Launcher", 1,
                20, -50, -12, new SocketSize(2, 2, 3)));
        components.add(new Component("VLS1-23 Launcher", 1,
                5, -50, 0, new SocketSize(2, 2, 2)));
        components.add(new Component("VLS2-16 Launcher", 1,
                10, -200, 0, new SocketSize(3, 4, 3)));

        //PD
        components.add(new Component("Mk20 ‘Defender’ PDT", 1,
                15, -175, -3, new SocketSize(2, 1, 2)));
        components.add(new Component("Mk25 ‘Rebound’ PDT", 1,
                30, -20, -3, new SocketSize(2, 1, 2)));
        components.add(new Component("Mk90 ‘Aurora’ PDT", 1,
                55, -700, 0, new SocketSize(2, 1, 2)));

        //Ballistic
        components.add(new Component("Mk61 Cannon", 1,
                10, -50, -4, new SocketSize(3, 1, 3)));
        components.add(new Component("Mk62 Cannon", 1,
                20, -50, -8, new SocketSize(3, 1, 3)));
        components.add(new Component("Mk64 Cannon", 1,
                30, -125, -15, new SocketSize(3, 1, 5)));
        components.add(new Component("Mk66 Cannon", 1,
                45, -200, -25, new SocketSize(6, 3, 6)));
        components.add(new Component("Mk68 Cannon", 1,
                75, -225, -40, new SocketSize(8, 5, 8)));

        //Railgun
        components.add(new Component("Mk81 Railgun", 1,
                50, -1500, -15, new SocketSize(6, 3, 6)));
        components.add(new Component("Mk82 Railgun", 1,
                80, -1800, -25, new SocketSize(8, 5, 8)));

        //Spinal
        components.add(new Component("Mk550 Mass Driver", 1,
                75, -2000, -15, new SocketSize(4, 12, 4)));
        components.add(new Component("Mk600 Beam Cannon", 1,
                75, -3000, -15, new SocketSize(4, 12, 4)));

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
        components.add(new Component("Battle Dressing Station", 2,
                20, 0, -8, new SocketSize(3, 1, 3)));
        components.add(new Component("Berthing", 2,
                0, 0, 0, new SocketSize(1, 1, 1)));

        //Damage Control
        components.add(new Component("Damage Control Central", 2,
                20, -50, -10, new SocketSize(3, 1, 3)));
        components.add(new Component("Large DC Locker", 2,
                45, 0, -15, new SocketSize(3, 1, 6)));
        components.add(new Component("Rapid DC Locker", 2,
                10, 0, -5, new SocketSize(3, 1, 3)));
        components.add(new Component("Reinforced DC Locker", 2,
                45, 0, -10, new SocketSize(3, 1, 3)));
        components.add(new Component("Small DC Locker", 2,
                30, 0, -10, new SocketSize(3, 1, 3)));
        components.add(new Component("Small Workshop", 2,
                20, -50, -10, new SocketSize(3, 1, 3)));

        //Engineering
        components.add(new Component("Plant Control Center", 2,
                25, 0, -15, new SocketSize(3, 1, 3)));

        //Intelligence
        components.add(new Component("Analysis Annex", 2,
                20, 0, -20, new SocketSize(3, 1, 3)));
        components.add(new Component("Intelligence Center", 2,
                90, 0, -45, new SocketSize(6, 1, 8)));

        //Storage
        components.add(new Component("Bulk Magazine", 2,
                1, 0, 0, new SocketSize(1, 1, 1)));
        components.add(new Component("Reinforced Magazine", 2,
                1, 0, 0, new SocketSize(1, 1, 1)));

        //Modules
        //Power plant
        components.add(new Component("FR3300 Micro Reactor", 3,
                10, 2250, -5, new SocketSize(3, 3, 3)));
        components.add(new Component("FR3300 Micro Reactor", 3,
                10, 4200, -10, new SocketSize(5, 5, 5)));
        
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