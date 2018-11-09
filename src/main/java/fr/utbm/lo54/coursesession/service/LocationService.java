package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.entity.Location;
import fr.utbm.lo54.coursesession.metier.LocationMetier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements LocationMetier {

    @Override
    public List<Location> listLocation() {
        return null;
    }

    @Override
    public Location saveLocation(Location c) {
        return null;
    }

    @Override
    public void updateLocation(Location c) {

    }

    @Override
    public void deleteLocation(Long id) {

    }

    @Override
    public boolean LocationExists(Location c) {
        return false;
    }

    @Override
    public Location findOne(Long id) {
        return null;
    }
}
