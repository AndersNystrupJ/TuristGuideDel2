package com.example.turistguidedel2.repository;
import com.example.turistguidedel2.model.Tags;
import com.example.turistguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();
    private final List<Tags> tags = new ArrayList<>();

    public TouristRepository() {
        populatedAttraction();
    }



    public void populatedAttraction() {
        touristAttractions.add(new TouristAttraction("The round tower", "36m høj bygning på strøget. Bygget i 1600-tallet.", "København",List.of(Tags.SEVÆRDIGHED, Tags.UNDERHOLDNING)));
        touristAttractions.add(new TouristAttraction("The little mermaid", "Lille bronzestatue i vandet ved langelinie. Illustrerer den lille havfrue fra H.C. Andersens eventyr.", "Købenavn", List.of(Tags.SEVÆRDIGHED)));
        touristAttractions.add(new TouristAttraction("Proud Mary", "Hjertet af Københavns natteliv med gode chancer for at drikke dig fuldkommen sønder og sammen.","København",List.of(Tags.UNDERHOLDNING,Tags.BAR)));
        touristAttractions.add(new TouristAttraction("Nyhavn", "Old harbour in the center of Copenhagen, dominated by colorful buildings, and a cozy atmosphere with restaurants along the promenade", "København", List.of(Tags.RESTAURANT)));
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

    public void addTouristAttraction2(String name, String description, String by, List<Tags> tags) {
        touristAttractions.add(new TouristAttraction(name, description, by, tags));
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

    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
    }
    public void deleteAttraction(TouristAttraction touristAttraction) {
        touristAttractions.remove(touristAttraction);
    }

}
