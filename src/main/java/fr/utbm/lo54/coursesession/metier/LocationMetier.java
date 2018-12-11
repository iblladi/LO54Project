package fr.utbm.lo54.coursesession.metier;

import fr.utbm.lo54.coursesession.entity.Location;

import java.util.List;

public interface LocationMetier {

    public List<Location> listLocation();

    public Location saveLocation(Location c);

    public Location findOne(Long id);

}
