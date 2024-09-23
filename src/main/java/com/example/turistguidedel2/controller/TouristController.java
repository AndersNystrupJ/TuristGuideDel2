package com.example.turistguidedel2.controller;

import com.example.turistguidedel2.model.Tags;
import com.example.turistguidedel2.model.TouristAttraction;
import com.example.turistguidedel2.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public String listAttractions(Model model) {
        List<TouristAttraction> attractions = touristService.getAllTouristAttractions();
        model.addAttribute("attractions", attractions);
        return "attractionList";
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.findAttractionByName(name);
        return new ResponseEntity<>(touristAttraction,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristService.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }


    /*
    @PostMapping("/change")
    public ResponseEntity<TouristAttraction>changeAttraction(@RequestBody TouristAttraction touristAttraction, String updatedName, String updatedDescription){
        TouristAttraction changedTouristAttraction = touristService.changeAttraction(touristAttraction,updatedName, updatedDescription );
    return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }

     */
    /*@PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction updateTouristAttraction = touristService.updateAttraction(touristAttraction);
        if (updateTouristAttraction != null) {
            return ResponseEntity.ok(updateTouristAttraction);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }*/

    /*@DeleteMapping("delete/name")
    public ResponseEntity<String> deleteAttractionByName(@RequestBody TouristAttraction touristAttraction){
        String attractionName = touristAttraction.getName();
        boolean isDeleted = touristService.deleteTouristAttractionByName(attractionName);

        if (isDeleted) {
            return new ResponseEntity<>("Attraction deleted succesfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Attraction not found", HttpStatus.NOT_FOUND);
        }

    }*/

    //skal et sted hen pathvariable
    //sorter Requestmapping


    @GetMapping("/{name}/tags")
  public String showAttractionTags(@PathVariable("name") String name, Model model){
        TouristAttraction attraction = touristService.findAttractionByName(name);
        model.addAttribute("attraction", attraction);
        model.addAttribute("tags", Tags.values());
        return "tags";

    }

    @GetMapping("/addAttraction")
    public String addAttractions(Model model) {
        TouristAttraction touristAttraction = new TouristAttraction();
        touristAttraction.setTags(new ArrayList<>());  // Initialize the tags list

        // Add the TouristAttraction object and the Tags enum to the model
        model.addAttribute("touristAttraction", touristAttraction);
        model.addAttribute("Tags", Tags.values());  // This passes all enum values to the view

        // List of cities for the dropdown
        List<String> cities = Arrays.asList("Copenhagen", "Aarhus", "Odense", "Aalborg", "Esbjerg");
        model.addAttribute("cities", cities);

        return "addAttraction";
    }

    @PostMapping("/save")
    public String saveAttraction(@RequestParam String name,
                                 @RequestParam String description,
                                 @RequestParam String city,
                                 @RequestParam List<Tags> tags) {
        System.out.println("Save method called with Name: " + name);
        touristService.addTouristAttraction2(name, description, city, tags);

        return "redirect:/attractions";  // Redirect after saving
    }


    @GetMapping("/{name}/edit")
    public String editAttraction (@PathVariable("name") String name, Model model) {
        TouristAttraction attraction = touristService.findAttractionByName(name);
        model.addAttribute("attraction", attraction);
        model.addAttribute("tags", Tags.values());
        return "edit";
    }
    
    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.updateAttraction(touristAttraction);
        return "updateAttraction";
    }

    @PostMapping("/delete/{name}")
    public String deleteAttraction(@PathVariable("name") String name) {
        TouristAttraction touristAttraction = touristService.findAttractionByName(name);
        touristService.deleteAttraction(touristAttraction);
        return "redirect:/attractions";
    }



}
