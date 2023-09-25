package come.view;

import come.domain.House;
import come.service.HouseService;
import come.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char ops;
    private HouseService houseService = new HouseService(0);

    public void modify(){
        System.out.println("=============修改房屋============");
        System.out.print("请输入你想修改的id(-1退出)：");
        int id=Utility.readInt();
        while (id == -1) {
            char isExit = Utility.readConfirmSelection();
            if (isExit == 'Y') {
                System.out.println("---------你放弃了修改房屋----------");
                return;
            } else {
                System.out.print("请输入需要修改房屋的编号（-1退出）：");
                id = Utility.readInt();
            }
        }
        if(houseService.modifyHouse(id)){
            System.out.println("---------你成功修改了房屋----------");
        }
        else{
            System.out.println("============修改房屋失败，请检验后再试============");
        }
    }
    public void find(){
        System.out.println("=============查找房屋============");
        System.out.print("请输入你想查找的id：");
        int id=Utility.readInt();
        if(houseService.findHouse(id)!=null){
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
            System.out.println(houseService.findHouse(id));
        }
        else{
            System.out.println("============查找房屋失败，请检验后再试============");
        }
    }
    public void exit(){
        char c = Utility.readConfirmSelection();
        if(c=='Y'){
            loop=false;
        }
    }
    public void delHouse() {
        System.out.println("=============删除房屋=============");
        System.out.print("请输入需要删除房屋的编号（-1退出）：");
        int delId = Utility.readInt();
        while (delId == -1) {
            char isExit = Utility.readConfirmSelection();
            if (isExit == 'Y') {
                System.out.println("---------你放弃了删除房屋----------");
                return;
            } else {
                System.out.print("请输入需要删除房屋的编号（-1退出）：");
                delId = Utility.readInt();
            }
        }
        if (houseService.del(delId)) {
            System.out.println("============删除房屋成功============");
        } else {
            System.out.println("============删除房屋失败，请检验后再试============");
        }
    }

    public void addHouse() {
        System.out.println("=============添加房屋=============");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phoneNumber = Utility.readString(11);
        System.out.print("地址：");
        String address = Utility.readString(3);
        System.out.print("月租：");
        int rentPrice = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House newHouse = new House(0, name, phoneNumber, address, rentPrice, state);
        houseService.addNewHouse(newHouse);
        System.out.println("============添加房屋成功============");
    }

    public void listHouses() {
        House[] houses = houseService.list();
        if(houses.length==0){
            System.out.println("你没有任何房屋，请检验后再试！");
            return;
        }
        System.out.println("-------------房屋列表-------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("-------------房屋列表显示完毕-------------");
    }

    public void mainView() {
        while (loop) {
            System.out.println("=============房屋出租系统菜单=============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.print("请输入你的选择（1-6）： ");
            ops = Utility.readMenuSelection();
            if (ops == '1') {
                addHouse();
            } else if (ops == '2') {
                find();
            } else if (ops == '3') {
                delHouse();
            } else if (ops == '4') {
                modify();
            } else if (ops == '5') {
                listHouses();
            } else if (ops == '6') {
                exit();
            }
        }
    }
}
