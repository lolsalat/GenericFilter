package stuff;

import java.util.EnumSet;
import java.util.Set;

import search.Searchable;

// Rezepte sind einfach, wir können nur nach Resource filtern (output)
// also müssen wir nur Searchable<Resource> implementieren
public class Recipe implements Searchable<Resource> {
    
    private final Resource output;
    private final Set<Resource> input;

    public Recipe(Resource output, Resource... input){
        this.output = output;
        this.input = EnumSet.noneOf(Resource.class);
        for(Resource r : input)
            this.input.add(r);
    }

    @Override
    public boolean hasFeature(Resource feature) {
        return output == feature;
    }

    @Override
    public String toString(){
        return String.format("%s -> %s", input, output);
    }

}
