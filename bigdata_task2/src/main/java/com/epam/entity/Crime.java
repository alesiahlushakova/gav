package com.epam.entity;

import java.util.Objects;

public class Crime extends Entity {
    private String category;
    private String locationType;
    private int locationId;
    private String context;
    private String persistentId;
    private String outcomeStatus;
    private String locationSubtype;
    private String month;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getOutcomeStatus() {
        return outcomeStatus;
    }

    public void setOutcomeStatus(String outcomeStatus) {
        this.outcomeStatus = outcomeStatus;
    }

    public String getLocationSubtype() {
        return locationSubtype;
    }

    public void setLocationSubtype(String locationSubtype) {
        this.locationSubtype = locationSubtype;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(String persistentId) {
        this.persistentId = persistentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crime)) return false;
        Crime crime = (Crime) o;
        return getLocationId() == crime.getLocationId() &&
                getCategory().equals(crime.getCategory()) &&
                getLocationType().equals(crime.getLocationType()) &&
                getContext().equals(crime.getContext()) &&
                Objects.equals(getPersistentId(), crime.getPersistentId()) &&
                getOutcomeStatus().equals(crime.getOutcomeStatus()) &&
                getLocationSubtype().equals(crime.getLocationSubtype()) &&
                getMonth().equals(crime.getMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getLocationType(), getLocationId(), getContext(), getPersistentId(), getOutcomeStatus(), getLocationSubtype(), getMonth());
    }

    @Override
    public String toString() {
        return "Crime{" +
                "category='" + category + '\'' +
                ", locationType='" + locationType + '\'' +
                ", locationId=" + locationId +
                ", context='" + context + '\'' +
                ", persistentId='" + persistentId + '\'' +
                ", outcomeStatus='" + outcomeStatus + '\'' +
                ", locationSubtype='" + locationSubtype + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
