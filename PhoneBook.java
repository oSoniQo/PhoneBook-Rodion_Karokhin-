import java.util.*;
public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phonebook = getPhonebook();
        addContact(phonebook, "Bob", "12345");
        addContact(phonebook, "John", "67890");
        addContact(phonebook, "John", "13579");
        addContact(phonebook, "Alice", "24680");
        addContact(phonebook, "Kristy", "00000");
        removePhone(phonebook, "Kristy", "00000");
        print(phonebook);
        removeContact(phonebook, "Bob");
        print(phonebook);
        searchContact(phonebook, "John");
    }
    public static HashMap<String, ArrayList<String>> getPhonebook() {
        HashMap<String, ArrayList<String>> phonebook = new HashMap<>();
        return phonebook;
    }
    public static void addContact(HashMap<String, ArrayList<String>> phonebook, String name, String phone) {
        if (phonebook.containsKey(name)) {
        ArrayList<String> list = phonebook.get(name);
        list.add(phone);
        phonebook.put(name, list);
        }
        else {
            ArrayList<String> list = new ArrayList<>();
            list.add(phone);
            phonebook.put(name, list);
        }
    }
    public static void removeContact(HashMap<String, ArrayList<String>> phonebook, String name) {
        if (phonebook.containsKey(name)) {
            phonebook.remove(name);
        }
    }
    public static void removePhone(HashMap<String, ArrayList<String>> phonebook, String name, String phone) {
        if (phonebook.containsKey(name)) {
            ArrayList<String> list = phonebook.get(name);
            if (list.contains(phone)) {
            list.remove(phone);
            phonebook.put(name, list);
            }
        }  
    }
    public static void searchContact(HashMap<String, ArrayList<String>> phonebook, String name) {
        System.out.println("Results: ");
        for (var item : phonebook.entrySet()) {
            if (item.getKey() == name) {
            System.out.println(item.getKey()+" "+item.getValue());
            }
        }
    }
    public static void print(HashMap<String, ArrayList<String>> phonebook) {
        ArrayList<Integer> lst1 = new ArrayList<>();
        for (var item : phonebook.entrySet()) {
            lst1.add(item.getValue().size());
        }
        Collections.sort(lst1);
        Set<Integer> set = new HashSet<>(lst1);
        ArrayList<Integer> lst2 = new ArrayList<>(set);
        for (int i = set.size()-1; i >= 0; i--) {
            for (var item : phonebook.entrySet()) {
                if (item.getValue().size() == lst2.get(i)) {
                    System.out.println(item.getKey()+" "+phonebook.get(item.getKey()));
                }
            } 
        }
    }
}
