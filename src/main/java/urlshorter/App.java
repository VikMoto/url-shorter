package urlshorter;

import lombok.extern.slf4j.Slf4j;
import urlshorter.service.DatabaseInitService;

import java.util.Map;

@Slf4j
public class App {
    public static void main(String[] args) {
//        new DatabaseInitService().initDb();


        Map<String, String> getenv = System.getenv();

        for (Map.Entry<String, String> entry : getenv.entrySet()) {
            System.out.println("entry = " + entry);
        }

    }

}
