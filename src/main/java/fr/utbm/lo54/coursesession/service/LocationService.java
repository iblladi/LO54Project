package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.dao.LocationRepository;
import fr.utbm.lo54.coursesession.entity.Location;
import fr.utbm.lo54.coursesession.metier.LocationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements LocationMetier {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> listLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Location saveLocation(Location l) {
        return locationRepository.save(l);
    }

    @Override
    public void updateLocation(Location l) {
        saveLocation(l);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public boolean LocationExists(Location l) {
        return false;
    }

    @Override
    public Location findOne(Long id) {
        return locationRepository.getOne(id);
    }
}
