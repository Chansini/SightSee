
package com.example.sightsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Place {

        @SerializedName("Place_id")
        @Expose
        private String placeId;
        @SerializedName("Place_Name")
        @Expose
        private String placeName;
        @SerializedName("Location")
        @Expose
        private String location;
        @SerializedName("Place_Details")
        @Expose
        private String placeDetails;
        @SerializedName("Place_travel")
        @Expose
        private String placeTravel;
        @SerializedName("Place_phone")
        @Expose
        private String placePhone;
        @SerializedName("Place_Price")
        @Expose
        private String placePrice;
        @SerializedName("Place_Date")
        @Expose
        private String placeDate;
        @SerializedName("Place_time")
        @Expose
        private String placeTime;
        @SerializedName("Place_Type")
        @Expose
        private String placeType;
        @SerializedName("Facebook")
        @Expose
        private String facebook;

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPlaceDetails() {
            return placeDetails;
        }

        public void setPlaceDetails(String placeDetails) {
            this.placeDetails = placeDetails;
        }

        public String getPlaceTravel() {
            return placeTravel;
        }

        public void setPlaceTravel(String placeTravel) {
            this.placeTravel = placeTravel;
        }

        public String getPlacePhone() {
            return placePhone;
        }

        public void setPlacePhone(String placePhone) {
            this.placePhone = placePhone;
        }

        public String getPlacePrice() {
            return placePrice;
        }

        public void setPlacePrice(String placePrice) {
            this.placePrice = placePrice;
        }

        public String getPlaceDate() {
            return placeDate;
        }

        public void setPlaceDate(String placeDate) {
            this.placeDate = placeDate;
        }

        public String getPlaceTime() {
            return placeTime;
        }

        public void setPlaceTime(String placeTime) {
            this.placeTime = placeTime;
        }

        public String getPlaceType() {
            return placeType;
        }

        public void setPlaceType(String placeType) {
            this.placeType = placeType;
        }

        public String getFacebook() {
            return facebook;
        }

        public void setFacebook(String facebook) {
            this.facebook = facebook;
        }


}