package lesson35.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Filter {

    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;

    private String country;
    private String city;

    public Filter(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, String country, String city) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;

        this.country = country;
        this.city = city;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filter filter = (Filter) o;

        if (numberOfGuests != filter.numberOfGuests) return false;
        if (Double.compare(filter.price, price) != 0) return false;
        if (breakfastIncluded != filter.breakfastIncluded) return false;
        if (petsAllowed != filter.petsAllowed) return false;
        if (!dateAvailableFrom.equals(filter.dateAvailableFrom)) return false;
        if (!country.equals(filter.country)) return false;
        return city.equals(filter.city);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = numberOfGuests;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (breakfastIncluded ? 1 : 0);
        result = 31 * result + (petsAllowed ? 1 : 0);
        result = 31 * result + dateAvailableFrom.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + (new SimpleDateFormat("dd-MM-yyyy")).format(dateAvailableFrom)+
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
