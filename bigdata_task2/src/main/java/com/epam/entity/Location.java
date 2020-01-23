package com.epam.entity;

import java.util.Objects;

public class Location extends Entity {
   private float latitude;
   private float longitude;
   private long streetId;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public long getStreetId() {
        return streetId;
    }

    public void setStreetId(long streetId) {
        this.streetId = streetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        if (!super.equals(o)) return false;
        Location location = (Location) o;
        return Float.compare(location.getLatitude(), getLatitude()) == 0 &&
                Float.compare(location.getLongitude(), getLongitude()) == 0 &&
                getStreetId() == location.getStreetId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLatitude(), getLongitude(), getStreetId());
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", streetId=" + streetId +
                '}';
    }
}
