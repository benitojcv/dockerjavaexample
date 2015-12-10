package dockerjavaexample;

import static spark.Spark.get;
import static spark.Spark.port;

public class HelloWorld {
    public static void main(String[] args) {
    	port(9090);
    	
        get("/hello", (req, res) -> "Hello World");
    }
}
