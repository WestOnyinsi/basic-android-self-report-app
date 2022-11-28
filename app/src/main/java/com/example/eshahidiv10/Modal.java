package com.example.eshahidiv10;


    public class Modal {

        // variables for our activity id, name,
        // location, time, reporter and description

        private int id;
        private String activityName;
        private String activityDate;
        private String activityLocation;
        private String activityTime;
        private String activityReporter;
        private String activityDescription;

        // creating getter and setter methods

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getActivityName() {
            return activityName;
        }

        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }

        public String getActivityDate() {
            return activityDate;
        }

        public void setActivityDate(String activityDate) {
            this.activityDate = activityDate;
        }

        public String getActivityLocation() {
            return activityLocation;
        }

        public void setActivityLocation(String activityLocation) {
            this.activityLocation = activityLocation;
        }


        public String getActivityTime() {
            return activityTime;
        }

        public void setActivityTime(String activityTime) {
            this.activityTime = activityTime;
        }

        public String getActivityReporter() {
            return activityReporter;
        }

        public void setActivityVolunteer(String activityVolunteer) {
            this.activityReporter = activityReporter;
        }

        public String getActivityDescription() {
            return activityDescription;
        }

        public void setActivityDescription(String activityDescription) {
            this.activityDescription = activityDescription;}



        // constructor
        public Modal(String activityName, String activityDate, String activityLocation, String activityTime, String activityReporter, String activityDescription) {
            this.activityName = activityName;
            this.activityDate = activityDate;
            this.activityLocation = activityLocation;
            this.activityTime = activityTime;
            this.activityReporter = activityReporter;
            this.activityDescription = activityDescription;
        }
    }


