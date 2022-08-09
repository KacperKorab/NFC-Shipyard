package nfc.shipyard.nfcs.xmlSerialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import nfc.shipyard.nfcs.xmlSerialization.Classes.Fleet;
import nfc.shipyard.nfcs.xmlSerialization.Classes.HullSocket;
import nfc.shipyard.nfcs.xmlSerialization.Classes.Ship;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
/*
TODO
    Map socketKeys to readable data for the Sprinter
    add component and socketKey categories
 */

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Fleets/NFCS Sprinter.fleet");
        XmlMapper xmlMapper = new XmlMapper();
        Fleet fleet;
        try {
            fleet = xmlMapper.readValue(file, Fleet.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        changeComponent(fleet);

        /*
        File file = new File("Fleets/NFCS Sprinter.fleet");
        XmlMapper xmlMapper = new XmlMapper();
        Fleet fleet = xmlMapper.readValue(file, Fleet.class);
        System.out.println(fleet+"\n");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, fleet);
        System.out.println(byteArrayOutputStream+"\n");

        Ship ship = fleet.getShips().get(0);
        HullSocket hullSocket = ship.getSockets().get(9);
        System.out.println("Changing: "+ hullSocket);
        hullSocket.setComponentName("Stock/FM200R Drive");

        System.out.println(hullSocket+"\n");
        System.out.println(fleet+"\n");

         */
    }

    public static void saveFleet(Fleet fleet, String savePath) {
        XmlMapper xmlMapper = new XmlMapper();
        String filename = savePath + fleet.getName() + ".fleet";
        try {
            String formattedFleet = new XmlFormatter().format(xmlMapper.writeValueAsString(fleet));
            File file = new File(filename);
            FileUtils.writeStringToFile(file, formattedFleet, StandardCharsets.UTF_8);
            System.out.println(formattedFleet);
            System.out.println("Created new file: " + file.getName() +
                    "\nFile location: " + file.getAbsolutePath());


        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Fleet changeComponent(Fleet fleet) {
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
            System.out.println("Enter a number:\n'0' to quit, '1' to view ships, '2' to save fleet.");
            int userInput = intScanner.nextInt();
            if (userInput == 0) break;
            if (userInput == 1) {
                while (true) {
                    // View Ships
                    System.out.println("Enter '0' to go back, enter ship index to view ship");
                    for (int i = 0; i < shipList.size(); i++) {
                        System.out.println(i + 1 + " : " + shipList.get(i).getName()
                                + ", " + shipList.get(i).getHullType());
                    }
                    userInput = intScanner.nextInt();
                    if (userInput == 0) break;

                    Ship ship = shipList.get(userInput - 1);
                    List<HullSocket> hullSockets = ship.getSockets();

                    while (true) {
                        //View components
                        //TODO Select new component from a list instead of writing name.
                        System.out.println("Enter '0' to go back, enter component index to modify");
                        System.out.println(ship.getName() + " " + ship.getHullType());
                        for (int i = 0; i < hullSockets.size(); i++) {
                            System.out.println(i + 1 + " : " + hullSockets.get(i).getKey()
                                    + ", " + hullSockets.get(i).getComponentName());
                        }
                        userInput = intScanner.nextInt();
                        if (userInput == 0) break;

                        //Select component and change it
                        HullSocket hullSocket = hullSockets.get(userInput - 1);
                        System.out.println("Selected: " + hullSocket.getComponentName() +
                                "\nEnter new component's name: ");
                        String newComponentName;
                        Scanner stringScanner = new Scanner(System.in);
                        newComponentName = stringScanner.nextLine();
                        hullSocket.setComponentName("Stock/" + newComponentName);
                    }
                }
            }
            if (userInput == 2) {
                Scanner stringScanner = new Scanner(System.in);
                System.out.println("Fleet name: " + fleet.getName() +
                        "\nEnter new fleet name:");
                fleet.setName(stringScanner.nextLine());

                saveFleet(fleet, "Fleets/");
                break;
            }
        }
        return fleet;
    }
}