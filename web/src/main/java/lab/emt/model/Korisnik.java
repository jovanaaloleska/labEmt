package lab.emt.model;

import lab.emt.model.enumerations.RoleKorisnik;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Korisnik {

    @Enumerated(EnumType.STRING)
    private RoleKorisnik role;

    public Korisnik() {}
    public Korisnik(RoleKorisnik role)
    {
        this.role=role;
    }
}
