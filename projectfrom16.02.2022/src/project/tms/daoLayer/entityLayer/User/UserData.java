package project.tms.daoLayer.entityLayer.User;

public class UserData {

    private String bankCard;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public UserData(User user) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (bankCard != null ? !bankCard.equals(userData.bankCard) : userData.bankCard != null) return false;
        if (firstName != null ? !firstName.equals(userData.firstName) : userData.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userData.lastName) : userData.lastName != null) return false;
        return phoneNumber != null ? phoneNumber.equals(userData.phoneNumber) : userData.phoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = bankCard != null ? bankCard.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "bankCard='" + bankCard + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
