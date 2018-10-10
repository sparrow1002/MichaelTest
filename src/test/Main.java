package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		BufferedWriter wrider = null;
		try {
			// 讀
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("C:\\Users\\Michael.Cheng\\Desktop\\文字資料\\news_utf8.txt"), "UTF-8")); // 指定讀取文件的編碼格式，以免出現中文亂碼
			
			// 寫
			File file = new File("C:\\Users\\Michael.Cheng\\Desktop\\文字資料\\text_big5.txt");
			wrider = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, true), "BIG5"));
			
			String str = null;
			while ((str = reader.readLine()) != null) {
				System.out.println(str);
				wrider.append(str);
				wrider.newLine();
			}
			wrider.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
