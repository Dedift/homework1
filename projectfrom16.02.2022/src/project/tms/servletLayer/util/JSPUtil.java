package project.tms.servletLayer.util;

public final class JSPUtil {

    private static final String USER_PREFIX = "/jsp/user/";
    private static final String SUFFIX = ".jsp";

    private JSPUtil(){
        throw new UnsupportedOperationException();
    }

    public static String getUserJSPPath(String jspName){
        return USER_PREFIX + jspName + SUFFIX;
    }
}
