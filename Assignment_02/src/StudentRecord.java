class StudentRecord {
    private String firstName;
    private String lastName;
    private int bannerID;

    public StudentRecord(String firstName, String lastName, int bannerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bannerID = bannerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBannerID() {
        return bannerID;
    }

    public void setBannerID(int bannerID) {
        this.bannerID = bannerID;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName + ", bannerID: " + bannerID;
    }
}
