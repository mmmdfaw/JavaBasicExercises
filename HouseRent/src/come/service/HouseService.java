package come.service;

import come.domain.*;
import come.utils.Utility;

public class HouseService {
    private House[] houses;
    private int houseNums = 0;
    private int idCount = 0;

    public HouseService(int size) {
        houses = new House[size];
    }

    public House[] list() {
        return houses;
    }

    public boolean modifyHouse(int modifyId) {
        if (modifyId > idCount || modifyId <= 0) return false;
        modifyId--;
        String nameTemp = houses[modifyId].getName();
        String phoneNumberTemp = houses[modifyId].getPhoneNumber();
        String addressTemp = houses[modifyId].getAddress();
        int rentPriceTemp = houses[modifyId].getRentPrice();
        String stateTemp = houses[modifyId].getState();
        System.out.print("姓名" + "(" + nameTemp + "):");
        nameTemp = Utility.readString(8, nameTemp);
        houses[modifyId].setName(nameTemp);
        System.out.print("电话" + "(" + phoneNumberTemp + "):");
        phoneNumberTemp = Utility.readString(11, phoneNumberTemp);
        houses[modifyId].setPhoneNumber(phoneNumberTemp);
        System.out.print("地址" + "(" + addressTemp + "):");
        addressTemp = Utility.readString(3, addressTemp);
        houses[modifyId].setAddress(addressTemp);
        System.out.print("租金" + "(" + rentPriceTemp + "):");
        rentPriceTemp = Utility.readInt(rentPriceTemp);
        houses[modifyId].setRentPrice(rentPriceTemp);
        System.out.print("状态" + "(" + stateTemp + "):");
        stateTemp = Utility.readString(3, stateTemp);
        houses[modifyId].setState(stateTemp);
        return true;
    }

    public House findHouse(int findId) {
        if (findId > idCount || findId <= 0) return null;
        else return houses[findId - 1];
    }

    public boolean del(int delId) {
        //原理是：先把不用删除的元素赋值给temp数组然后再把temp的元素赋回houses
        if (delId > idCount || delId < 0) return false;
        //如果delId比当前的id还要大或者是小于0的话肯定是删不了的

        House[] temp = new House[houses.length - 1];//删除了一个房数组就要少一个
        int index = 1;//index表示删除后的id
        boolean isDel = false;//表示是否已经删除了，默认是还没有删除
        for (int i = 0; i < houses.length; i++) {
            if (index == delId && !isDel) {
                isDel = true;
                continue;
            }
            temp[index - 1] = houses[i];//注意下标
            temp[index - 1].setId(index);//设置一下id
            index++;
        }
        houses = temp;
        idCount--;//都删除了一个了肯定要减一
        houseNums--;//要不然的话删除后再使用添加功能就会出错
        return true;
    }

    public void addNewHouse(House newHouse) {
        //数组的扩大
        House[] temp = new House[houses.length + 1];
        for (int i = 0; i < houses.length; i++) {
            temp[i] = houses[i];
        }
        newHouse.setId(++idCount);
        temp[houses.length] = newHouse;
        houses = temp;
        houseNums++;
    }
}
