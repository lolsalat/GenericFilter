package stuff;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import search.Searchable;

// wir wollen sowohl nach Resource als auch Place filtern können.
// Damit das geht, müssen wir Searchable<Object> implementieren, da sowohl Resource als auch Place von Object erben.
public class Planet implements Searchable<Object> {
    
    private Set<Resource> resources;
    private Set<Place> places;

    public final String name;

    public Planet(String name){
        this.name = name;
        this.places = new HashSet<>();
        this.resources = EnumSet.noneOf(Resource.class);
    }

    public void addPlaces(Place... places){
        for(Place place : places){
            this.places.add(place);
        }
    }

    public void addResources(Resource... resources){
        for(Resource resource : resources){
            this.resources.add(resource);
        }
    }

    @Override
    public boolean hasFeature(Object feature) {
        if(feature instanceof Resource r){
            return this.resources.contains(r);
        }
        if(feature instanceof Place p){
            return this.places.contains(p);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
