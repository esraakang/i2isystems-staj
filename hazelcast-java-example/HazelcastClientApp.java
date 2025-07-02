import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastClientApp {

    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Integer, Person> map = client.getMap("people");

        
        for (int i = 1; i <= 10000; i++) {
            map.put(i, new Person("Person-" + i));
        }

        
        System.out.println("First 5 Persons:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(map.get(i));
        }

        System.out.println("...");

        System.out.println("Last 5 Persons:");
        for (int i = 9996; i <= 10000; i++) {
            System.out.println(map.get(i));
        }

        client.shutdown();
    }
}
