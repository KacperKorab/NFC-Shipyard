package nfc.shipyard.nfcs.xmlSerialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import nfc.shipyard.nfcs.Classes.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        /*// Load fleet from file and modify
        File file = new File("Fleets/NFCS Sprinter.fleet");
        XmlMapper xmlMapper = new XmlMapper();
        Fleet fleet;
        try {
            fleet = xmlMapper.readValue(file, Fleet.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        modifyFleet(fleet);
        */

        // Create Fleet
        Fleet fleet = new Fleet();
        renameFleet(fleet);
        modifyFleet(fleet);
    }
    public static void renameFleet(Fleet fleet) {
        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Enter new fleet name:");
        fleet.setName(stringScanner.nextLine());
    }

    public static void saveFleet(Fleet fleet, String savePath) {
        //remove sockets with no components
        List<Ship> shipList = fleet.getShips();
        for (Ship ship : shipList) {
            fleet.setTotalPoints(fleet.getTotalPoints() + ship.getCost());
            List<HullSocket> socketList = ship.getSockets();
            List<HullSocket> filledSockets = new ArrayList<>();
            for (HullSocket socket : socketList) {
                if (socket.getComponentName() != null) {
                    filledSockets.add(socket);
                }
            }
            ship.setSockets(filledSockets);
        }
        fleet.setShips(shipList);

        XmlMapper xmlMapper = new XmlMapper();
        String filename = savePath + fleet.getName() + ".fleet";
        try {
            String formattedFleet = new XmlFormatter().format(xmlMapper.writeValueAsString(fleet));
            formattedFleet = "<?xml version=\"1.0\"?>\n" + formattedFleet;
            formattedFleet = formattedFleet.replaceFirst("<Fleet>",
                    "<Fleet xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
            formattedFleet = formattedFleet.replaceFirst("<SaveID/>", "<SaveID xsi:nil=\"true\" />");
            File file = new File(filename);
            FileUtils.writeStringToFile(file, formattedFleet, StandardCharsets.UTF_8);
//            file.renameTo(new File(savePath + fleet.getName() + ".fleet")); //doesn't work
            System.out.println(formattedFleet);
            System.out.println("Created file: " + file.getName() +
                    "\nFile location: " + file.getAbsolutePath());


        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void modifyFleet(Fleet fleet) {
        /*
        Done
         1. Load File.
         2. Turn it into ships.
         3. Using user input view ships.
         4. Using user input change components.
         5. Return fleet object.
        */

        // Turn Fleet into ships
        List<Ship> shipList = fleet.getShips();

        while (true) {
            Scanner intScanner = new Scanner(System.in);
            System.out.println("Loaded fleet: " + fleet.getName());
            System.out.println("Enter a number:\n'0' to quit, '1' to view ships," +
                    " '2' to add new ship, '3' to save fleet.");
            int userInput = intScanner.nextInt();
            if (userInput == 0) break;
            if (userInput == 1) {
                while (true) {
                    // View Ships
                    System.out.println("Enter '0' to go back, enter ship index to view ship");
                    for (int i = 0; i < shipList.size(); i++) {
                        System.out.println(i + 1 + " : " + shipList.get(i).getName()
                                + ", " + shipList.get(i).getHullType() + ", " + shipList.get(i).getCost());
                    }
                    userInput = intScanner.nextInt();
                    if (userInput == 0) break;

                    Ship ship = shipList.get(userInput - 1);
                    List<HullSocket> hullSockets = ship.getSockets();

                    while (true) {
                        //View components
                        System.out.println("Enter '0' to go back, enter component index to modify");
                        System.out.println(ship.getName() + " " + ship.getHullType());
                        for (int i = 0; i < hullSockets.size(); i++) {
                            System.out.println(i + 1 + " : " + hullSockets.get(i).getSocketName()
                                    + ", " + hullSockets.get(i).getComponentName());
                        }
                        userInput = intScanner.nextInt();
                        if (userInput == 0) break;

                        //Select component and change it
                        HullSocket hullSocket = hullSockets.get(userInput - 1);
                        System.out.println("Selected: " + hullSocket.getSocketName());
                        System.out.println("Current component: " + hullSocket.getComponentName());
                        List<Component> allComponents = Component.getComponents();
                        List<Component> validComponents = new ArrayList<>();
                        for (Component component : allComponents) {
                            if (HullSocket.doesComponentFit(hullSocket, component)) {
                                validComponents.add(component);
                            }
                        }
                        System.out.println("0 : Remove");
                        for (int i = 0; i < validComponents.size(); i++) {
                            System.out.println(i + 1 + " : " + validComponents.get(i).getComponentName());
                        }
                        userInput = intScanner.nextInt();
                        if (userInput == 0) {
                            hullSocket.setComponent(new Component("Remove", 0, 0,
                                    0, 0, new SocketSize(0, 0, 0)));
                            hullSocket.setComponentName("");
                            break;
                        }
                        hullSocket.setComponent(validComponents.get(userInput - 1));
                        hullSocket.setComponentName("Stock/" + validComponents.get(userInput - 1).getComponentName());

                        //Ship cost
                        for (HullSocket socket : hullSockets) {
                            if (socket.getComponent() != null) {
                                ship.setCost(ship.getCost() + socket.getComponent().getComponentCost());
                            }
                        }
                    }
                }
            }
            if (userInput == 2) {
                addShipHull(fleet, shipList, intScanner);
            }
            if (userInput == 3) {
                saveFleet(fleet, "Fleets/");
                break;
            }
        }
    }

    private static void addShipHull(Fleet fleet, List<Ship> shipList, Scanner intScanner) {
        int userInput;
        System.out.println("Select an option or enter '0' to go back");
        System.out.println("1 : Sprinter Corvette");
        userInput = intScanner.nextInt();
        switch (userInput) {
            case 0:
                break;
            case 1:
                System.out.println("Selected: Sprinter Corvette");
                shipList.add(fleet.createShip("Stock/Sprinter Corvette"));
        }
    }
}