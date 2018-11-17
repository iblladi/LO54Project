package fr.utbm.lo54.coursesession.metier;

import fr.utbm.lo54.coursesession.entity.Location;

import java.util.List;

public interface LocationMetier {

    public List<Location> listLocation();

    public Location saveLocation(Location c);

    public void updateLocation(Location c);

    public void deleteLocation(Long id);

    public boolean LocationExists(Location c);

    public Location findOne(Long id);

}
