package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        String[] pathSplit = path.split("/");
        List<String> pathList = new ArrayList<>(Arrays.asList(pathSplit));
        if(pathList.size() == 0) return "/";

        pathList.remove(0);

        for (int i = 0; i < pathList.size();) {
            switch (pathList.get(i)) {
                case ".":
                    pathList.remove(i);
                    break;
                case "..":
                    if(i > 0) {
                        pathList.remove(i - 1);
                        pathList.remove(i - 1);
                        i -= 1;
                    } else {
                        pathList.remove(i);
                    }
                    break;
                case "":
                    pathList.remove(i);
                    break;
                default:
                    ++i;
            }
        }

        if(pathList.size() == 0) return "/";

        for(String s : pathList) {
            sb.append("/").append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = new SimplifyPath().simplifyPath("/home//foo/test/");
        System.out.println(result);
    }
}
