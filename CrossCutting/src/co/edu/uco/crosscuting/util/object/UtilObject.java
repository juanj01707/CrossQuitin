package co.edu.uco.crosscuting.util.object;

public class UtilObject {
	
	private static final UtilObject INSTANCE = new UtilObject();
    private UtilObject(){

    }

    public static UtilObject getUtilObject(){
        return INSTANCE;
    }
    public static <T>boolean isNull(T object){
        return object==null;
    }

    public static <T> T getDefault(T object, T defaultValue){
        return isNull(object) ? defaultValue : object;
    }

}
