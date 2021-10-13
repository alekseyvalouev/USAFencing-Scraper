package org.alekseyvalouev;

public class Competition {
    private String mName, mLocation, mDate, mRegDate;
    public Competition(String name, String location, String date, String regDate) {
        mName = name;
        mLocation = location;
        mDate = date;
        mRegDate = regDate;
    }

    public String getName() {
        return mName;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    public String getRegDate() {
        return mRegDate;
    }

    public String getFullInfo() {
        return (mName + " is in: " + mLocation + " on: " + mDate + ", " + mRegDate);
    }
}
