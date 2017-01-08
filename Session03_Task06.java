package Session03.Assignment02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Session03_Task06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter local file path");
		String localPath = sc.nextLine();
		System.out.println("Enter hdfs path.");
		String hdfsPath = sc.nextLine();
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://localhost:9000");
		
		File file = new File(localPath);
		if(!file.exists()) {
			System.out.println("File does not exists at source path.");
			System.exit(0);
		}
		
		Path srcPath = new Path(localPath);
		Path destPath = new Path(hdfsPath);
		try {
			FileSystem fs=  FileSystem.get(conf);
			fs.copyFromLocalFile(srcPath, destPath);
			System.out.println(localPath+" file copied to hdfs path : "+hdfsPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read file system configuration.");
			e.printStackTrace();
		}
		
		
	}

}
