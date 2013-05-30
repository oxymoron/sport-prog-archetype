/*
 * Author: Andrey Zubkov
 */

import java.io.*;
import java.lang.Integer;
import java.util.*;
import java.util.StringTokenizer;

class Main implements Runnable{

    static String ReadLn(int maxLength){
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break;
                line [length++] += input;
            }
            if ((input < 0) && (length == 0)) return null;
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[]){
        Main myWork = new Main();
        myWork.run();
    }

    public void run() {
        new Algorithm().run();
    }
}


class Algorithm implements Runnable{

    public static final int LINE_LENGTH = 1000;

    static class Test{
        public int a;
        public int b;
    }

    static class Solution{
        public int result;
    }

    private List<Test> tests = new ArrayList<Test>();
    private List<Solution> solutions = new ArrayList<Solution>();

    public void run(){
        readTests();
        solve();
        writeSolutions();
    }

    private void writeSolutions() {
        for (Solution solution : solutions) {
            System.out.println(solution.result);
        }
    }

    private void solve() {
        for (Test test : tests) {
            solveOne(test);
        }
    }

    private void solveOne(Test test) {
        Solution s = new Solution();
        s.result = test.a + test.b;
        solutions.add(s);
    }

    private void readTests() {
        String line;
        while((line = readLine()) != null){
            Test test = new Test();
            StringTokenizer tokenizer = new StringTokenizer(line);
            test.a = Integer.parseInt(tokenizer.nextToken());
            test.b = Integer.parseInt(tokenizer.nextToken());
            tests.add(test);
        }
    }

    private String readLine() {
        return Main.ReadLn(LINE_LENGTH);
    }
}
