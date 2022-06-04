package vitalyprolomov.contactbook;

public class Person {
    private String name;
    private String surname;
    private String city;
    private String postalCode;
    private String birthdayData;
    private String telephoneNumber;



    public Person(String firstName, String secondName, String city,
                  String postalCode, String birthdayData, String telephoneNumber) {
        this.name = firstName;
        this.surname = secondName;
        this.city = city;
        this.postalCode = postalCode;
        this.birthdayData = birthdayData;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBirthdayData() {
        return birthdayData;
    }

    public void setBirthdayData(String birthdayData) {
        this.birthdayData = birthdayData;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * sets telephone number if it only contains digits, its length is < 15
     * and (optionally) has '+' at the first position.
     * Otherwise, throws IllegalArgumentException.
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        if (telephoneNumber.length() > 15) {
            throw new IllegalArgumentException("telephone number length is too long");
        }
        if (telephoneNumber.charAt(0) != '+' && !ValidatorUtils.isDigit(telephoneNumber.charAt(0))) {
            throw new IllegalArgumentException("telephone number can only contain digits and '+'");
        }
        for (int i = 1; i < telephoneNumber.length(); ++i) {
            if (!ValidatorUtils.isDigit(telephoneNumber.charAt(i))) {
                throw new IllegalArgumentException("telephone number can only contain digits and '+'");
            }
        }
        this.telephoneNumber = telephoneNumber;
    }
}
