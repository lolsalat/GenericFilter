package stuff;

// orte haben nur einen Namen
public class Place {
    
    public final String name;

    public Place(String name){
        this.name = name;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Place p){
            return p.name.equals(this.name);
        }
        return false;
    }

}
