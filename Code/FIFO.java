// From: https://blog.csdn.net/ljw_study_in_csdn/article/details/104627246
import java.io.*;
import java.util.*;//自定义Read类中需要用到io和util这两个包，星号*(通配符)表示包中所有的类
import java.math.*;//含大数BigInteger

public class FIFO {
	public static void main(String [] args) {
		Read cin=new Read(System.in);
		//code...
	}
}

class Read {//自定义快读 Read
	
    public BufferedReader reader;
    public StringTokenizer tokenizer;
    
    public Read(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }
    
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public Double nextDouble() {
        return Double.parseDouble(next());
    }

    public BigInteger nextBigInteger() {
        return new BigInteger(next());
    }
}

/*
StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

// 输入
in.nextToken();
int n = (int)in.nval;

// 输出
out.println(n);
out.flush();
*/