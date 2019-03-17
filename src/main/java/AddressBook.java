import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {

    private List<String> humans;
    //адреса храняться стрингом в формате "Улица : дом : квартира"
    private List<String> addresses;

    AddressBook() {
        humans = new ArrayList<>();
        addresses = new ArrayList<>();
    }

    AddressBook(String name, String address) {
        humans = new ArrayList<>();
        addresses = new ArrayList<>();
        addHuman(name, address);

    }

    AddressBook(String name, String street, String houseNum, String flatNum) {
        humans = new ArrayList<>();
        addresses = new ArrayList<>();
        addHuman(name, street, houseNum, flatNum);
    }

    private static boolean addressFormatChecker(String address) {
        Pattern p = Pattern.compile("([А-Яа-яA-Za-zЁё]+( )?)+( : )([0-9])+( : )([0-9]+)");
        Matcher m = p.matcher(address);
        return m.matches();
    }

    public void addHuman(String name, String address) {
        if (addressFormatChecker(address)) {
            addresses.add(address);
            humans.add(name);
        } else
            System.out.println("Не получилось добавить человека и его адрес. Неверный тип адреса");
    }
    public void addHuman(String name, String street, String houseNum, String flatNum) {
        humans.add(name);
        addresses.add(street + " : " + houseNum + " : " + flatNum);
    }

    public void deleteHuman(String name) {
        int index = humans.indexOf(name);
        addresses.remove(index);
        humans.remove(index);
    }

    public void setNewAddress(String name, String address) {
        if (addressFormatChecker(address))
            addresses.set(humans.indexOf(name), address);
        else
            System.out.println("Не получилось изменить адрес, неверный тип");
    }

    public void setNewAddress(String name, String street, String houseNum, String flatNum) {
        addresses.set(humans.indexOf(name), street + " : " + houseNum + " : " + flatNum);
    }

    public String getAddress(String name) {
        return humans.get(humans.indexOf(name));
    }

    public List<String> searchByAddress(String street) {
        List<String> res = new ArrayList();
        for (int i = 0; i < humans.size(); i++) {
            if (street.equals(addresses.get(i).split(" : ")[0]))
                res.add(humans.get(i));
        }
        return res;
    }

    public List<String> searchByAdress(String street, String houseNum) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            if (street.equals(addresses.get(i).split(" : ")[0]))
                if (houseNum.equals(addresses.get(i).split(" : ")[1]))
                    res.add(humans.get(i));
        }
        return res;
    }

        public String toString() {
            StringBuilder bldr = new StringBuilder();
            for (String human : humans) {
                String[] splited = addresses.get(humans.indexOf(human)).split(" : ");
                bldr.append(human).append(" - ")
                        .append(splited[0]).append(" : ")
                        .append(splited[1]).append(" : ")
                        .append(splited[2]).append("\n");
            }
            return bldr.toString();
        }

    }
