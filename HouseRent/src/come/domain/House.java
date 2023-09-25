package come.domain;

public class House {
    //编号，房主，电话，地址，月租，状态（月租/已出租）
    private int id = 0;
    private String name;
    private String phoneNumber;
    private String address;
    private int rentPrice;
    private String state;

    public House(int id, String name, String phoneNumber, String address, int rentPrice, String state) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rentPrice = rentPrice;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id + " \t\t" + name + "    \t" + phoneNumber + "   \t" +
                address + "  \t" + rentPrice + "     \t" + state;
    }
}
