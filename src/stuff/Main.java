package stuff;

import static stuff.Resource.*;

import java.util.List;

import search.Search;

public class Main {
    
    public static void main(String[] args){

        // Planeten haben resourcen und Orte, man kann nach beiden filtern.
        // Rezepte kann man nach output (der output ist eine Resource) filtern

        Planet erde = new Planet("Erde");
        erde.addResources(IRON, WEED, DIAMOND);
        erde.addPlaces(new Place("Base"), new Place("Deutschland"), new Place("Frankreich"));
        Planet saturn = new Planet("Saturn");
        saturn.addResources(COAL, DUMMIUM, IRON);
        saturn.addPlaces(new Place("Base"), new Place("Dummium Miene"));
        Planet mars = new Planet("Mars");
        mars.addResources(WEED, COAL);
        mars.addPlaces(new Place("Kiffer Palast"));

        Search<Resource, Planet> resourceSearch = new Search<>(List.of(erde, saturn, mars));
        resourceSearch.addFilter(COAL);
        System.out.printf("Planeten mit COAL: %s\n", resourceSearch.getMatchAll()); // alle mit COAL
        resourceSearch.addFilter(IRON);
        System.out.printf("Planeten mit COAL und IRON: %s\n", resourceSearch.getMatchAll()); // alle mit COAL und IRON
        System.out.printf("Planeten mit COAL oder IRON: %s\n", resourceSearch.getMatchAny()); // alle mit COAL oder IRON

        Search<Place, Planet> placeSearch = new Search<>(List.of(erde, saturn, mars));
        placeSearch.addFilter(new Place("Base"));
        System.out.printf("Planeten mit Ort 'Base': %s\n", placeSearch.getMatchAll()); // alle mit dem Place "Base"

        Recipe iron = new Recipe(IRON, COAL, DUMMIUM);
        Recipe iron2 = new Recipe(IRON, COAL, WEED);
        Recipe coal = new Recipe(COAL, DUMMIUM);

        Search<Resource, Recipe> recipeSearch = new Search<>(List.of(iron, iron2, coal));
        recipeSearch.addFilter(IRON);
        System.out.printf("Rezepte, die IRON herstellen: %s\n", recipeSearch.getMatchAll()); // alle die Eisen herstellen
    }

}
