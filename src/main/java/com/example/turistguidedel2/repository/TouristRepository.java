package com.example.turistguidedel2.repository;
import com.example.turistguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        populatedAttraction();
    }

    public void populatedAttraction() {
        touristAttractions.add(new TouristAttraction("The round tower", "36m høj bygning på strøget. Bygget i 1600-tallet."));
        touristAttractions.add(new TouristAttraction("The little mermaid", "Lille bronzestatue i vandet ved langelinie. Illustrerer den lille havfrue fra H.C. Andersens eventyr."));
        touristAttractions.add(new TouristAttraction("Proud Mary", "Hjertet af Københavns natteliv med gode chancer for at drikke dig fuldkommen sønder og sammen."));
        touristAttractions.add(new TouristAttraction("Nyhavn", "Old harbour in the center of Copenhagen, dominated by colorful buildings, and a cozy atmosphere with restaurants along the promenade"));
    }

    //GETMAPPING-ATTRACTION{NAME}
    public TouristAttraction findAttractionByName(String name) {
        TouristAttraction touristAttractionMatch = null;
        for (TouristAttraction attraction : getAllTouristAttractions()) {
            if (name.equals(attraction.getName())) {
                touristAttractionMatch = attraction;
            }
        }
        return touristAttractionMatch;
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction){
        touristAttraction.setName(touristAttraction.getName());
        touristAttractions.add(touristAttraction);
        return touristAttraction;
    }


    public List<TouristAttraction> getAllTouristAttractions() {
        return touristAttractions;
    }
    public TouristAttraction updateAttraction(TouristAttraction touristAttraction){
        TouristAttraction touristAttractionMatch = null;
        for (TouristAttraction attraction : getAllTouristAttractions()) {
            if (touristAttraction.getName().equals(attraction.getName())) {
                touristAttractionMatch = attraction;
            }
        }
        touristAttractionMatch.setDescription(touristAttraction.getDescription());
        return touristAttraction;
    }
}
