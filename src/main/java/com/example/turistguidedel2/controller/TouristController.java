package com.example.turistguidedel2.controller;

import com.example.turistguidedel2.model.TouristAttraction;
import com.example.turistguidedel2.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction updateTouristAttraction = touristService.updateAttraction(touristAttraction);
        if (updateTouristAttraction != null) {
            return ResponseEntity.ok(updateTouristAttraction);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("delete/name")
    public ResponseEntity<String> deleteAttractionByName(@RequestBody TouristAttraction touristAttraction){
        String attractionName = touristAttraction.getName();
        boolean isDeleted = touristService.deleteTouristAttractionByName(attractionName);

        if (isDeleted) {
            return new ResponseEntity<>("Attraction deleted succesfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Attraction not found", HttpStatus.NOT_FOUND);
        }

    }
}
