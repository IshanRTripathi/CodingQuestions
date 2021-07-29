package main.java.designPatterns.builder;

public class MainClass {
    public static void main(String[] args) {
        BuilderSimple simple= new BuilderSimple()
                .connectTimeout(10000)
                .host("Localhost")
                .password("pass")
                .port(8080)
                .readTimeout(12000)
                .useHttps(true)
                .username("ishan");

        System.out.println(simple);

//        BuilderLombok builderLombok= new BuilderLombok().
    }
}
