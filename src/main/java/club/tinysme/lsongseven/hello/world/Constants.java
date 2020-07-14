package club.tinysme.lsongseven.hello.world;

public final class Constants {
    public static final String DATA_LOCATION;
    static {
        if (System.getProperty("os.name").startsWith("Win")) {
            DATA_LOCATION = "./";
        } else {
            DATA_LOCATION = "/data/";
        }
    }
}
