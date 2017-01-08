package Session03.Assignment02;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Session03_Task04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String hdfsPath = sc.nextLine();
		long startTimestamp = sc.nextLong();
		long endTimestamp = sc.nextLong();
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://localhost:9000");
		FileSystem fs=  FileSystem.get(conf);
		Path path = new Path(hdfsPath);
		FileStatus[] status = fs.listStatus(path);
		System.out.println(" List of all the files and folders at this path are : ");
		for(FileStatus stat : status) {
			if(stat.getModificationTime()>= startTimestamp && stat.getModificationTime()<=endTimestamp) {
				
				System.out.println(stat.getPath().toString()+" : "+stat.getModificationTime());

			}
					
		}
		
	
		
	}

}
