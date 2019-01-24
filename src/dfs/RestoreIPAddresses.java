package dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ip = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if(s.length() > 12 || s.length() < 3) {
            return res;
        }

        restoreDFS(s, 0, ip, res);

        return res;
    }

    public void restoreDFS(String s, int start, List<String> ip, List<String> res) {
        if(ip.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ip.size(); i++) {
                sb.append(ip.get(i));
                if(i != ip.size()-1) {
                    sb.append(".");
                }
            }
            if(sb.length()-3 == s.length()) res.add(sb.toString());
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(start+i+1 <= s.length() && isValid(s.substring(start, start+i+1))) {
                ip.add(s.substring(start, start+i+1));
                restoreDFS(s, start+i+1, ip, res);
                ip.remove(ip.size()-1);
            }
        }
    }

    public boolean isValid(String s) {
        if(s.length() > 1 && s.charAt(0) == '0') return false;

        int subIp = Integer.valueOf(s);
        if(subIp >=0 && subIp <= 255) return true;

        return false;
    }

    public List<String> betterRestoreIPAddresses(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();

        backtracking(res, chars, new char[s.length()+4], 0, 0, 0);

        return res;
    }

    public void backtracking(List<String> res, char[] chars, char[] path, int length, int pos, int count) {
        if(count == 4) {
            if(pos == chars.length) {
                res.add(String.valueOf(path, 0, path.length-1));
            }
            
            return;
        }

        for (int i = pos, num = 0; i < chars.length && i < pos + 3; i++) {
            num = 10 * num + (chars[i] - '0');
            if(num > 255) break;
            path[length++] = chars[i];
            path[length] = '.';

            backtracking(res, chars, path, length+1, i+1, count+1);
            if(0 == num) break;
        }
    }

    public static void main(String[] args) {
        List<String> res = new RestoreIPAddresses().betterRestoreIPAddresses("25525511135");
        for(String ip: res) {
            System.out.println(ip);
        }
    }
}
