package Session03.Assignment02;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Session03_Task05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String hdfsPath = sc.nextLine();
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://localhost:9000");
		FileSystem fs=  FileSystem.get(conf);
		Path path = new Path(hdfsPath);
		FileStatus[] status = fs.listStatus(path);
		String line = "";
		for(FileStatus stat:status) {
			if(stat.isDir()) {
				System.out.println(" *** Its a directory path. Give file path.");
			System.exit(0);
			}
			if(stat.isFile()) {
				System.out.println("File Path Valid.");
				FSDataInputStream fsdi = path.getFileSystem(conf).open(path);
			while((line =fsdi.readLine())!=null) {
				System.out.println(line);
			}
			}
		}
		
	}

}
