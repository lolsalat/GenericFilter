package search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Search<S, T extends Searchable<? super S>> {
    
    private List<T> all;
    private Set<S> filters;

    public Search(Collection<? extends T> all){
        this.all = new ArrayList<>();
        this.all.addAll(all);
        this.filters = new HashSet<>();
    }

    public void addFilter(S filter){
        this.filters.add(filter);
    }

    public void removeFilter(S filter){
        this.filters.remove(filter);
    }

    public void clearFilters(){
        this.filters.clear();;
    }

    // objekte in all, die alle filter erfüllen
    public List<T> getMatchAll(){
        return all.stream().filter(x -> filters.stream().allMatch(x::hasFeature)).collect(Collectors.toList());
    }

    // objecte in all, die mindestens einen filter erfüllen
    public List<T> getMatchAny(){
        return all.stream().filter(x -> filters.stream().anyMatch(x::hasFeature)).collect(Collectors.toList());
    }

}
