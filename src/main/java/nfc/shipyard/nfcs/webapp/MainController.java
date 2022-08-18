package nfc.shipyard.nfcs.webapp;

import nfc.shipyard.nfcs.Classes.Component;
import nfc.shipyard.nfcs.Classes.Fleet;
import nfc.shipyard.nfcs.Classes.Ship;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static nfc.shipyard.nfcs.Classes.Ship.fillShip;
import static nfc.shipyard.nfcs.Classes.Ship.generateShipKey;

//@Controller
public class MainController {

    private final Fleet fleet;
    private final List<Component> allComponents = new ArrayList<>(Component.getComponents());

    public MainController(Fleet fleet) {
        this.fleet = fleet;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("fleet", fleet);
//        model.addAttribute("allComponents", allComponents);
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("fleet", fleet);
        return "index";
    }

    //Rename Fleet
    @GetMapping("/shipyardFleet")
    public String shipyardFleetForm(Model model) {
        Fleet fleet = new Fleet();
        model.addAttribute("fleet", fleet);
        return "shipyardFleet";
    }

    @PostMapping("/shipyardFleet")
    public String shipyardFleetSubmit(Fleet fleet, Model model) {
        model.addAttribute("fleet", fleet);
        return "index";
    }


    //Add Ship
    @GetMapping("/addSprinter")
    public String shipyardAddShipForm(Model model) {
        Ship ship = new Ship();
        fillShip(ship, "Stock/Sprinter Corvette");
        model.addAttribute("ship", ship);
        model.addAttribute("allComponents", allComponents);
        model.addAttribute("fleet", fleet);
        return "addSprinter";
    }

    @PostMapping("/addSprinter")
    public String shipyardAddShipSubmit(Ship ship, Model model) {
        fillShip(ship, "Stock/Sprinter Corvette");
        model.addAttribute("ship", ship);
        model.addAttribute("allComponents", allComponents);
        model.addAttribute("fleet", fleet);
        fleet.getShips().add(ship);
        return "addSprinter";
    }

    @GetMapping("/addSprinter2")
    public String shipyardAddShipForm2(Model model) {
        Ship ship = new Ship();
        fillShip(ship, "Stock/Sprinter Corvette");
        model.addAttribute("ship", ship);
        model.addAttribute("fleet", fleet);
        return "addSprinter2";
    }

    @PostMapping("/addSprinter2")
    public String shipyardAddShipSubmit2(Ship ship, Model model) {
        fillShip(ship, "Stock/Sprinter Corvette");
        model.addAttribute("ship", ship);
        model.addAttribute("fleet", fleet);
        fleet.getShips().add(ship);
        return "addSprinter2";
    }
}
