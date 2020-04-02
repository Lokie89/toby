package numbertest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

//    public int calcSum(String filePath) throws IOException {
//        BufferedReader br = null;
//        try {
//
//            br = new BufferedReader(new FileReader(filePath));
//            Integer sum = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                sum += Integer.valueOf(line);
//            }
//            return sum;
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            throw e;
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//
//        }
//    }

//    public int calcSum(String filePath) throws IOException {
//        BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
//            @Override
//            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
//                Integer sum = 0;
//                String line;
//                while ((line = br.readLine()) != null) {
//                    sum += Integer.valueOf(line);
//                }
//                return sum;
//            }
//        };
//        return fileReadTemplate(filePath, sumCallback);
//    }

    public int calcSum(String filePath) throws IOException {
        LineCallback<Integer> lineCallback = new LineCallback<Integer>() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value + Integer.valueOf(line);
            }
        };
        return lineReadTemplate(filePath, lineCallback, 0);
    }

    public Integer fileReadTemplate(String filePath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(filePath));
            Integer sum = callback.doSomethingWithReader(br);
            return sum;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }

    public <T> T lineReadTemplate(String filePath, LineCallback<T> lineCallback, T initValue) throws IOException {
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(filePath));
            T res = initValue;
            String line;
            while ((line = br.readLine()) != null) {
                res = lineCallback.doSomethingWithLine(line, res);
            }
            return res;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }

//    public int calcMultiply(String filePath) throws IOException {
//        BufferedReaderCallback multiplyCallBack = new BufferedReaderCallback() {
//            @Override
//            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
//                Integer sum = 1;
//                String line;
//                while ((line = br.readLine()) != null) {
//                    sum *= Integer.valueOf(line);
//                }
//                return sum;
//            }
//        };
//        return fileReadTemplate(filePath, multiplyCallBack);
//    }

    public int calcMultiply(String filePath) throws IOException {
        LineCallback<Integer> lineCallback = new LineCallback<Integer>() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value * Integer.valueOf(line);
            }
        };
        return lineReadTemplate(filePath, lineCallback, 1);
    }

    public String concatenate(String filePath) throws IOException {
        LineCallback<String> lineCallback = new LineCallback<String>() {
            @Override
            public String doSomethingWithLine(String line, String value) {
                return value + line;
            }
        };
        return lineReadTemplate(filePath, lineCallback, "");
    }
}
