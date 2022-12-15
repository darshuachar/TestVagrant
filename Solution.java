// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    public static class NewsPaper {
        double [] week = new double[7];
        double total = 0.0;
        String name;
        NewsPaper(double[] price, String name) {
            this.name = name;
            for(int n=0; n<week.length; n++) {
                week[n] = price[n];
                total += week[n];
            }
        }
    }
    static void solve(double ip, NewsPaper[] arr, int it, ArrayList<String> ans) {
        //ArrayList<String> ans = new ArrayList<>();
        for(int n=0; n<arr.length; n++) {
            if(n == it) continue;
            else if(ip >= arr[n].total) {
                ip = ip - arr[n].total;
                ans.add(arr[n].name);
            }
        }
        //return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double[] one = {3,3,3,3,3,5,6};
        double[] two = {2.5,2.5,2.5,2.5,2.5,4,4};
        double[] three = {4,4,4,4,4,4,10};
        double[] four = {1.5,1.5,1.5,1.5,1.5,1.5,1.5};
        double[] five = {2,2,2,2,2,4,4};

        NewsPaper toi = new NewsPaper(one, "toi");//26
        NewsPaper hindu = new NewsPaper(two, "hindu");//20.5
        NewsPaper et = new NewsPaper(three, "et");//24
        NewsPaper bm = new NewsPaper(four, "bm");
        NewsPaper ht = new NewsPaper(five, "ht");
        NewsPaper arr[] = {toi, hindu, et, bm, ht};


        double input = scn.nextInt();

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(int n=0; n<arr.length; n++) {
            double val = input - arr[n].total;
            ArrayList<String> ans = new ArrayList<>();
            ans.add(arr[n].name);
            solve(val, arr, n, ans);
            if(ans.size() > 0)
                res.add(ans);
        }
        System.out.println(res);
    }
}