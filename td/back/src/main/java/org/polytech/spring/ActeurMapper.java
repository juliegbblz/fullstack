package org.polytech.spring;

public final class ActeurMapper {
    public static ActeurDto toDto(Acteur a){
        return new ActeurDto(
            a.getId(),
            a.getNom());
    }

    public static Acteur toEntity(ActeurCreationDto d){
        Acteur a = new Acteur();
        a.setNom(d.nom());
        return a;
    }
    
}
